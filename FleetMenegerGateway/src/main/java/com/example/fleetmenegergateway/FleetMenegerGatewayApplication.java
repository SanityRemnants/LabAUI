package com.example.fleetmenegergateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FleetMenegerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetMenegerGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${meneger.ship.url}") String shipUrl,
			@Value("${meneger.fleet.url}") String fleetUrl,
			@Value("${meneger.gateway.host}") String host
	){
		return builder.routes()
				.route("fleets",route->route
						.host(host)
						.and()
						.path(
								"/api/fleets/{uuid}",
								"/api/fleets"
						)
						.uri(fleetUrl)
				)
				.route("ships",route->route
						.host(host)
						.and()
						.path(
								"/api/ships/**",
								"/api/ships",
								"/api/fleets/{uuid}/ships",
								"/api/fleets/{uuid}/ships/**"

						)
						.uri(shipUrl)
				)
				.build();
	}
}
