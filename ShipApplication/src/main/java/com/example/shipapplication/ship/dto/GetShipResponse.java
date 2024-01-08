package com.example.shipapplication.ship.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetShipResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Fleet {

        /**
         * Unique id identifying fleet.
         */
        private UUID id;
        private String fleetName;


    }
    private UUID id;
    private String name;
    private int displacement;
    private Fleet fleet;
}
