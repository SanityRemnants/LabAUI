package com.example.fleetaplication.fleet.initialize;

import com.example.fleetaplication.fleet.entity.Fleet;
import com.example.fleetaplication.fleet.service.api.FleetService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.net.ConnectException;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final FleetService fleetService;
    @Autowired
    public InitializeData(FleetService fleetService){this.fleetService=fleetService;}
    @Override
    public void afterPropertiesSet() throws Exception {
        if(fleetService.findAll().isEmpty())
        {
            Fleet northern = Fleet.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1"))
                    .fleetName("Northern")
                    .countryOfOrigin("Finland")
                    .profit(10000)
                    .build();
            Fleet southern = Fleet.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2"))
                    .fleetName("Southern")
                    .countryOfOrigin("RPA")
                    .profit(15000)
                    .build();
            Fleet western = Fleet.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a3"))
                    .fleetName("Western")
                    .countryOfOrigin("USA")
                    .profit(70000)
                    .build();
            Fleet eastern = Fleet.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a4"))
                    .fleetName("Eastern")
                    .countryOfOrigin("Japan")
                    .profit(213000)
                    .build();
            fleetService.create(northern);
            fleetService.create(southern);
            fleetService.create(western);
            fleetService.create(eastern);


        }
    }
}
