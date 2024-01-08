package com.example.shipapplication.ship.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetShipsResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Ship
    {
        private UUID id;
        private String name;
        private UUID fleet;
    }
    @Singular
    private List<Ship> ships;
}
