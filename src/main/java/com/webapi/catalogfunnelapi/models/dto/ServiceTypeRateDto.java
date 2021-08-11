package com.webapi.catalogfunnelapi.models.dto;

public class ServiceTypeRateDto {

    public ServiceTypeRateDto(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
