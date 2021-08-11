package com.webapi.catalogfunnelapi.models.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductTypeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String productTypeRate;

    public ProductTypeRate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductTypeRate() {
        return productTypeRate;
    }

    public void setProductTypeRate(String productTypeRate) {
        this.productTypeRate = productTypeRate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

