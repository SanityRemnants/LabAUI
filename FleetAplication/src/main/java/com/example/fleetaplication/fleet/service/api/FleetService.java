package com.example.fleetaplication.fleet.service.api;

import com.example.fleetaplication.fleet.entity.Fleet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FleetService {
    void update(Fleet fleet);
    void create(Fleet fleet);
    void delete(UUID id);
    void delete(String fleetName);
    Optional<Fleet> find(UUID id);
    Optional<Fleet> findByName(String fleetName);

    List<Fleet> findAll();
}
