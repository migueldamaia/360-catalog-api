package com.webapi.catalogfunnelapi.services;

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
public class RateService {

    @Autowired
    private ServiceTypeRateRepository serviceTypeRateRepository;

    @Autowired
    private LocationRateRepository locationRateRepository;

    @Autowired
    private ProductTypeRateRepository productTypeRateRepository;

    @Autowired
    private ProductQuantityRateRepository productQuantityRateRepository;

    public ProductTypeRate updateProductTypeRate(ProductTypeRate productTypeRate) {

        ProductTypeRate updatedProductTypeRate = productTypeRateRepository.findById(productTypeRate.getId());
        updatedProductTypeRate.setName(productTypeRate.getName());
        updatedProductTypeRate.setProductTypeRate(productTypeRate.getProductTypeRate());

        return productTypeRateRepository.save(updatedProductTypeRate);
    }

    public ProductQuantityRate updateProductQuantityRate(ProductQuantityRate productQuantityRate) {

        ProductQuantityRate updatedProductQuantityRate = productQuantityRateRepository.findById(productQuantityRate.getId());
        updatedProductQuantityRate.setQuantity(productQuantityRate.getQuantity());
        updatedProductQuantityRate.setQuantityRate(productQuantityRate.getQuantityRate());

        return productQuantityRateRepository.save(updatedProductQuantityRate);
    }

    public LocationRate updateLocationRate(LocationRate locationRate) {

        LocationRate updatedLocationRate = locationRateRepository.findById(locationRate.getId());
        updatedLocationRate.setName(locationRate.getName());
        updatedLocationRate.setLocationRate(locationRate.getLocationRate());

        return locationRateRepository.save(updatedLocationRate);

    }

    public ServiceTypeRate updateServiceTypeRate(ServiceTypeRate serviceTypeRate) {

        ServiceTypeRate updatedServiceTypeRate = serviceTypeRateRepository.findById(serviceTypeRate.getId());

        updatedServiceTypeRate.setName(serviceTypeRate.getName());
        updatedServiceTypeRate.setServiceRate(serviceTypeRate.getServiceRate());
        updatedServiceTypeRate.setPaymentTerm(serviceTypeRate.getPaymentTerm());

        return serviceTypeRateRepository.save(updatedServiceTypeRate);
    }

    public ServiceTypeRate createServiceTypeRate(ServiceTypeRate serviceTypeRate) {

        return serviceTypeRateRepository.save(serviceTypeRate);

    }

    public List<ServiceTypeRate> createServiceTypeRateList(List<ServiceTypeRate> serviceTypeRateList) {
        List<ServiceTypeRate> serviceRate = new LinkedList<>();
        for (int i = 0; i < serviceTypeRateList.size(); i++) {
            serviceTypeRateRepository.save(serviceTypeRateList.get(i));

            serviceRate.add(serviceTypeRateList.get(i));
        }
        return serviceRate;

    }


    public LocationRate createLocationRate(LocationRate locationRate) {

        LocationRate locRate = locationRateRepository.save(locationRate);
        return locRate;
    }

    public List<LocationRate> createLocationRateList(List<LocationRate> locationRateList) {

        List<LocationRate> locationRate = new LinkedList<>();
        for (int i = 0; i < locationRateList.size(); i++) {
            //locationRateRepository.save(rateValidator.validateLocationRate(locationRateList.get(i)));
            locationRateRepository.save(locationRateList.get(i));
            locationRate.add(locationRateList.get(i));
        }

        return locationRate;

    }

    public ProductQuantityRate createProductQuantityRate(ProductQuantityRate productQuantityRate) {

        ProductQuantityRate prodQRate = productQuantityRateRepository.save(productQuantityRate);
        return prodQRate;

    }

    public List<ProductQuantityRate> createProductQuantityRateList(List<ProductQuantityRate> productQuantityRateList) {
        List<ProductQuantityRate> prodQRate = new LinkedList<>();

        for (int i = 0; i < productQuantityRateList.size(); i++) {
            //productQuantityRateRepository.save(rateValidator.validateProductQuantity(productQuantityRateList.get(i)));
            productQuantityRateRepository.save(productQuantityRateList.get(i));
            prodQRate.add(productQuantityRateList.get(i));
        }
        return prodQRate;

    }

    public ProductTypeRate createProdTypeRate(ProductTypeRate productTypeRate) {

        ProductTypeRate productTypeRate1 = productTypeRateRepository.save(productTypeRate);
        return productTypeRate1;

    }

    public LinkedList<ProductTypeRate> createProdTypeRateList(List<ProductTypeRate> productTypeRateList) {

        LinkedList<ProductTypeRate> prodTRate = new LinkedList<>();

        for (int i = 0; i < productTypeRateList.size(); i++) {
            productTypeRateRepository.save(productTypeRateList.get(i));
            prodTRate.add(productTypeRateList.get(i));
        }

        return prodTRate;

    }

    public List<ServiceTypeRate> getServiceRates() {
        return serviceTypeRateRepository.findAll();

    }

    public List<LocationRate> getLocationRates() {
        return locationRateRepository.findAll();

    }

    public List<ProductQuantityRate> getProdQuantityRates() {

        return productQuantityRateRepository.findAll();

    }

    public List<ProductTypeRate> getProdTypeRates() {

        return productTypeRateRepository.findAll();
    }

    public void deleteServiceRate(long id) {

        serviceTypeRateRepository.delete(serviceTypeRateRepository.findById(id));

    }

    public void deleteLocationRate(long id) {
        locationRateRepository.delete(locationRateRepository.findById(id));
    }

    public void deleteProdQuantityRate(long id) {
        productQuantityRateRepository.delete(productQuantityRateRepository.findById(id));
    }

    public void deleteProductTypeRate(long id) {
        productTypeRateRepository.delete(productTypeRateRepository.findById(id));
    }



}
