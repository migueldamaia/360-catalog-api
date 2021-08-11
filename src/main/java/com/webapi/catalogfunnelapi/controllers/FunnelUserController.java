package com.webapi.catalogfunnelapi.controllers;

import com.webapi.catalogfunnelapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")
public class FunnelUserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listAllFunnelUsers(){
        return new ResponseEntity<>(userService.listFunnelUsers(), HttpStatus.OK);
    }


}
