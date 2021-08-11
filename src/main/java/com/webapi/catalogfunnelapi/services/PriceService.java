package com.webapi.catalogfunnelapi.services;

import com.webapi.catalogfunnelapi.models.Form;
import com.webapi.catalogfunnelapi.models.location.Location;
import com.webapi.catalogfunnelapi.models.offer.Offer;
import com.webapi.catalogfunnelapi.models.offer.OfferLine;
import com.webapi.catalogfunnelapi.models.servicetype.ServiceType;
import com.webapi.catalogfunnelapi.repositories.OfferLineRepository;
import com.webapi.catalogfunnelapi.repositories.OfferRepository;
import com.webapi.catalogfunnelapi.repositories.ServiceTypeRateRepository;
import com.webapi.catalogfunnelapi.repositories.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private PriceCalculator priceCalculator;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private OfferLineRepository offerLineRepository;

    @Autowired
    private ServiceTypeRateRepository serviceTypeRateRepository;

    public Offer getOffer(Form form) {

        Offer offer = new Offer();
        int j = serviceTypeRepository.findAll().size();
        List<OfferLine> offerLineList = new LinkedList<>();
        for (int i = 0; i < form.getServiceType().size(); i++) {

            //check for photo
            if (form.getServiceType().get(i).getName().equals(serviceTypeRateRepository.findById(0).getName())) {
                form.getServiceType().get(i).setDescription(serviceTypeRateRepository.findById(0).getPaymentTerm());

                OfferLine offerLine = offerLineForPhoto(form.getServiceType().get(i), form.getProductQuantity().getQuantity(), form.getLocation());
                offerLineList.add(offerLine);

            }

            //check for Hosting
            if (form.getServiceType().get(i).getName().equals(serviceTypeRateRepository.findById(1).getName())) {
                form.getServiceType().get(i).setDescription(serviceTypeRateRepository.findById(1).getPaymentTerm());
                offerLineList.add(offerLineForSystemIntegration(form.getServiceType().get(i), form.getProductQuantity().getQuantity()));
            }

            //check for Integration
            if (form.getServiceType().get(i).getName().equals(serviceTypeRateRepository.findById(2).getName())) {
                form.getServiceType().get(i).setDescription(serviceTypeRateRepository.findById(2).getPaymentTerm());
                offerLineList.add(offerLineForHosting(form.getServiceType().get(i), form.getProductQuantity().getQuantity()));
            }

        }

        offer.setOfferLines(offerLineList);

        offerRepository.save(offer);

        return offer;
    }

    private OfferLine offerLineForHosting(ServiceType serviceType, String productQuantity) {
        return offerLineRepository.save(priceCalculator.offerLineForHosting(serviceType, productQuantity));
    }

    private OfferLine offerLineForPhoto(ServiceType serviceType, String productQuantity, Location location) {
        return offerLineRepository.save(priceCalculator.offerLineForPhoto(serviceType, productQuantity, location));
    }

    private OfferLine offerLineForSystemIntegration(ServiceType serviceType, String productQuantity) {
        return offerLineRepository.save(priceCalculator.offerLineForSystemIntegration(serviceType, productQuantity));
    }

}
