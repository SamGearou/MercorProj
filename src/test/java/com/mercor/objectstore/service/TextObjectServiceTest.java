package com.mercor.objectstore.service;

import com.mercor.objectstore.model.TextObject;
import com.mercor.objectstore.repository.TextObjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TextObjectServiceTest {

    @Mock
    private TextObjectRepository repository;

    @InjectMocks
    private TextObjectService service;

    private TextObject testObject;
    private String testKey;
    private String testContent;

    @BeforeEach
    void setUp() {
        testKey = "test-key";
        testContent = "test content";
        testObject = new TextObject(testKey, testContent);
        testObject.setId(1L);
        testObject.setCreatedAt(LocalDateTime.now());
    }

    @Test
    void testSave_NewObject() {
        // Given
        when(repository.findByKey(testKey)).thenReturn(Optional.empty());
        when(repository.save(any(TextObject.class))).thenAnswer(invocation -> {
            TextObject obj = invocation.getArgument(0);
            obj.setId(1L);
            return obj;
        });

        // When
        TextObject result = service.save(testKey, testContent);

        // Then
        assertNotNull(result);
        assertEquals(testKey, result.getKey());
        assertEquals(testContent, result.getContent());
        assertNotNull(result.getCreatedAt());
        verify(repository, times(1)).findByKey(testKey);
        verify(repository, times(1)).save(any(TextObject.class));
    }

    @Test
    void testSave_UpdateExistingObject() {
        // Given
        String updatedContent = "updated content";
        when(repository.findByKey(testKey)).thenReturn(Optional.of(testObject));
        when(repository.save(any(TextObject.class))).thenReturn(testObject);

        // When
        TextObject result = service.save(testKey, updatedContent);

        // Then
        assertNotNull(result);
        assertEquals(testKey, result.getKey());
        assertEquals(updatedContent, result.getContent());
        verify(repository, times(1)).findByKey(testKey);
        verify(repository, times(1)).save(testObject);
    }

    @Test
    void testFindByKey_ObjectExists() {
        // Given
        when(repository.findByKey(testKey)).thenReturn(Optional.of(testObject));

        // When
        Optional<TextObject> result = service.findByKey(testKey);

        // Then
        assertTrue(result.isPresent());
        assertEquals(testObject, result.get());
        verify(repository, times(1)).findByKey(testKey);
    }

    @Test
    void testFindByKey_ObjectNotExists() {
        // Given
        when(repository.findByKey(testKey)).thenReturn(Optional.empty());

        // When
        Optional<TextObject> result = service.findByKey(testKey);

        // Then
        assertFalse(result.isPresent());
        verify(repository, times(1)).findByKey(testKey);
    }

    @Test
    void testFindAll() {
        // Given
        TextObject object1 = new TextObject("key1", "content1");
        TextObject object2 = new TextObject("key2", "content2");
        List<TextObject> objects = Arrays.asList(object1, object2);
        when(repository.findAll()).thenReturn(objects);

        // When
        List<TextObject> result = service.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(objects, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    void testExistsByKey_Exists() {
        // Given
        when(repository.existsByKey(testKey)).thenReturn(true);

        // When
        boolean result = service.existsByKey(testKey);

        // Then
        assertTrue(result);
        verify(repository, times(1)).existsByKey(testKey);
    }

    @Test
    void testExistsByKey_NotExists() {
        // Given
        when(repository.existsByKey(testKey)).thenReturn(false);

        // When
        boolean result = service.existsByKey(testKey);

        // Then
        assertFalse(result);
        verify(repository, times(1)).existsByKey(testKey);
    }

    @Test
    void testDeleteByKey() {
        // Given
        doNothing().when(repository).deleteByKey(testKey);

        // When
        service.deleteByKey(testKey);

        // Then
        verify(repository, times(1)).deleteByKey(testKey);
    }

    @Test
    void testSave_EmptyKey() {
        // Given
        String emptyKey = "";
        when(repository.findByKey(emptyKey)).thenReturn(Optional.empty());
        when(repository.save(any(TextObject.class))).thenAnswer(invocation -> {
            TextObject obj = invocation.getArgument(0);
            obj.setId(1L);
            return obj;
        });

        // When
        TextObject result = service.save(emptyKey, testContent);

        // Then
        assertNotNull(result);
        assertEquals(emptyKey, result.getKey());
        verify(repository, times(1)).findByKey(emptyKey);
    }

    @Test
    void testSave_NullContent() {
        // Given
        when(repository.findByKey(testKey)).thenReturn(Optional.empty());
        when(repository.save(any(TextObject.class))).thenAnswer(invocation -> {
            TextObject obj = invocation.getArgument(0);
            obj.setId(1L);
            return obj;
        });

        // When
        TextObject result = service.save(testKey, null);

        // Then
        assertNotNull(result);
        assertNull(result.getContent());
        verify(repository, times(1)).findByKey(testKey);
    }
}

