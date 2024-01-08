package com.example.shipapplication.fleet.entity;

import com.example.shipapplication.ship.entity.Ship;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="fleets")
public class Fleet implements Serializable {
    @Id
    private UUID id;
    @Column(name = "fleet_name")
    private String fleetName;
    @OneToMany(mappedBy = "fleet",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Ship> ships;

}
