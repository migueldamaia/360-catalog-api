package com.webapi.catalogfunnelapi.models.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductQuantityRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String quantity;
    private String quantityRate;

    public ProductQuantityRate(String quantity) {
        this.quantity = quantity;
    }
    public ProductQuantityRate() {
    }

    public String getQuantityRate() {
        return quantityRate;
    }

    public void setQuantityRate(String quantityRate) {
        this.quantityRate = quantityRate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

