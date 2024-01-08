package com.example.fleetaplication.fleet.event.repository.api;

import com.example.fleetaplication.fleet.entity.Fleet;

import java.util.UUID;

public interface FleetEventRepository {
    void delete(UUID id);
    void save(Fleet fleet);
    void update(Fleet fleet);
}
