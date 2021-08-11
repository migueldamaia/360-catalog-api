package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.product.ProductQuantity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductQuantityRepository extends CrudRepository<ProductQuantity, Long> {


    ProductQuantity findById(long id);
    List<ProductQuantity> findAll();
    ProductQuantity save(ProductQuantity productQuantity);
    long count();
}
