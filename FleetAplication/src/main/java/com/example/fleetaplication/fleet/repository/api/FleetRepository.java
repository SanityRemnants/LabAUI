package com.example.fleetaplication.fleet.repository.api;


import com.example.fleetaplication.fleet.entity.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, UUID> {
    Optional<Fleet> findByFleetName(String fleetName);
}
