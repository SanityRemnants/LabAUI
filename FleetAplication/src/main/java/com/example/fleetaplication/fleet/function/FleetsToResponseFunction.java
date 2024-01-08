package com.example.fleetaplication.fleet.function;


import com.example.fleetaplication.fleet.dto.GetFleetsResponse;
import com.example.fleetaplication.fleet.entity.Fleet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class FleetsToResponseFunction implements Function<List<Fleet>, GetFleetsResponse> {
    @Override
    public GetFleetsResponse apply(List<Fleet> entities)
    {
        return GetFleetsResponse.builder()
                .fleets(entities.stream()
                        .map(fleet -> GetFleetsResponse.Fleet.builder()
                                .id(fleet.getId())
                                .fleetName(fleet.getFleetName())
                                .build())
                        .toList())
                .build();
    }
}