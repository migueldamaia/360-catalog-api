package com.webapi.catalogfunnelapi.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class FunnelUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonInclude
    private String personName;
    @JsonInclude
    private String businessName;
    @JsonInclude
    private String email;

    @Override
    public String toString() {
        return "Name='" + personName + '\'' +
                ",  Business Name='" + businessName + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }

    public FunnelUser(){}

    public FunnelUser(String personName, String businessName, String email) {
        this.personName = personName;
        this.businessName = businessName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
