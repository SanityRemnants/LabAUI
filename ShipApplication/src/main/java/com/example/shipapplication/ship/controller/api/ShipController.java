package com.example.shipapplication.ship.controller.api;

import com.example.shipapplication.ship.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ShipController {
    @GetMapping("api/ships")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShipsResponse getShips();

    @GetMapping("api/fleets/{fleetId}/ships")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShipsResponse getFleetShips(
            @PathVariable("fleetId")
            UUID fleetId
    );

    @GetMapping("api/ships/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShipResponse getShip(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("api/fleets/{fleetId}/ships/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetShipResponse getFleetShip(
            @PathVariable("fleetId")
            UUID fleetId,
            @PathVariable("id")
            UUID id
    );

    @PutMapping("api/ships/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putShip(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutShipRequest request
    );

    @PatchMapping("api/ships/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateShip(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchShipRequest request
    );


    @DeleteMapping("api/ships/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteShip(
            @PathVariable("id")
            UUID id
    );
}
