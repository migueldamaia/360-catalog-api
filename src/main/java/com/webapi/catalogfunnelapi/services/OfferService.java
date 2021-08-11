package com.webapi.catalogfunnelapi.services;

import com.webapi.catalogfunnelapi.models.offer.Offer;
import com.webapi.catalogfunnelapi.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;


    public List<Offer> listAllOffers() {

        return offerRepository.findAll();

    }
}
