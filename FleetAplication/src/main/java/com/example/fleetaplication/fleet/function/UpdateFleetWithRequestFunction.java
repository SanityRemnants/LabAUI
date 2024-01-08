package com.example.fleetaplication.fleet.function;

import com.example.fleetaplication.fleet.dto.PatchFleetRequest;
import com.example.fleetaplication.fleet.entity.Fleet;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateFleetWithRequestFunction implements BiFunction<Fleet, PatchFleetRequest, Fleet> {
    @Override
    public Fleet apply(Fleet entity, PatchFleetRequest request)
    {
        return Fleet.builder()
                .id(entity.getId())
                .fleetName(request.getFleetName())
                .profit(request.getProfit())
                .countryOfOrigin(request.getCountryOfOrigin())
                .build();
    }
}
