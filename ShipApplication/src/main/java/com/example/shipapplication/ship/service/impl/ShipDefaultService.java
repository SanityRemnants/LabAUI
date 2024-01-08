package com.example.shipapplication.ship.service.impl;

import com.example.shipapplication.fleet.repository.api.FleetRepository;
import com.example.shipapplication.ship.entity.Ship;
import com.example.shipapplication.ship.repository.api.ShipRepository;
import com.example.shipapplication.ship.service.api.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShipDefaultService implements ShipService {
    private final ShipRepository repository;
    private final FleetRepository fleetRepository;

    @Autowired
    public ShipDefaultService(ShipRepository repository, FleetRepository fleetRepository) {
        this.repository = repository;
        this.fleetRepository = fleetRepository;
    }
    @Override
    public void update(Ship ship) {
        repository.save(ship);
    }

    @Override
    public void create(Ship ship) {
        repository.save(ship);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void delete(String name) {
        repository.findByName(name).ifPresent(repository::delete);
    }

    @Override
    public Optional<Ship> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Ship> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Ship>> findAllByFleet(UUID fleetId) {
        return fleetRepository.findById(fleetId).map(repository::findAllByFleet);
    }

    @Override
    public List<Ship> findAllByName(String name) {
        return  repository.findAllByName(name);
    }

    @Override
    public Optional<Ship> findByName(String name) {
        return repository.findByName(name);
    }
}

