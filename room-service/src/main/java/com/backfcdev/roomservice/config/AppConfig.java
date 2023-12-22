package com.backfcdev.roomservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "room-service")
@Data
public class AppConfig {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;

}