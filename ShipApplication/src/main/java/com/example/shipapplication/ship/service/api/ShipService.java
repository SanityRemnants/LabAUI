package com.example.shipapplication.ship.service.api;

import com.example.shipapplication.ship.entity.Ship;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShipService {
    void update(Ship ship);
    void create(Ship ship);
    void delete(UUID id);
    void delete(String name);
    Optional<Ship> find(UUID id);
    List<Ship> findAll();
    Optional<List<Ship>> findAllByFleet(UUID fleetId);


    List<Ship> findAllByName(String name);
    Optional<Ship> findByName(String name);
}

