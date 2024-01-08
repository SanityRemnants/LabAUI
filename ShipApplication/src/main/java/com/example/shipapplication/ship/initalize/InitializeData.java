package com.example.shipapplication.ship.initalize;

import com.example.shipapplication.fleet.entity.Fleet;
import com.example.shipapplication.fleet.service.api.FleetService;
import com.example.shipapplication.ship.entity.Ship;
import com.example.shipapplication.ship.service.api.ShipService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final FleetService fleetService;
    private final ShipService shipService;
    @Autowired
    public InitializeData(FleetService fleetService,ShipService shipService){
        this.fleetService=fleetService;
        this.shipService = shipService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        if(shipService.findAll().isEmpty())
        {
            Fleet northern = Fleet.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1"))
                    .build();
            Fleet southern = Fleet.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2"))
                    .build();
            fleetService.create(northern);
            fleetService.create(southern);
            Ship RVAndora = Ship.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a5"))
                    .name("RV Andora")
                    .displacement(1200)
                    .fleet(northern)
                    .build();
            Ship AOGBurner = Ship.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                    .name("AOG Burner")
                    .displacement(3000)
                    .fleet(northern)
                    .build();
            Ship CSDocker = Ship.builder()
                    .id(UUID.randomUUID())
                    .name("CS Docker")
                    .displacement(4000)
                    .fleet(northern)
                    .build();
            Ship CSBoxes = Ship.builder()
                    .id(UUID.randomUUID())
                    .name("CS Boxes")
                    .displacement(4600)
                    .fleet(southern)
                    .build();
            Ship DCVOilSniffer = Ship.builder()
                    .id(UUID.randomUUID())
                    .name("DCV Oil Sniffer")
                    .displacement(2500)
                    .fleet(southern)
                    .build();
            shipService.create(RVAndora);
            shipService.create(CSDocker);
            shipService.create(AOGBurner);
            shipService.create(CSBoxes);
            shipService.create(DCVOilSniffer);
        }
    }
}
