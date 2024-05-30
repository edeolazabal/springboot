package com.upc.demosec.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.demosec.model.AuthCredentials;
import com.upc.demosec.utils.TokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOError;
import java.io.Reader;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
// Autenticación
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
   // @Override
    public Authentication attemptAuthentication (HttpRequest request, HttpResponse response)
        throws AuthenticationException {
        AuthCredentials authCredentials = new AuthCredentials();
        try {
            authCredentials = new ObjectMapper().readValue(request.toString(), AuthCredentials.class);
        } catch (IOException e) {
        }
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getUsername(),
                authCredentials.getPassword(),
                Collections.emptyList()
        );
        return getAuthenticationManager().authenticate(usernamePAT);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                                    HttpServletResponse response,
                                                    FilterChain chain,
                                                    Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getUsername(), userDetails.getUsername());

        response.addHeader("Authorizatrion", "Bearer "+ token);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
