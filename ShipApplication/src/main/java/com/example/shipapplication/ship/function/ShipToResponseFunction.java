package com.example.shipapplication.ship.function;


import com.example.shipapplication.ship.dto.GetShipResponse;
import com.example.shipapplication.ship.entity.Ship;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ShipToResponseFunction implements Function<Ship, GetShipResponse> {
    @Override
    public GetShipResponse apply(Ship entity)
    {
        return GetShipResponse.builder()
                .id(entity.getId())
                .displacement(entity.getDisplacement())
                .name(entity.getName())
                .fleet(GetShipResponse.Fleet.builder()
                        .id(entity.getFleet().getId())
                        .fleetName(entity.getFleet().getFleetName())
                        .build())
                .build();
    }
}
