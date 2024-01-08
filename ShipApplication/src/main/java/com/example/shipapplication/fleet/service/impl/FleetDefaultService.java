package com.example.shipapplication.fleet.service.impl;

import com.example.shipapplication.fleet.entity.Fleet;
import com.example.shipapplication.fleet.repository.api.FleetRepository;
import com.example.shipapplication.fleet.service.api.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FleetDefaultService implements FleetService {
    private final FleetRepository repository;
    @Autowired
    public FleetDefaultService(FleetRepository repository){this.repository = repository;}
    @Override
    public Optional<Fleet> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(Fleet fleet) {
        repository.save(fleet);
    }
    @Override
    public void update(Fleet fleet)
    {
        repository.save(fleet);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
