package com.webapi.catalogfunnelapi.services;

import com.webapi.catalogfunnelapi.models.dto.LocationRateDto;
import com.webapi.catalogfunnelapi.models.dto.ProductQuantityDto;
import com.webapi.catalogfunnelapi.models.dto.ProductTypeDto;
import com.webapi.catalogfunnelapi.models.dto.ServiceTypeRateDto;
import com.webapi.catalogfunnelapi.models.location.LocationRate;
import com.webapi.catalogfunnelapi.models.product.ProductQuantityRate;
import com.webapi.catalogfunnelapi.models.product.ProductTypeRate;
import com.webapi.catalogfunnelapi.models.servicetype.ServiceTypeRate;
import com.webapi.catalogfunnelapi.repositories.LocationRateRepository;
import com.webapi.catalogfunnelapi.repositories.ProductQuantityRateRepository;
import com.webapi.catalogfunnelapi.repositories.ProductTypeRateRepository;
import com.webapi.catalogfunnelapi.repositories.ServiceTypeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RateDao {

    @Autowired
    private ServiceTypeRateRepository serviceTypeRateRepository;

    @Autowired
    private LocationRateRepository locationRateRepository;

    @Autowired
    private ProductQuantityRateRepository productQuantityRateRepository;

    @Autowired
    private ProductTypeRateRepository productTypeRateRepository;

    public List<ServiceTypeRateDto> getServiceTypeRateDtos() {

        List<ServiceTypeRate> serviceTypeRateList = serviceTypeRateRepository.findAll();
        List<ServiceTypeRateDto> serviceTypeRateListDto = new LinkedList<>();

        for (int i = 0; i < serviceTypeRateList.size(); i++) {
            serviceTypeRateListDto.add(new ServiceTypeRateDto(serviceTypeRateList.get(i).getName()));

        }

        return serviceTypeRateListDto;

    }

    public List<LocationRateDto> getLocationRateDtos(){
        List<LocationRate> locationRates = locationRateRepository.findAll();
        List<LocationRateDto> locationRateDtos = new LinkedList<>();

        for (int i = 0; i < locationRates.size(); i++) {
            locationRateDtos.add(new LocationRateDto(locationRates.get(i).getName()));

        }

        return locationRateDtos;
    }


    public List<ProductQuantityDto> getProductQuantityDtos() {

        List<ProductQuantityRate> productQuantityRateList = productQuantityRateRepository.findAll();
        List<ProductQuantityDto> productQuantityDtos = new LinkedList<>();

        for (int i = 0; i < productQuantityRateList.size(); i++) {
            productQuantityDtos.add(new ProductQuantityDto(productQuantityRateList.get(i).getQuantity()));

        }

        return productQuantityDtos;
    }


    public List<ProductTypeDto> getProductTypeDtos(){
        List<ProductTypeRate> productTypeRateList = productTypeRateRepository.findAll();
        List<ProductTypeDto> productTypeDtos = new LinkedList<>();

        for (int i = 0; i <productTypeRateList.size() ; i++) {
            productTypeDtos.add(new ProductTypeDto(productTypeRateList.get(i).getName()));
        }
        return productTypeDtos;
    }
}
