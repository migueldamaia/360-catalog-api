package com.webapi.catalogfunnelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.webapi")
@SpringBootApplication
public class CatalogFunnelApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogFunnelApiApplication.class, args);
    }


}
