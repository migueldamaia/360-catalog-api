package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.product.ProductQuantityRate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductQuantityRateRepository extends CrudRepository<ProductQuantityRate, Long> {

        ProductQuantityRate findById(long id);
        List<ProductQuantityRate> findAll();
        ProductQuantityRate save(ProductQuantityRate productQuantityRate);
        long count();

}
