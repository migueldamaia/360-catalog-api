package com.webapi.catalogfunnelapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String setToEmail;
    private String subject;
    private StringBuilder body;

    public String getSetToEmail() {
        return setToEmail;
    }

    public void setSetToEmail(String setToEmail) {
        this.setToEmail = setToEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public StringBuilder getBody() {
        return body;
    }

    public void setBody(StringBuilder body) {
        this.body = body;
    }

    public EmailModel() {
    }
}
