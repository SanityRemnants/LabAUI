package com.example.shipapplication.ship.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutShipRequest {
    private String name;
    private int displacement;
    private UUID fleet;
}
