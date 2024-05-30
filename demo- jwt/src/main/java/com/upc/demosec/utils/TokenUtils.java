package com.upc.demosec.utils;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



public class TokenUtils {
    // UPC-AAW-LIMA-Llave-mas.larga-para-JWT
    private final static String ACCESS_TOKEN_SECRET = "VVBDLUFBVy1MSU1BLUxsYXZlLW1hcy5sYXJnYS1wYXJhLUpXVA==";
    private final static Long ACCESS_TOKENN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken (String nombre, String username) {
        Long expirationTime = ACCESS_TOKENN_VALIDITY_SECONDS * 1_000L;
        Date expirationDate = new Date(System.currentTimeMillis()+ expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

         return Jwts.builder()
                .setSubject(nombre)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(SignatureAlgorithm.HS256, ACCESS_TOKEN_SECRET.getBytes())
                //.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }
    public static UsernamePasswordAuthenticationToken getAuthentication (String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            String nombre = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(nombre, null, Collections.emptyList());


        } catch (JwtException e) {
            return null;
        }
    }
}
