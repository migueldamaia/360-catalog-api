package com.webapi.catalogfunnelapi.services;

import com.webapi.catalogfunnelapi.models.location.Location;
import com.webapi.catalogfunnelapi.models.offer.OfferLine;
import com.webapi.catalogfunnelapi.models.servicetype.ServiceType;
import com.webapi.catalogfunnelapi.repositories.LocationRateRepository;
import com.webapi.catalogfunnelapi.repositories.ProductTypeRateRepository;
import com.webapi.catalogfunnelapi.repositories.ServiceTypeRateRepository;
import com.webapi.catalogfunnelapi.utils.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceCalculator {

    @Autowired
    private ProductTypeRateRepository productTypeRateRepository;

    @Autowired
    private ServiceTypeRateRepository serviceTypeRateRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    @Autowired
    private LocationRateRepository locationRateRepository;

    public OfferLine offerLineForHosting (ServiceType serviceType, String productQuantity){
        String serviceRate = serviceTypeRateRepository.findByName(serviceType.getName()).getServiceRate();
        String finalPrice = calculateFinalPriceHosting(serviceRate,productQuantity);
        OfferLine offerLine = new OfferLine(serviceType,currencyConverter.formatStringToEuro(finalPrice));
        return offerLine;
    }

    public OfferLine offerLineForPhoto (ServiceType serviceType, String productQuantity, Location location){
        String serviceRate = serviceTypeRateRepository.findByName(serviceType.getName()).getServiceRate();
        String locationRate = locationRateRepository.findByName(location.getName()).getLocationRate();
        String finalPrice = calculateFinalPricePhoto(serviceRate,locationRate,productQuantity);
        OfferLine offerLine = new OfferLine(serviceType,currencyConverter.formatStringToEuro(finalPrice));
        return offerLine;
    }

    public OfferLine offerLineForSystemIntegration (ServiceType serviceType,String productQuantity){
        String serviceRate = serviceTypeRateRepository.findByName(serviceType.getName()).getServiceRate();
        String finalPrice = calculateFinalPriceIntegration(serviceRate,productQuantity);
        OfferLine offerLine = new OfferLine(serviceType,currencyConverter.formatStringToEuro(finalPrice));
        return offerLine;
    }

    private String calculateFinalPricePhoto(String serviceRate,String locationRate,String productQuantity){
        long servRateLong = Long.parseLong(serviceRate);
        long locRateLong = Long.parseLong(locationRate);
        long prodQuantRate = Long.parseLong(productQuantity);
        long servPrice = (servRateLong * prodQuantRate);
        long finalPriceLong = servPrice * locRateLong;
        String finalPrice = Long.toString(finalPriceLong);
        return finalPrice;
    }

    private String calculateFinalPriceHosting(String serviceRate,String productQuantity){
        long servRateLong = Long.parseLong(serviceRate);
        long prodQuantRate = Long.parseLong(productQuantity);
        long finalPriceLong = (servRateLong * prodQuantRate);
        String finalPrice = Long.toString(finalPriceLong);
        return finalPrice;
    }

    private String calculateFinalPriceIntegration(String serviceRate,String productQuantity){
        long servRateLong = Long.parseLong(serviceRate);
        long prodQuantRate = Long.parseLong(productQuantity);
        long finalPriceLong = (servRateLong * prodQuantRate);
        String finalPrice = Long.toString(finalPriceLong);
        return finalPrice;
    }

}

