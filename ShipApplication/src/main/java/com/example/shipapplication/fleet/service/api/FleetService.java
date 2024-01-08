package com.example.shipapplication.fleet.service.api;

import com.example.shipapplication.fleet.entity.Fleet;

import java.util.Optional;
import java.util.UUID;

public interface FleetService {

    Optional<Fleet> find(UUID id);
    void create(Fleet fleet);
    void update(Fleet fleet);
    void delete(UUID id);
}
