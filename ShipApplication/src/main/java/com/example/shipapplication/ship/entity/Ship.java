package com.example.shipapplication.ship.entity;

import com.example.shipapplication.fleet.entity.Fleet;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ships")
public class Ship implements Serializable,Comparable<Ship> {
    @Id
    private UUID id;
    @Column(name = "name")
    String name;
    @Column(name = "displacement")
    int displacement; //in tonnes
    @ManyToOne
    @JoinColumn(name = "fleet")
    Fleet fleet;


    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", displacement=" + displacement +
                ", fleet=" + fleet.getId() +
                '}';
    }

    @Override
    public int compareTo(Ship o) {
        if(this.getName().compareTo(o.getName())<0)
            return -1;
        else if (this.getName().compareTo(o.getName())>0) {
            return 1;
        }
        if(this.getDisplacement() - o.getDisplacement() < 0)
            return -1;
        else if (this.getDisplacement() - o.getDisplacement() > 0) {
            return 1;
        }
        return 0;
    }
}
