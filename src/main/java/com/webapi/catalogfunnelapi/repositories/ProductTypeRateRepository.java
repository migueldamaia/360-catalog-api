package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.product.ProductTypeRate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductTypeRateRepository extends CrudRepository<ProductTypeRate, Long> {

    ProductTypeRate findById(long id);
    List<ProductTypeRate> findAll();
    ProductTypeRate save(ProductTypeRate productTypeRate);
    long count();

}
