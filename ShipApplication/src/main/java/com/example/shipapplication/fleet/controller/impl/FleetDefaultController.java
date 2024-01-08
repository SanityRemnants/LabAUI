package com.example.shipapplication.fleet.controller.impl;

import com.example.shipapplication.fleet.controller.api.FleetController;
import com.example.shipapplication.fleet.dto.PostFleetRequest;
import com.example.shipapplication.fleet.entity.Fleet;
import com.example.shipapplication.fleet.function.RequestToFleetFunction;
import com.example.shipapplication.fleet.service.api.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FleetDefaultController implements FleetController {
    private final FleetService service;
    private final RequestToFleetFunction requestToFleet;
    @Autowired
    public FleetDefaultController(FleetService service,RequestToFleetFunction request) {
        this.service=service;
        this.requestToFleet = request;
    }
    @Override
    public void postFleet(PostFleetRequest request) {
        service.create(requestToFleet.apply(request));
    }
    @Override
    public void putFleet(PostFleetRequest request) {
        service.update(requestToFleet.apply(request));
    }

    @Override
    public void deleteFleet(UUID id) {
        service.delete(id);
    }
}
