package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.location.LocationRate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRateRepository extends CrudRepository<LocationRate, Long> {

    LocationRate findById(long id);
    List<LocationRate> findAll();
    LocationRate save(LocationRate locationRate);
    LocationRate findByName(String location);
    long count();

}
