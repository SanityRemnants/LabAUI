package com.example.shipapplication.ship.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchShipRequest {
    private String name;
    private int displacement;
}
