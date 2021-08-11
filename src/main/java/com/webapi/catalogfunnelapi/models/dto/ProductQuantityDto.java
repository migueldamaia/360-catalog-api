package com.webapi.catalogfunnelapi.models.dto;

public class ProductQuantityDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductQuantityDto(String name) {
        this.name = name;
    }
}
