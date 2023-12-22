package com.backfcdev.reservationservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "reservation-service")
@Data
public class AppConfig {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;

}