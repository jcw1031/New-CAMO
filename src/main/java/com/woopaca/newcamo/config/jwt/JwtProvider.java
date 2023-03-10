package com.woopaca.newcamo.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtProvider {

    @Value("${jwt.secretKey}")
    private String secretKey;
    private final Long HOUR_TIME = 1_000 * 60 * 60L;

    @PostConstruct
    public void init() {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(Long id, String email, List<String> roles, int tokenExpireHour) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("id", id);
        claims.put("roles", roles);

        Date now = new Date();
        return "Bearer " + Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + HOUR_TIME * tokenExpireHour))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
