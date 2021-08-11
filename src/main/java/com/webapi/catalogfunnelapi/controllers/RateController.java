package com.webapi.catalogfunnelapi.controllers;

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
import com.webapi.catalogfunnelapi.services.RateDao;
import com.webapi.catalogfunnelapi.services.RateService;
import com.webapi.catalogfunnelapi.validators.RateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("rate")
public class RateController {

    @Autowired
    ServiceTypeRateRepository serviceTypeRateRepository;

    @Autowired
    LocationRateRepository locationRateRepository;

    @Autowired
    ProductQuantityRateRepository productQuantityRateRepository;

    @Autowired
    ProductTypeRateRepository productTypeRateRepository;

    @Autowired
    RateValidator rateValidator;

    @Autowired
    private RateService rateService;

    @Autowired
    private RateDao rateDao;

    @PostMapping(value = "/setServiceRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setServiceRate(@RequestBody ServiceTypeRate serviceTypeRate) {
        ServiceTypeRate serviceRate = rateService.createServiceTypeRate(serviceTypeRate);
        return new ResponseEntity<Object>(serviceRate, HttpStatus.OK);
    }

    @PostMapping(value = "/setServiceRateList", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setServiceRate(@RequestBody List<ServiceTypeRate> serviceTypeRateList) {
        List<ServiceTypeRate> serviceRate = rateService.createServiceTypeRateList(serviceTypeRateList);
        return new ResponseEntity<Object>(serviceRate, HttpStatus.OK);
    }

    @PostMapping(value = "/setLocationRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setLocationRate(@RequestBody LocationRate locationRate) {
        LocationRate locRate = rateService.createLocationRate(locationRate);
        return new ResponseEntity<Object>(locRate, HttpStatus.OK);
    }

    @PostMapping(value = "/setLocationRateList", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setLocationRateList(@RequestBody List<LocationRate> locationRateList) {

        List<LocationRate> locationRates = rateService.createLocationRateList(locationRateList);

        return new ResponseEntity<Object>(locationRates, HttpStatus.OK);
    }

    @PostMapping(value = "/setProdQuantRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setProductQuantityRate(@RequestBody ProductQuantityRate productQuantityRate) {

        ProductQuantityRate prodQRate = rateService.createProductQuantityRate(productQuantityRate);

        return new ResponseEntity<Object>(prodQRate, HttpStatus.OK);
    }

    @PostMapping(value = "/setProdQuantRateList", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setProdQuantityRateList(@RequestBody List<ProductQuantityRate> productQuantityRateList) {

        List<ProductQuantityRate> prodQRate = rateService.createProductQuantityRateList(productQuantityRateList);

        return new ResponseEntity<Object>(prodQRate, HttpStatus.OK);
    }

    @PostMapping(value = "/setProdTypeRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setProdTypeRate(@RequestBody ProductTypeRate productTypeRate) {
        ProductTypeRate prodTRate = rateService.createProdTypeRate(productTypeRate);

        return new ResponseEntity<Object>(prodTRate, HttpStatus.OK);
    }

    @PostMapping(value = "/setProdTypeRateList", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setProdTypeRateList(@RequestBody List<ProductTypeRate> productTypeRateList) {

        LinkedList<ProductTypeRate> prodTRate = rateService.createProdTypeRateList(productTypeRateList);

        return new ResponseEntity<Object>(prodTRate, HttpStatus.OK);
    }

    @GetMapping(value = "/getServiceRate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getServiceRates() {
        List<ServiceTypeRate> serviceTypeRateList = rateService.getServiceRates();

        return new ResponseEntity<>(serviceTypeRateList, HttpStatus.OK);

    }

    @GetMapping(value = "/getLocationRate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getLocationRate() {
        List<LocationRate> locationRateList = rateService.getLocationRates();
        return new ResponseEntity<>(locationRateList, HttpStatus.OK);

    }

    @GetMapping(value = "/getProdQuantRate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProdQuantRate() {
        List<ProductQuantityRate> productQuantityRateList = rateService.getProdQuantityRates();
        return new ResponseEntity<>(productQuantityRateList, HttpStatus.OK);

    }

    @GetMapping(value = "/getProdTypeRate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProdTypeRate() {
        List<ProductTypeRate> productTypeRateList = rateService.getProdTypeRates();
        return new ResponseEntity<>(productTypeRateList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delServiceRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delServiceById(@RequestBody long id) {
        rateService.deleteServiceRate(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delLocationRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delLocationRate(@RequestBody long id) {
        rateService.deleteLocationRate(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delProdQuantRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delProdQuantRate(@RequestBody long id) {
        rateService.deleteProdQuantityRate(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delProdTypeRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delProdTypeRate(@RequestBody long id) {
        rateService.deleteProductTypeRate(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @PostMapping(value = "/updServiceRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updServiceRate(@RequestBody ServiceTypeRate serviceTypeRate) {

        ServiceTypeRate updateServiceTypeRate = rateService.updateServiceTypeRate(serviceTypeRate);

        return new ResponseEntity<>(updateServiceTypeRate, HttpStatus.OK);
    }

    @PostMapping(value = "/updLocationRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updLocationRate(@RequestBody LocationRate locationRate) {

        LocationRate updatedLocationRate = rateService.updateLocationRate(locationRate);


        return new ResponseEntity<>(updatedLocationRate, HttpStatus.OK);
    }

    @PostMapping(value = "/updProdQuantRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updProdQuantRate(@RequestBody ProductQuantityRate productQuantityRate) {

        ProductQuantityRate updatedProductQuantityRate = rateService.updateProductQuantityRate(productQuantityRate);


        return new ResponseEntity<>(updatedProductQuantityRate, HttpStatus.OK);
    }

    @PostMapping(value = "/updProdTypeRate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updProdTypeRate(@RequestBody ProductTypeRate productTypeRate) {
        ProductTypeRate updatedProductTypeRate = rateService.updateProductTypeRate(productTypeRate);
        return new ResponseEntity<>(updatedProductTypeRate, HttpStatus.OK);
    }

    @GetMapping(value = "/listServTypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listServTypes() {
        List<ServiceTypeRateDto> serviceTypeRateDtos = rateDao.getServiceTypeRateDtos();

        return new ResponseEntity<>(serviceTypeRateDtos,HttpStatus.OK);
    }

    @GetMapping(value = "/listLocs",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listLocs(){
        List<LocationRateDto> locationRateDtos = rateDao.getLocationRateDtos();
        return new ResponseEntity<>(locationRateDtos,HttpStatus.OK);
    }

    @GetMapping(value = "/listProdQuant",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listProdQuant(){
        List<ProductQuantityDto> productQuantityDtos = rateDao.getProductQuantityDtos();

        return new ResponseEntity<>(productQuantityDtos,HttpStatus.OK);
    }

    @GetMapping(value = "/listProdType",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listProdType(){
        List<ProductTypeDto> productTypeDtos = rateDao.getProductTypeDtos();
        return new ResponseEntity<>(productTypeDtos,HttpStatus.OK);
    }


}

