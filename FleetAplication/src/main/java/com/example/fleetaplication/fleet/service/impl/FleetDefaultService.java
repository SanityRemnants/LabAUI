package com.example.fleetaplication.fleet.service.impl;

import com.example.fleetaplication.fleet.entity.Fleet;
import com.example.fleetaplication.fleet.event.repository.api.FleetEventRepository;
import com.example.fleetaplication.fleet.repository.api.FleetRepository;
import com.example.fleetaplication.fleet.service.api.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FleetDefaultService implements FleetService {
    private final FleetRepository repository;
    private final FleetEventRepository eventRepository;

    @Autowired
    public FleetDefaultService(FleetRepository repository,FleetEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void update(Fleet fleet) {
        repository.save(fleet);
        eventRepository.update(fleet);
    }

    @Override
    public void create(Fleet fleet) {
        repository.save(fleet);
        try {
            eventRepository.save(fleet);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }

    @Override
    public void delete(String fleetName) {
        repository.findByFleetName(fleetName).ifPresent(repository::delete);
    }

    @Override
    public Optional<Fleet> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Fleet> findByName(String fleetName) {
        return repository.findByFleetName(fleetName);
    }

    @Override
    public List<Fleet> findAll() {
        return repository.findAll();
    }

}