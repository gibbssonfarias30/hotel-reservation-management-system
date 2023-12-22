package com.backfcdev.gatewayserver.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
        return http.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(authExChange ->
                        authExChange.pathMatchers("/hotel-service/**").hasRole("HOTELS")
                                    .pathMatchers("/room-service/**").authenticated()
                                    .pathMatchers("/reservation-service").permitAll())
//                    .oauth2ResourceServer(oAuth2 -> oAuth2.jwt(Customizer.withDefaults())).build(); sin roles
                    .oauth2ResourceServer(oAuth2 -> oAuth2.jwt(jwt ->
                                    jwt.jwtAuthenticationConverter(grantedAuthorities())
                    )).build();
    }


    Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthorities() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new RoleKeycloakConverter());
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }

}
