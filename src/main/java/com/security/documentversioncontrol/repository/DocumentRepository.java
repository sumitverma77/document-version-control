package com.security.documentversioncontrol.repository;

import com.security.documentversioncontrol.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("SELECT d FROM Document d WHERE d.name = :name ORDER BY d.version DESC LIMIT 1")
    Document findByName(String name);
}
