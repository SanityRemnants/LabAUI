package com.example.shipapplication.ship.function;


import com.example.shipapplication.ship.dto.GetShipsResponse;
import com.example.shipapplication.ship.entity.Ship;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class ShipsToResponseFunction implements Function<List<Ship>, GetShipsResponse> {
    @Override
    public GetShipsResponse apply(List<Ship> entities)
    {
        return GetShipsResponse.builder()
                .ships(entities.stream()
                        .map(ship -> GetShipsResponse.Ship.builder()
                                .id(ship.getId())
                                .name(ship.getName())
                                .fleet(ship.getFleet().getId())
                                .build())
                        .toList())
                .build();
    }

}
