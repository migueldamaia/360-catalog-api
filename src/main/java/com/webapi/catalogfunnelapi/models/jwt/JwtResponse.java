package com.webapi.catalogfunnelapi.models.jwt;

public class JwtResponse {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwt;

    public JwtResponse(String jwttoken) {
        this.jwt = jwttoken;
    }

    public String getToken() {
        return this.jwt;
    }
}
