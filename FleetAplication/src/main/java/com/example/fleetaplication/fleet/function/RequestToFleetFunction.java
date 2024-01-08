package com.example.fleetaplication.fleet.function;

import com.example.fleetaplication.fleet.dto.PutFleetRequest;
import com.example.fleetaplication.fleet.entity.Fleet;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToFleetFunction implements BiFunction<UUID, PutFleetRequest, Fleet> {
    @Override
    public Fleet apply(UUID id, PutFleetRequest request)
    {
        return Fleet.builder()
                .id(id)
                .fleetName(request.getFleetName())
                .profit(request.getProfit())
                .countryOfOrigin(request.getCountryOfOrigin())
                .build();
    }
}