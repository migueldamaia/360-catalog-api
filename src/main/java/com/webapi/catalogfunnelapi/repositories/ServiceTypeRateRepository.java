package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.servicetype.ServiceTypeRate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceTypeRateRepository extends CrudRepository<ServiceTypeRate, Long> {

    ServiceTypeRate findById(long id);
    List<ServiceTypeRate> findAll();
    ServiceTypeRate save(ServiceTypeRate serviceTypeRate);
    ServiceTypeRate findByName(String name);
    long count();

}
