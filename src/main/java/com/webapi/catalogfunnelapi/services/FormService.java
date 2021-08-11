package com.webapi.catalogfunnelapi.services;

import com.webapi.catalogfunnelapi.models.Form;
import com.webapi.catalogfunnelapi.models.user.FunnelUser;
import com.webapi.catalogfunnelapi.repositories.FormRepository;
import com.webapi.catalogfunnelapi.repositories.ServiceTypeRateRepository;
import com.webapi.catalogfunnelapi.repositories.ServiceTypeRepository;
import com.webapi.catalogfunnelapi.repositories.UserRepository;
import com.webapi.catalogfunnelapi.validators.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FormValidator formValidator;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private ServiceTypeRateRepository serviceTypeRateRepository;

    public Form createForm(Form form){

        Form finalForm = new Form();
        FunnelUser funnelUser = new FunnelUser(form.getUser().getPersonName(),form.getUser().getBusinessName(),form.getUser().getEmail());
        userRepository.save(funnelUser);
        //FunnelUser user2 = userRepository.findByEmail(funnelUser.getEmail());
        finalForm.setUser(funnelUser);

        finalForm.setProductQuantity(form.getProductQuantity());

        finalForm.setServiceType(form.getServiceType());
        finalForm.setProductType(form.getProductType());
        finalForm.setLocation(form.getLocation());

        formRepository.save(finalForm);
        return formRepository.findById(finalForm.getId());
    }

    public Form getForm(long id){
        return formRepository.findById(id);
    }

    public List<Form> getAllForms(){
        return formRepository.findAll();
    }

    public FunnelUser createUser(FunnelUser funnelUser) {

        FunnelUser validatedFunnelUser;

        if(userRepository.findByEmail(funnelUser.getEmail())==null){
            validatedFunnelUser = formValidator.validateUserInfo(funnelUser);
            userRepository.save(validatedFunnelUser);
        }
        else{
            return null;
        }

        return userRepository.findById(validatedFunnelUser.getId());
    }

}

