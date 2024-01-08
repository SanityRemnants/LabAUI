package com.example.fleetaplication.fleet.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetFleetsResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Fleet
    {
        private UUID id;
        private String fleetName;
    }
    @Singular
    private List<Fleet> fleets;
}