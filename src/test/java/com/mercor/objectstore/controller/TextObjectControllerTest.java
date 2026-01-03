package com.mercor.objectstore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercor.objectstore.model.TextObject;
import com.mercor.objectstore.service.MetricsService;
import com.mercor.objectstore.service.TextObjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class TextObjectControllerTest {

    @Mock
    private TextObjectService service;

    @Mock
    private MetricsService metricsService;

    @InjectMocks
    private TextObjectController controller;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private TextObject testObject;
    private String testKey;
    private String testContent;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
        testKey = "test-key";
        testContent = "test content";
        testObject = new TextObject(testKey, testContent);
        testObject.setId(1L);
        testObject.setCreatedAt(LocalDateTime.now());
        
        // Mock metrics service methods to avoid NullPointerException (lenient to avoid unnecessary stubbing warnings)
        lenient().doNothing().when(metricsService).incrementObjectCreated();
        lenient().doNothing().when(metricsService).incrementObjectUpdated();
        lenient().doNothing().when(metricsService).incrementObjectDeleted();
        lenient().doNothing().when(metricsService).incrementObjectRetrieved();
    }

    @Test
    void testCreateOrUpdate_Success() throws Exception {
        // Given
        Map<String, String> request = new HashMap<>();
        request.put("key", testKey);
        request.put("content", testContent);
        when(service.save(testKey, testContent)).thenReturn(testObject);

        // When & Then
        mockMvc.perform(post("/api/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.key").value(testKey))
                .andExpect(jsonPath("$.content").value(testContent));

        verify(service, times(1)).save(testKey, testContent);
    }

    @Test
    void testCreateOrUpdate_MissingKey() throws Exception {
        // Given
        Map<String, String> request = new HashMap<>();
        request.put("content", testContent);

        // When & Then
        mockMvc.perform(post("/api/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        verify(service, never()).save(anyString(), anyString());
    }

    @Test
    void testCreateOrUpdate_EmptyKey() throws Exception {
        // Given
        Map<String, String> request = new HashMap<>();
        request.put("key", "");
        request.put("content", testContent);

        // When & Then
        mockMvc.perform(post("/api/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        verify(service, never()).save(anyString(), anyString());
    }

    @Test
    void testCreateOrUpdate_WhitespaceKey() throws Exception {
        // Given
        Map<String, String> request = new HashMap<>();
        request.put("key", "   ");
        request.put("content", testContent);

        // When & Then
        mockMvc.perform(post("/api/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        verify(service, never()).save(anyString(), anyString());
    }

    @Test
    void testCreateOrUpdate_MissingContent() throws Exception {
        // Given
        Map<String, String> request = new HashMap<>();
        request.put("key", testKey);

        // When & Then
        mockMvc.perform(post("/api/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        verify(service, never()).save(anyString(), anyString());
    }

    @Test
    void testCreateOrUpdate_NullContent() throws Exception {
        // Given
        Map<String, String> request = new HashMap<>();
        request.put("key", testKey);
        request.put("content", null);

        // When & Then
        mockMvc.perform(post("/api/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        verify(service, never()).save(anyString(), anyString());
    }

    @Test
    void testGetByKey_Success() throws Exception {
        // Given
        when(service.findByKey(testKey)).thenReturn(Optional.of(testObject));

        // When & Then
        mockMvc.perform(get("/api/objects/{key}", testKey))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.key").value(testKey))
                .andExpect(jsonPath("$.content").value(testContent));

        verify(service, times(1)).findByKey(testKey);
    }

    @Test
    void testGetByKey_NotFound() throws Exception {
        // Given
        when(service.findByKey(testKey)).thenReturn(Optional.empty());

        // When & Then
        mockMvc.perform(get("/api/objects/{key}", testKey))
                .andExpect(status().isNotFound());

        verify(service, times(1)).findByKey(testKey);
    }

    @Test
    void testGetAll_Success() throws Exception {
        // Given
        TextObject object1 = new TextObject("key1", "content1");
        object1.setId(1L);
        TextObject object2 = new TextObject("key2", "content2");
        object2.setId(2L);
        List<TextObject> objects = Arrays.asList(object1, object2);
        when(service.findAll()).thenReturn(objects);

        // When & Then
        mockMvc.perform(get("/api/objects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].key").value("key1"))
                .andExpect(jsonPath("$[1].key").value("key2"));

        verify(service, times(1)).findAll();
    }

    @Test
    void testGetAll_EmptyList() throws Exception {
        // Given
        when(service.findAll()).thenReturn(Arrays.asList());

        // When & Then
        mockMvc.perform(get("/api/objects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

        verify(service, times(1)).findAll();
    }

    @Test
    void testDeleteByKey_Success() throws Exception {
        // Given
        when(service.existsByKey(testKey)).thenReturn(true);
        doNothing().when(service).deleteByKey(testKey);

        // When & Then
        mockMvc.perform(delete("/api/objects/{key}", testKey))
                .andExpect(status().isNoContent());

        verify(service, times(1)).existsByKey(testKey);
        verify(service, times(1)).deleteByKey(testKey);
    }

    @Test
    void testDeleteByKey_NotFound() throws Exception {
        // Given
        when(service.existsByKey(testKey)).thenReturn(false);

        // When & Then
        mockMvc.perform(delete("/api/objects/{key}", testKey))
                .andExpect(status().isNotFound());

        verify(service, times(1)).existsByKey(testKey);
        verify(service, never()).deleteByKey(anyString());
    }

    @Test
    void testCreateOrUpdate_UpdateExisting() throws Exception {
        // Given
        String updatedContent = "updated content";
        Map<String, String> request = new HashMap<>();
        request.put("key", testKey);
        request.put("content", updatedContent);
        testObject.setContent(updatedContent);
        testObject.setUpdatedAt(LocalDateTime.now());
        when(service.save(testKey, updatedContent)).thenReturn(testObject);

        // When & Then
        mockMvc.perform(post("/api/objects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(updatedContent));

        verify(service, times(1)).save(testKey, updatedContent);
    }

    @Test
    void testControllerMethods_DirectCall() {
        // Test createOrUpdate with valid data
        Map<String, String> request = new HashMap<>();
        request.put("key", testKey);
        request.put("content", testContent);
        when(service.save(testKey, testContent)).thenReturn(testObject);

        ResponseEntity<TextObject> response = controller.createOrUpdate(request);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(testObject, response.getBody());

        // Test getByKey with existing object
        when(service.findByKey(testKey)).thenReturn(Optional.of(testObject));
        ResponseEntity<TextObject> getResponse = controller.getByKey(testKey);
        assertEquals(200, getResponse.getStatusCode().value());
        assertEquals(testObject, getResponse.getBody());

        // Test getByKey with non-existing object
        when(service.findByKey("non-existent")).thenReturn(Optional.empty());
        ResponseEntity<TextObject> notFoundResponse = controller.getByKey("non-existent");
        assertEquals(404, notFoundResponse.getStatusCode().value());

        // Test getAll
        List<TextObject> objects = Arrays.asList(testObject);
        when(service.findAll()).thenReturn(objects);
        ResponseEntity<List<TextObject>> getAllResponse = controller.getAll();
        assertEquals(200, getAllResponse.getStatusCode().value());
        assertEquals(objects, getAllResponse.getBody());

        // Test deleteByKey success
        when(service.existsByKey(testKey)).thenReturn(true);
        doNothing().when(service).deleteByKey(testKey);
        ResponseEntity<Void> deleteResponse = controller.deleteByKey(testKey);
        assertEquals(204, deleteResponse.getStatusCode().value());

        // Test deleteByKey not found
        when(service.existsByKey("non-existent")).thenReturn(false);
        ResponseEntity<Void> deleteNotFoundResponse = controller.deleteByKey("non-existent");
        assertEquals(404, deleteNotFoundResponse.getStatusCode().value());
    }
}

