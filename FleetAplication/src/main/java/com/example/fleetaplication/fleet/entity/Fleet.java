package com.example.fleetaplication.fleet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="fleets")
public class Fleet implements Serializable,Comparable<Fleet> {
    @Id
    @ToString.Exclude
    private UUID id;
    @Column(name = "fleet_name")
    String fleetName;
    @Column(name = "country_of_origin")
    String countryOfOrigin;
    @Column(name = "profit")
    int profit;

    @Override
    public int compareTo(Fleet o) {
        if(this.getFleetName().compareTo(o.getFleetName())<0)
            return -1;
        else if (this.getFleetName().compareTo(o.getFleetName())>0) {
            return 1;
        }
        if(this.getCountryOfOrigin().compareTo(o.getCountryOfOrigin())<0)
            return -1;
        else if (this.getCountryOfOrigin().compareTo(o.getCountryOfOrigin())>0) {
            return 1;
        }
        if(this.getProfit() - o.getProfit() < 0)
            return -1;
        else if (this.getProfit() - o.getProfit() > 0) {
            return 1;
        }
        return 0;
    }
}
