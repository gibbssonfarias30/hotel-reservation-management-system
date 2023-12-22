package com.backfcdev.roomservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class PropertiesRooms {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}
