package com.example.shipapplication.fleet.repository.api;

import com.example.shipapplication.fleet.entity.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FleetRepository extends JpaRepository<Fleet, UUID> {
}
