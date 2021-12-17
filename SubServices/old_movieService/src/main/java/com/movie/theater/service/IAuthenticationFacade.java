package com.movie.theater.service;

import org.springframework.security.core.Authentication;


public interface IAuthenticationFacade {
    Authentication getAuthentication();
    String getUserName();
}
