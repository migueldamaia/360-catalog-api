package com.webapi.catalogfunnelapi.validators;

import com.webapi.catalogfunnelapi.exceptions.RateException;
import com.webapi.catalogfunnelapi.models.location.LocationRate;
import com.webapi.catalogfunnelapi.models.product.ProductQuantityRate;
import com.webapi.catalogfunnelapi.models.product.ProductTypeRate;
import com.webapi.catalogfunnelapi.models.servicetype.ServiceTypeRate;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class RateValidator {

    // TODO: 11/8/21 IMPLEMENT VALIDATION
    /*

    public ServiceTypeRate validateServiceTypeRate(ServiceTypeRate serviceTypeRate) {

        String serviceTypeName = serviceTypeRate.getName();
        List<String> serviceTypeRateNameList = new LinkedList<>();

        if (serviceTypeName.equals("PHOTOGRAPHY_360")) {
            serviceTypeRateNameList.add(serviceTypeName);
        }

        if (serviceTypeName.equals("HOSTING")) {
            serviceTypeRateNameList.add(serviceTypeName);
        }

        if (serviceTypeName.equals("INTEGRATION")) {
            serviceTypeRateNameList.add(serviceTypeName);
        }

        if(serviceTypeRateNameList.size() < 1){
            throw new RateException(("Service Rate Invalid"));
        }

        if (serviceTypeRate.getName().equals("PHOTOGRAPHY_360") && !serviceTypeRate.getServiceRate().equals("50")) {
            throw new RateException("Service Rate Invalid");
        }

        if (serviceTypeRate.getName().equals("HOSTING") && !serviceTypeRate.getServiceRate().equals("30")) {
            throw new RateException("Service Rate Invalid");
        }
        if (serviceTypeRate.getName().equals("INTEGRATION") && !serviceTypeRate.getServiceRate().equals("200")) {
            throw new RateException("Service Rate Invalid");
        }

        return serviceTypeRate;

    }

    public LocationRate validateLocationRate(LocationRate locationRate) {

        String locationName = locationRate.getName();
        List<String> locationNameList = new LinkedList<>();

        if (locationName.equals("LISBON")) {
            locationNameList.add(locationName);
        }

        if (locationName.equals("MADRID")) {
            locationNameList.add(locationName);
        }

        if (locationName.equals("LONDON")) {
            locationNameList.add(locationName);
        }

        if(locationNameList.size() < 1){
            throw new RateException(("Service Rate Invalid"));
        }


            return locationRate;

    }

    public ProductQuantityRate validateProductQuantity(ProductQuantityRate productQuantityRate) {

        if (!productQuantityRate.getQuantity().equals("< 25") ||
                !productQuantityRate.getQuantity().equals("< 50") ||
                !productQuantityRate.getQuantity().equals("< 100") ||
                !productQuantityRate.getQuantity().equals("< 250") ||
                !productQuantityRate.getQuantity().equals("< 500") ) {
            throw new RateException("Product Quantity Invalid");
        } else {
            return productQuantityRate;
        }
    }

    public ProductTypeRate validateProductTypeRate(ProductTypeRate productTypeRate) {

        if (!productTypeRate.getProductTypeRate().equals("SHOES") ||
                !productTypeRate.getProductTypeRate().equals("JEWELERY") ||
                !productTypeRate.getProductTypeRate().equals("CLOTHING") ||
                !productTypeRate.getProductTypeRate().equals("CONSUMER GOODS") ||
                !productTypeRate.getProductTypeRate().equals("REAL ESTATE") ||
                !productTypeRate.getProductTypeRate().equals("TRANSPORTATION")
                ) {
            throw new RateException("Product Type Invalid");
        } else {
            return productTypeRate;
        }
    }
    */


}

