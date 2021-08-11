package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.offer.Offer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer,Long> {
    Offer findById(long id);
    List<Offer> findAll();
    Offer save(Offer offer);
    long count();
}
