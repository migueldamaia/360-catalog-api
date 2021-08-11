package com.webapi.catalogfunnelapi.controllers;

import com.webapi.catalogfunnelapi.models.offer.Offer;
import com.webapi.catalogfunnelapi.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping(value = "/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listAllOffers(){
        List<Offer> offerList = offerService.listAllOffers();
        return new ResponseEntity<>(offerList, HttpStatus.OK);
    }

}
