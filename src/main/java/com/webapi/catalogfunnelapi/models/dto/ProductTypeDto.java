package com.webapi.catalogfunnelapi.models.dto;

public class ProductTypeDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductTypeDto(String name) {
        this.name = name;
    }
}
