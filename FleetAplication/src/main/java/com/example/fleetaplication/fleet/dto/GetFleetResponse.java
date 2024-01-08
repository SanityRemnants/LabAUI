package com.example.fleetaplication.fleet.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetFleetResponse {
    private UUID id;
    private String fleetName;
    private String countryOfOrigin;
    private int profit;
}