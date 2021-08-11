package com.webapi.catalogfunnelapi.models.offer;

import com.webapi.catalogfunnelapi.models.location.Location;
import com.webapi.catalogfunnelapi.models.product.ProductType;
import com.webapi.catalogfunnelapi.models.servicetype.ServiceType;

import javax.persistence.*;

@Entity
public class OfferLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(targetEntity=ServiceType.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private ServiceType serviceType;

    private String price;


    public OfferLine(){}

    public OfferLine(ServiceType serviceType,String price) {
        this.serviceType = serviceType;
        this.price = price;
    }
    public ServiceType getServiceType() {
        return serviceType;
    }


    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

