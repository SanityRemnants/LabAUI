package com.example.shipapplication.ship.function;

import com.example.shipapplication.fleet.entity.Fleet;
import com.example.shipapplication.ship.dto.PutShipRequest;
import com.example.shipapplication.ship.entity.Ship;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToShipFunction implements BiFunction<UUID, PutShipRequest, Ship> {
    @Override
    public Ship apply(UUID id,PutShipRequest request)
    {
        return Ship.builder()
                .id(id)
                .displacement(request.getDisplacement())
                .name(request.getName())
                .fleet(Fleet.builder()
                        .id(request.getFleet())
                        .build())
                .build();
    }
}
