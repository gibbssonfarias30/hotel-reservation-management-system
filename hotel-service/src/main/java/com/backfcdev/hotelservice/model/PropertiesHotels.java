package com.backfcdev.hotelservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class PropertiesHotels {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}
