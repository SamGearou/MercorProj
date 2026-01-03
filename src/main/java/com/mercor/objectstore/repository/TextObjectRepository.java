package com.mercor.objectstore.repository;

import com.mercor.objectstore.model.TextObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TextObjectRepository extends JpaRepository<TextObject, Long> {
    Optional<TextObject> findByKey(String key);
    boolean existsByKey(String key);
    void deleteByKey(String key);
}