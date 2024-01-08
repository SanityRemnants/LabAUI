package com.example.fleetaplication.fleet.function;

import com.example.fleetaplication.fleet.dto.GetFleetResponse;
import com.example.fleetaplication.fleet.entity.Fleet;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FleetToResponseFunction implements Function<Fleet, GetFleetResponse> {
    @Override
    public GetFleetResponse apply(Fleet entity)
    {
        return GetFleetResponse.builder()
                .id(entity.getId())
                .fleetName(entity.getFleetName())
                .countryOfOrigin(entity.getCountryOfOrigin())
                .profit(entity.getProfit())
                .build();
    }
}