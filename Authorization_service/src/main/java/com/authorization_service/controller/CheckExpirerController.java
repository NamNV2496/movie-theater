package com.authorization_service.controller;

import com.authorization_service.security.CustomUserDetailsService;
import com.authorization_service.security.jwt.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
public class CheckExpirerController {

    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping(value = "/check")
    public Boolean check(@RequestHeader("Authorization") String token) {
		// get username
        System.out.println("Check token "+ token);
		token = token.substring(7);
        String username = jwtTokenUtils.getUsernameFromToken(token);
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
		if (userDetails == null) {
            System.out.println("UserDetails is null");
		    return false;
        }
		if (jwtTokenUtils.validateToken(token, userDetails)) {
		    // isTokenExpired return fail if the token still available, return true if the token is expired
            // at here I return true if the token still available
		    Boolean isExpired = jwtTokenUtils.isTokenExpired(token);
            System.out.println("check IsExpired: " + !isExpired);
			return !isExpired;
		}
		return false;
    }
}