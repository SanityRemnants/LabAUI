package com.example.fleetaplication.fleet.event.repository.rest;

import com.example.fleetaplication.fleet.entity.Fleet;
import com.example.fleetaplication.fleet.event.repository.api.FleetEventRepository;
import com.example.fleetaplication.fleet.function.FleetToRequestFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class FleetEventRestRepository implements FleetEventRepository {
    private final RestTemplate restTemplate;
    private final FleetToRequestFunction fleetToRequest;
    @Autowired
    public FleetEventRestRepository(RestTemplate template,FleetToRequestFunction function){
        this.restTemplate = template;
        this.fleetToRequest = function;
    }
    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/fleets/{id}",id);
    }

    @Override
    public void save(Fleet fleet) {
        restTemplate.postForLocation("/api/fleets/", fleetToRequest.apply(fleet));
    }
    @Override
    public void update(Fleet fleet){
        restTemplate.put("/api/fleets/"+fleet.getId(),fleetToRequest.apply(fleet));
    }
}
