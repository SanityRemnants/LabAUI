package com.example.fleetaplication.fleet.controller.api;

import com.example.fleetaplication.fleet.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface FleetController {
    @GetMapping("api/fleets")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetFleetsResponse getFleets();

    @GetMapping("api/fleets/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetFleetResponse getFleet(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("api/fleets/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putFleet(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutFleetRequest request
    );

    @PatchMapping("api/fleets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateFleet(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchFleetRequest request
    );

    @DeleteMapping("api/fleets/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteFleet(
            @PathVariable("id")
            UUID id
    );


}
