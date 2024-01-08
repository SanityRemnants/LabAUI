package com.example.shipapplication.ship.controller.impl;

import com.example.shipapplication.fleet.service.api.FleetService;
import com.example.shipapplication.ship.controller.api.ShipController;
import com.example.shipapplication.ship.dto.*;
import com.example.shipapplication.ship.entity.Ship;
import com.example.shipapplication.ship.function.*;
import com.example.shipapplication.ship.service.api.ShipService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class ShipDefaultController implements ShipController {

    private final ShipService service;
    private final FleetService fleetService;
    private final ShipToResponseFunction shipToResponse;
    private final ShipsToResponseFunction shipsToResponse;
    private final RequestToShipFunction requestToShip;
    private final UpdateShipWithRequestFunction updateShipWithRequest;

    @Autowired
    public ShipDefaultController(
            ShipService service,
            FleetService fleetService,
            ShipToResponseFunction shipToResponse,
            ShipsToResponseFunction shipsToResponse,
            RequestToShipFunction requestToShip,
            UpdateShipWithRequestFunction updateShipWithRequest
    ) {
        this.service = service;
        this.fleetService = fleetService;
        this.requestToShip = requestToShip;
        this.shipsToResponse = shipsToResponse;
        this.shipToResponse = shipToResponse;
        this.updateShipWithRequest = updateShipWithRequest;
    }

    @Override
    public GetShipsResponse getShips() {
        return shipsToResponse.apply(service.findAll());
    }

    @Override
    public GetShipsResponse getFleetShips(UUID fleetId) {
        GetShipsResponse shipsResponse = service.findAllByFleet(fleetId)
                .map(shipsToResponse)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
        if (shipsResponse.getShips().isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return shipsResponse;
    }

    @Override
    public GetShipResponse getShip(UUID id) {
        return service.find(id)
                .map(shipToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetShipResponse getFleetShip(UUID fleetId, UUID id) {
        List<Ship> ships = service.findAllByFleet(fleetId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ships.stream()
                .filter(ship -> ship.getId()==id)
                .findFirst().map(shipToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putShip(UUID id, PutShipRequest request) {
        fleetService.find(request.getFleet()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        service.create(requestToShip.apply(id,request));
    }

    @Override
    public void updateShip(UUID id, PatchShipRequest request) {
        service.update(updateShipWithRequest.apply(service.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),request));
    }

    @Override
    public void deleteShip(UUID id) {
        Optional<Ship> ship = service.find(id);
        if (ship.isPresent())
        {
            service.delete(id);
        }else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
