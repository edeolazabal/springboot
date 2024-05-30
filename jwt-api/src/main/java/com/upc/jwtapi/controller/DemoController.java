package com.upc.jwtapi.controller;

import com.upc.jwtapi.model.*;
import com.upc.jwtapi.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasRole;

@RestController
//@CrossOrigin
@CrossOrigin(origins = "http://localhost:4200", exposedHeaders = "Authorization")
//@CrossOrigin(origins = "http://localhost:4200")
//@EnableMethodSecurity(prePostEnabled = true)
public class DemoController {

    private final AuthService authService;

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    public DemoController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(value = "/api/v1/demo")
    @PreAuthorize("hasAuthority ('ADMIN')")
    public String bienvenida()
    {
        return "Bienvenido desde un endpoint seguro";
    }

    @GetMapping(value = "/api/v1/prueba2")
    @PreAuthorize("hasAuthority ('USER')")
    public String bienvenidaPrueba2()
    {
        return "Bienvenido a la segunda prueba";
    }

    @PostMapping(value = "/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "/auth/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
    @Transactional(readOnly = true)
    @GetMapping(value = "/auth/login")
    public String bienvenida2()
    {
        return "Bienvenido desde un endpoint sin seguridad";
    }

}
