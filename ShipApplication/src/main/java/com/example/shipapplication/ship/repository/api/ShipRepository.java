package com.example.shipapplication.ship.repository.api;

import com.example.shipapplication.fleet.entity.Fleet;
import com.example.shipapplication.ship.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShipRepository extends JpaRepository<Ship, UUID> {
    List<Ship> findAllByFleet(Fleet fleet);
    List<Ship> findAllByName(String name);
    Optional<Ship> findByName(String name);
}

