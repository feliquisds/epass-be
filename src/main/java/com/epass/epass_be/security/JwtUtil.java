package com.epass.epass_be.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 1000 * 60 * 60; // 1 hora

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token, String email) {
        String subject = extractEmail(token);
        return subject.equals(email) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expirationDate = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expirationDate.before(new Date());
    }

    // public String generateToken(String tipoPessoa, long id) {
    //     return Jwts.builder()
    //             .setSubject(tipoPessoa + ":" + id)
    //             .setIssuedAt(new Date())
    //             .setExpiration(new Date(System.currentTimeMillis() + expiration))
    //             .signWith(key)
    //             .compact();
    // }

    // public String extractAccount(String token) {
    //     return Jwts.parserBuilder()
    //             .setSigningKey(key)
    //             .build()
    //             .parseClaimsJws(token)
    //             .getBody()
    //             .getSubject();
    // }

    // public boolean isTokenValid(String token, String tipoUsuario, Long id) {
    //     String subject = extractAccount(token);
    //     return subject.equals(tipoUsuario + ":" + id) && !isTokenExpired(token);
    // }

    // private boolean isTokenExpired(String token) {
    //     Date expirationDate = Jwts.parserBuilder()
    //             .setSigningKey(key)
    //             .build()
    //             .parseClaimsJws(token)
    //             .getBody()
    //             .getExpiration();
    //     return expirationDate.before(new Date());
    // }
}