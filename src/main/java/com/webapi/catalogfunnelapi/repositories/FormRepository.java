package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.Form;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FormRepository extends CrudRepository<Form, Long> {

    Form findById(long id);
    List<Form> findAll();
    Form save(Form form);
    long count();

}
