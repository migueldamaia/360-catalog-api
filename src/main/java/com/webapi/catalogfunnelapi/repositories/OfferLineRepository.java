package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.offer.OfferLine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferLineRepository extends CrudRepository<OfferLine,Long> {


    OfferLine findById(long id);
    List<OfferLine> findAll();
    OfferLine save(OfferLine offerLine);
    long count();

}
