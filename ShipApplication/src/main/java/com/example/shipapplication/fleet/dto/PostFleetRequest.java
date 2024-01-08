package com.example.shipapplication.fleet.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostFleetRequest {
    private UUID id;
    private String name;
}
