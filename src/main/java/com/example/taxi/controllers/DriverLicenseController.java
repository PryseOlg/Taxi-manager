package com.example.taxi.controllers;

import com.example.taxi.models.DriverLicense;
import com.example.taxi.service.DriverLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver/{driverId}/license")
public class DriverLicenseController {
    private final DriverLicenseService service;

    @Autowired
    public DriverLicenseController(DriverLicenseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getLicense(@PathVariable("driverId") long driverId) {
        return ResponseEntity.ok(service.getLicenseByDriverId(driverId));
    }

    @PostMapping
    public ResponseEntity<?> createLicense(@PathVariable("driverId") long driverId,
                                           @RequestBody DriverLicense license) {
        return ResponseEntity.ok(service.createLicense(driverId, license));
    }

    @PutMapping
    public ResponseEntity<?> updateLicense(@PathVariable("driverId") long driverId,
                                           @RequestBody DriverLicense license) {
        service.updateLicenseById(driverId, license);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteLicense(@PathVariable("driverId") long driverId) {
        service.deleteLicenseByDriverId(driverId);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<?> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
