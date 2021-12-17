package com.authorization_service.controller;


import com.authorization_service.model.request.AccountRequest;
import com.authorization_service.security.CustomUserDetailsService;
import com.authorization_service.security.jwt.JwtTokenUtils;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(value = "/login")
    public String createAuthenticationToken(@RequestBody AccountRequest accountRequest) throws Exception {
        System.out.println("run login");
        // load User name
        authenticate(accountRequest.getUsername(), accountRequest.getPassword());
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(accountRequest.getUsername());

        // generate token
        final String token = jwtTokenUtils.generateToken(userDetails);
        // response the token
        System.out.println("token: " + token);
        return token;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            // call authenticationManagerBean
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            // compare user
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/test")
    public String test_controller() {
        return "Test";
    }
}