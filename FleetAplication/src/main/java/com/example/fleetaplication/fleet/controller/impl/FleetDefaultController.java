package com.example.fleetaplication.fleet.controller.impl;

import com.example.fleetaplication.fleet.controller.api.FleetController;
import com.example.fleetaplication.fleet.dto.*;
import com.example.fleetaplication.fleet.entity.Fleet;
import com.example.fleetaplication.fleet.function.*;
import com.example.fleetaplication.fleet.service.api.FleetService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class FleetDefaultController implements FleetController {

    private final FleetService service;
    private final FleetToResponseFunction fleetToResponse;
    private final FleetsToResponseFunction fleetsToResponse;
    private final RequestToFleetFunction requestToFleet;
    private final UpdateFleetWithRequestFunction updateFleetWithRequest;

    @Autowired
    public FleetDefaultController(
            FleetService service,
            FleetToResponseFunction fleetToResponse,
            FleetsToResponseFunction fleetsToResponse,
            RequestToFleetFunction requestToFleet,
            UpdateFleetWithRequestFunction updateFleetWithRequest
    ) {
        this.service = service;
        this.fleetToResponse = fleetToResponse;
        this.fleetsToResponse = fleetsToResponse;
        this.requestToFleet = requestToFleet;
        this.updateFleetWithRequest = updateFleetWithRequest;
    }

    @Override
    public GetFleetsResponse getFleets() {
        return fleetsToResponse.apply(service.findAll());
    }

    @Override
    public GetFleetResponse getFleet(UUID id) {
        return fleetToResponse.apply(service.find(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public void putFleet(UUID id, PutFleetRequest request) {
        service.create(requestToFleet.apply(id,request));
    }

    @Override
    public void updateFleet(UUID id, PatchFleetRequest request) {
        service.update(updateFleetWithRequest.apply(service.find(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)),request));
    }

    @Override
    public void deleteFleet(UUID id) {
        Optional<Fleet> fleet = service.find(id);
        if (fleet.isPresent())
        {
            service.delete(id);
        }else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

