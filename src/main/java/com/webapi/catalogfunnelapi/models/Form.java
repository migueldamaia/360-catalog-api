package com.webapi.catalogfunnelapi.models;

import com.webapi.catalogfunnelapi.models.location.Location;
import com.webapi.catalogfunnelapi.models.product.ProductQuantity;
import com.webapi.catalogfunnelapi.models.product.ProductType;
import com.webapi.catalogfunnelapi.models.servicetype.ServiceType;
import com.webapi.catalogfunnelapi.models.user.FunnelUser;

import javax.persistence.*;
import java.util.List;

@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = FunnelUser.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private FunnelUser funnelUser;

    @OneToMany(targetEntity= ServiceType.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ServiceType> serviceType;

    @OneToOne(targetEntity= ProductType.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private ProductType productType;

    @OneToOne(targetEntity= ProductQuantity.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private ProductQuantity productQuantity;

    @OneToOne(targetEntity=Location.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private Location location;

    public Form(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FunnelUser getUser() {
        return funnelUser;
    }

    public void setUser(FunnelUser funnelUser) {
        this.funnelUser = funnelUser;
    }

    public List<ServiceType> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<ServiceType> serviceType) {
        this.serviceType = serviceType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductQuantity getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(ProductQuantity productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
