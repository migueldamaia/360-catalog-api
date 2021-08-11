package com.webapi.catalogfunnelapi.validators;

import com.webapi.catalogfunnelapi.exceptions.FormException;
import com.webapi.catalogfunnelapi.models.user.FunnelUser;
import org.springframework.stereotype.Component;

@Component
public class FormValidator {



    public FunnelUser validateUserInfo(FunnelUser funnelUser) throws FormException{



        if(funnelUser.getPersonName() == null || funnelUser.getPersonName().equals("")){
            throw new FormException("Person name is missing");
        }

        if(funnelUser.getBusinessName() == null || funnelUser.getBusinessName().equals("")){
            throw new FormException("Business name is missing");
        }

        if(funnelUser.getEmail() == null || funnelUser.getEmail().equals("")){
            throw new FormException("Email is missing");
        }

        else{
            return funnelUser;
        }


    };
/* todo
    public FormApiError validateServiceType(List<ServiceType> serviceTypeList);

    todo
    public FormApiError validateProductType(ProductType productType);
todo
    public FormApiError validateProductQuantity(ProductQuantity productQuantity);
    todo
    public Location validateLocation(Location location);

    */

}

