package com.backfcdev.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route("hotel-service", r -> r
						.path("/hotel-service/**")
						.filters(f -> f
								.rewritePath("/hotel-service/(?<segment>.*)", "/${segment}")
								.addRequestHeader("X-Response-Time", new Date().toString()))
						.uri("lb://HOTEL-SERVICE"))
				.route("room-service", r -> r
						.path("/room-service/**")
						.filters(f -> f
								.rewritePath("/room-service/(?<segment>.*)", "/${segment}")
								.addRequestHeader("X-Response-Time", new Date().toString()))
						.uri("lb://ROOM-SERVICE"))
				.route("reservation-service", r -> r
						.path("/reservation-service/**")
						.filters(f -> f
								.rewritePath("/reservation-service/(?<segment>.*)", "/${segment}")
								.addRequestHeader("X-Response-Time", new Date().toString()))
						.uri("lb://RESERVATION-SERVICE"))
				.build();
	}

}
