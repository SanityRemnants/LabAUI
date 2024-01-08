package com.example.shipapplication.ship.function;

import com.example.shipapplication.ship.dto.PatchShipRequest;
import com.example.shipapplication.ship.entity.Ship;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
@Component
public class UpdateShipWithRequestFunction implements BiFunction<Ship, PatchShipRequest, Ship> {
    @Override
    public Ship apply(Ship entity,PatchShipRequest request)
    {
        return Ship.builder()
                .id(entity.getId())
                .name(request.getName())
                .displacement(request.getDisplacement())
                .fleet(entity.getFleet())
                .build();
    }
}
