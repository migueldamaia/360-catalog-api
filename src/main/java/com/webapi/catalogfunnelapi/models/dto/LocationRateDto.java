package com.webapi.catalogfunnelapi.models.dto;

public class LocationRateDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationRateDto(String name) {
        this.name = name;
    }
}
