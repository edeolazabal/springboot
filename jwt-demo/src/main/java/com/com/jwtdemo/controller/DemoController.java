package com.com.jwtdemo.controller;

import com.com.jwtdemo.model.*;
import com.com.jwtdemo.service.AuthService;
import com.com.jwtdemo.service.PaisService;
import jakarta.persistence.Tuple;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class DemoController {

    private final AuthService authService;
    private final PaisService paisService;

    public DemoController(AuthService authService, PaisService paisService) {
        this.authService = authService;
        this.paisService = paisService;
    }

    // Generan un token
    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<AuthResponse> bienvenido (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));

    }
    @GetMapping("/auth/login")
    public ResponseEntity<String> register (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok("Bienvenido a JWT login");
    }
    @GetMapping("/auth/login2")
    public ResponseEntity<String> register () {
        return ResponseEntity.ok("Bienvenido a JWT login - desde otra ruta");
    }

    // Endpoints que requieren autenticación (Token)
    @GetMapping("/api/v1/show")
    public ResponseEntity<String> showDemo () {
        return new ResponseEntity<>("Bienvenido desde un endpoint seguro", HttpStatus.OK);
    }
    @PostMapping("/api/v1/pais")
    public ResponseEntity<Pais> inserta (@RequestBody Pais pais) {
        return new ResponseEntity<>(paisService.inserta(pais), HttpStatus.CREATED);
    }
    @GetMapping("/api/v1/pais")
    public ResponseEntity<List<Pais>> lista () {
        return new ResponseEntity<>(paisService.lista(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/pais/{id}")
    public ResponseEntity<Pais> listaPorId (@PathVariable Integer id) {
        return new ResponseEntity<>(paisService.listaPorId(id), HttpStatus.OK);
    }

    @GetMapping("/admin/pais/{id}")
    public ResponseEntity<Pais> listaPorId2 (@PathVariable Integer id) {
        return new ResponseEntity<>(paisService.listaPorId(id), HttpStatus.OK);
    }
    @GetMapping("/user/pais/{id}")
    public ResponseEntity<Pais> listaPorId3 (@PathVariable Integer id) {
        return new ResponseEntity<>(paisService.listaPorId(id), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> pruebaA () {
        return ResponseEntity.ok("Hola Desde ADMIN");
    }
    @GetMapping("/user")
    public ResponseEntity<String> pruebaB () {
        return ResponseEntity.ok("Hola Desde USER");
    }


// Agregado 09/09/2023
    @GetMapping("/api/v1/pais/nombre/{name}")
    public ResponseEntity<List<Pais>> listaPorNombre (@PathVariable String name) {
        return new ResponseEntity<>(paisService.listaPorNombre(name), HttpStatus.OK);
    }
    @GetMapping("/api/v1/pais/nombreOrdenado")
    public ResponseEntity<List<PaisDTO>> listNombreOrdenado () {
        return new ResponseEntity<>(paisService.listaNombreOrdenado(), HttpStatus.OK);
    }
    @GetMapping("/api/v1/pais/findnombre/{name}")
    public ResponseEntity<List<Pais>> findByName (@PathVariable String name) {
        return new ResponseEntity<>(paisService.findByName(name), HttpStatus.OK);
    }
}
