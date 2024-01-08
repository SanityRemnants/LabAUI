package com.example.fleetaplication.fleet.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutFleetRequest {
    private String fleetName;
    private String countryOfOrigin;
    private int profit;
}
