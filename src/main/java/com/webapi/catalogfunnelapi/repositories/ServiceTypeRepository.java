package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.servicetype.ServiceType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceTypeRepository extends CrudRepository<ServiceType, Long> {

    ServiceType findById(long id);
    List<ServiceType> findAll();
    ServiceType save(ServiceType form);
    long count();

}
