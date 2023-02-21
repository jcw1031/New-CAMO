package com.woopaca.newcamo.config.jwt;

import org.springframework.security.core.Authentication;

public class JwtUtils {

    public String resolveToken(String header) {
        return null;
    }

    public boolean isNotExpired(String token) {
        return false;
    }

    public Authentication getAuthentication(String token) {
        return null;
    }
}
