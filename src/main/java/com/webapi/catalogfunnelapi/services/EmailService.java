package com.webapi.catalogfunnelapi.services;

import com.webapi.catalogfunnelapi.exceptions.MailException;
import com.webapi.catalogfunnelapi.models.EmailModel;
import com.webapi.catalogfunnelapi.models.offer.Offer;
import com.webapi.catalogfunnelapi.models.offer.OfferLine;
import com.webapi.catalogfunnelapi.models.user.FunnelUser;
import com.webapi.catalogfunnelapi.repositories.EmailModelRepository;
import com.webapi.catalogfunnelapi.utils.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private CurrencyConverter currencyConverter;

    @Autowired
    private EmailModelRepository emailModelRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailModel sendEmail(Offer offer, FunnelUser user) {

        SimpleMailMessage msg = new SimpleMailMessage();

        try {
            EmailModel emailModel = createEmail(offer, user);

            msg.setTo(emailModel.getSetToEmail());
            msg.setSubject(emailModel.getSubject());
            msg.setText(offer.toString());

            javaMailSender.send(msg);
            return emailModel;
        }

        catch (MailException ex){
            throw ex;
        }


    }

    private EmailModel createEmail(Offer offer, FunnelUser funnelUser) {
        EmailModel emailModel = new EmailModel();
        emailModel.setSetToEmail(funnelUser.getEmail());
        emailModel.setSubject("Price Simulation -> " + funnelUser.getBusinessName());
        emailModelRepository.save(emailModel);
        return emailModel;
    }




}
