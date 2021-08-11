package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.product.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {

    ProductType findById(long id);
    List<ProductType> findAll();
    ProductType save(ProductType productType);
    long count();

}
