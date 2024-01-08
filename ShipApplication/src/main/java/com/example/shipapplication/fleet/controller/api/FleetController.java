package com.example.shipapplication.fleet.controller.api;

import com.example.shipapplication.fleet.dto.PostFleetRequest;
import com.example.shipapplication.fleet.entity.Fleet;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface FleetController {
    @PostMapping("api/fleets/")
    @ResponseStatus(HttpStatus.CREATED)
    void postFleet(
            @RequestBody
            PostFleetRequest request
    );
    @PutMapping("api/fleets/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void putFleet(
            @RequestBody
            PostFleetRequest request
    );
    @DeleteMapping("api/fleets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFleet(
            @PathVariable("id")
            UUID id
    );
}
