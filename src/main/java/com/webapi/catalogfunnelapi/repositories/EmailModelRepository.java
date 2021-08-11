package com.webapi.catalogfunnelapi.repositories;

import com.webapi.catalogfunnelapi.models.EmailModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailModelRepository extends CrudRepository<EmailModel, Long> {

    EmailModel findById(long id);
    List<EmailModel> findAll();
    EmailModel save(EmailModel emailModel);
    long count();

}
