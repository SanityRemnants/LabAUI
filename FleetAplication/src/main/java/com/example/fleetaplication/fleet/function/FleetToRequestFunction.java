package com.example.fleetaplication.fleet.function;

import com.example.fleetaplication.fleet.dto.GetFleetsResponse;
import com.example.fleetaplication.fleet.dto.PostFleetRequest;
import com.example.fleetaplication.fleet.entity.Fleet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class FleetToRequestFunction implements Function<Fleet, PostFleetRequest> {
    @Override
    public PostFleetRequest apply(Fleet fleet) {
        return PostFleetRequest
                .builder()
                .id(fleet.getId())
                .name(fleet.getFleetName())
                .build();
    }
}
