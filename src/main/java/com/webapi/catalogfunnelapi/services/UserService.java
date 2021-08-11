package com.webapi.catalogfunnelapi.services;

import com.webapi.catalogfunnelapi.models.user.FunnelUser;
import com.webapi.catalogfunnelapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository funnelUserRepository;

    public List<FunnelUser> listFunnelUsers(){
        return funnelUserRepository.findAll();
    }

}
