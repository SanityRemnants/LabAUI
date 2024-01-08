package com.example.shipapplication.fleet.function;

import com.example.shipapplication.fleet.dto.PostFleetRequest;
import com.example.shipapplication.fleet.entity.Fleet;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class RequestToFleetFunction implements Function<PostFleetRequest, Fleet> {
    @Override
    public Fleet apply(PostFleetRequest postFleetRequest) {
        return Fleet.builder()
                .id(postFleetRequest.getId())
                .fleetName(postFleetRequest.getName())
                .build();
    }
}
