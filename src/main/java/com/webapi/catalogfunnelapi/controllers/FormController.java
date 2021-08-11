package com.webapi.catalogfunnelapi.controllers;

import com.webapi.catalogfunnelapi.exceptions.FormException;
import com.webapi.catalogfunnelapi.models.EmailModel;
import com.webapi.catalogfunnelapi.models.Form;
import com.webapi.catalogfunnelapi.models.jwt.JwtRequest;
import com.webapi.catalogfunnelapi.models.jwt.JwtResponse;
import com.webapi.catalogfunnelapi.models.offer.Offer;
import com.webapi.catalogfunnelapi.models.user.FunnelUser;
import com.webapi.catalogfunnelapi.security.JwtUtil;
import com.webapi.catalogfunnelapi.services.AdminUserDetailsService;
import com.webapi.catalogfunnelapi.services.EmailService;
import com.webapi.catalogfunnelapi.services.FormService;
import com.webapi.catalogfunnelapi.services.PriceService;
import com.webapi.catalogfunnelapi.validators.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FormController {

    @Autowired
    private FormService formService;

    @Autowired
    private FormValidator formValidator;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AdminUserDetailsService adminUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private PriceService priceService;

    @Autowired
    private EmailService emailService;

    @PostMapping(value = ("/authenticate"))
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception(ex.getMessage(), ex);
        }

        final UserDetails userDetails = adminUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createUser(@RequestBody FunnelUser funnelUser) throws FormException {

        try {
            FunnelUser createdFunnelUser = formService.createUser(funnelUser);

            if (createdFunnelUser == null) {
                //todo -> Change hardcoded messages to message.properties file
                throw new FormException("Funnel User Already Exists");
            } else {
                return new ResponseEntity<>(createdFunnelUser, HttpStatus.CREATED);
            }

        } catch (FormException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = {"/createForm"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createForm(@RequestBody Form form) throws FormException {

        try {

            Form createdForm = formService.createForm(form);

            if (createdForm == null) {
                throw new FormException("Form not created");
            } else {
                return new ResponseEntity<>(createdForm, HttpStatus.CREATED);
            }


        } catch (FormException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping(value = {"/getResults"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getResults(@RequestParam long id) {
        Form form = formService.getForm(id);
        Offer offer = priceService.getOffer(form);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @GetMapping(value = "/listAllForms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listAllForms() {

        try {
            List<Form> formList = formService.getAllForms();
            return new ResponseEntity<>(formList, HttpStatus.OK);
        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }

    }

    @GetMapping(value = {"/sendEmail"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sendEmail(@RequestParam long id) {

        try {
            Form form = formService.getForm(id);

            Offer offer = priceService.getOffer(form);

            EmailModel emailModel = emailService.sendEmail(offer, form.getUser());

            return new ResponseEntity<>(emailModel, HttpStatus.OK);
        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/getForms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllForms() {

        List<Form> formList = formService.getAllForms();
        if (formList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Object>(formList, HttpStatus.OK);
        }
    }
}
