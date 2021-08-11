package com.webapi.catalogfunnelapi.security;

import com.webapi.catalogfunnelapi.services.AdminUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AdminUserDetailsService adminUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = "";

        if (httpServletRequest.getHeader("Authorization") != null) {
            authorizationHeader = httpServletRequest.getHeader("Authorization");
        }


        StringBuilder requestURL = new StringBuilder(httpServletRequest.getRequestURL().toString());

        String userName = null;
        String jwt = null;

        if (httpServletRequest.getMethod().equals("OPTIONS") && httpServletRequest.getRequestURI().equals("/rate/listServTypes")) {
            authorizationHeader = getTokenForOptionsCors();
        }
        if (httpServletRequest.getMethod().equals("OPTIONS") && httpServletRequest.getRequestURI().equals("/rate/listProdQuant")) {
            authorizationHeader = getTokenForOptionsCors();
        }
        if (httpServletRequest.getMethod().equals("OPTIONS") && httpServletRequest.getRequestURI().equals("/rate/listLocs")) {
            authorizationHeader = getTokenForOptionsCors();
        }
        if (httpServletRequest.getMethod().equals("OPTIONS") && httpServletRequest.getRequestURI().equals("/rate/listProdType")) {
            authorizationHeader = getTokenForOptionsCors();
        }

        if (httpServletRequest.getMethod().equals("OPTIONS") && httpServletRequest.getRequestURI().startsWith("/createForm")) {
            authorizationHeader = getTokenForOptionsCors();
        }

        if (httpServletRequest.getMethod().equals("OPTIONS") && httpServletRequest.getRequestURI().startsWith("/getResults")) {
            authorizationHeader = getTokenForOptionsCors();
        }

        if (httpServletRequest.getMethod().equals("OPTIONS") && httpServletRequest.getRequestURI().startsWith("/sendEmail")) {
            authorizationHeader = getTokenForOptionsCors();
        }






        if (authorizationHeader != null || authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader;//.substring(7);
            userName = jwtUtil.exctractUserName(jwt);
        }


        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.adminUserDetailsService.loadUserByUsername(userName);

            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getTokenForOptionsCors(){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("foo","foo"));
        final UserDetails userDetails = adminUserDetailsService.loadUserByUsername("foo");
        return jwtUtil.generateToken(userDetails);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request)
            throws ServletException {
        String path = request.getRequestURI();
        return "/authenticate".equals(path);


    }
}

