package com.example.oauth2.controllers;

import com.example.oauth2.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/oauth/revoke-token")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(
            HttpServletRequest request
    ){
        authenticationService.logout(request);
    }

    @RequestMapping("/oauth/token")
    @ResponseStatus(HttpStatus.OK)
    public
}
