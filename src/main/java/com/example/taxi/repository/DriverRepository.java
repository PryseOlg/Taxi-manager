package com.example.taxi.repository;

import com.example.taxi.models.Driver;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DriverRepository extends Neo4jRepository<Driver, Long> {
    @Transactional
    void deleteDriverById(long id);
}
