package com.webapi.catalogfunnelapi.repositories;
import com.webapi.catalogfunnelapi.models.user.FunnelUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<FunnelUser,Long> {
    FunnelUser findById(long id);
    List<FunnelUser> findAll();
    FunnelUser save(FunnelUser funnelUser);
    long count();
    FunnelUser findByEmail(String email);
}
