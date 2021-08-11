package com.webapi.catalogfunnelapi.models.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocationRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String locationRate;

    public LocationRate() {
    }

    public String getName() {
        return name;
    }

    public String getLocationRate() {
        return locationRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationRate(String locationRate) {
        this.locationRate = locationRate;
    }
}

