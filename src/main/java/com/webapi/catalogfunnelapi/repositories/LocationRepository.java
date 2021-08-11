package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.location.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    Location findById(long id);
    List<Location> findAll();
    Location save(Location location);
    //void deleteLocation(long id);
    long count();
    //boolean existsLocation(long id);
}
