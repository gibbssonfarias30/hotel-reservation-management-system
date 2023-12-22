package com.backfcdev.reservationservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class PropertiesReservations {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}
