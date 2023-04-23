package com.example.taxi.repository;

import com.example.taxi.models.DriverLicense;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DriverLicenceRepository extends Neo4jRepository<DriverLicense, Long> {
    DriverLicense findDriverLicenseByDriverId(long driverId);

    @Transactional
    void deleteByDriverId(long driverId);

    boolean existsByNumber(long number);

    DriverLicense findByNumber(long number);
}
