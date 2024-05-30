package com.upc.contactosjwt.security;

import com.upc.contactosjwt.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    // LLAVE_MUY_SECRETA_PARA_LOS_ALUMNOS_DE_UPC => [Base64] => TExBVkVfTVVZX1NFQ1JFVEFfUEFSQV9MT1NfQUxVTU5PU19ERV9VUEM==
    private final static String ACCESS_TOKEN_SECRET = "TExBVkVfTVVZX1NFQ1JFVEFfUEFSQV9MT1NfQUxVTU5PU19ERV9VUEM==";
    private final static Long ACCESS_TOKENN_VALIDITY_SECONDS = 2_592_000L;

    @Value("${app.jwttoken.message}")
    private String message;

    public static String createToken(String nombre, String username) {
        Long expirationTime = ACCESS_TOKENN_VALIDITY_SECONDS * 1_000L;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        return Jwts.builder()
                .setSubject(nombre)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(SignatureAlgorithm.HS256, ACCESS_TOKEN_SECRET.getBytes())
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    //   .build()
                    .parseClaimsJws(token)
                    .getBody();

            String nombre = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(nombre, null, Collections.emptyList());

        } catch (JwtException e) {
            return null;
        }
    }

        private Key getSignInKey () {
            byte[] keyBytes = Decoders.BASE64.decode(ACCESS_TOKEN_SECRET);
            return Keys.hmacShaKeyFor(keyBytes);
        }

    }





