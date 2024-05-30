package com.upc.demosec.controller;

import com.upc.demosec.model.Ciudad;
import com.upc.demosec.model.User;
import com.upc.demosec.service.CiudadService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CiudadController {
    @Autowired
    CiudadService ciudadService;

    @GetMapping("/ciudad")
    ResponseEntity<List<Ciudad>> listAll(HttpSession session) {
        User userSession = (User) session.getAttribute("ciudadSession");
        // Preguntar si entró por Basic Auth
        if (userSession == null)
            return new ResponseEntity<List<Ciudad>>(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

        // Preguntar si esta enabled
        if (userSession.getEnabled() == 0)
            return  new ResponseEntity<List<Ciudad>>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<List<Ciudad>>(ciudadService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/ciudad")
    ResponseEntity<Ciudad> insert(HttpSession session, @RequestBody Ciudad ciudad) {
        User userSession = (User) session.getAttribute("ciudadSession");
        // Preguntar si entró por Basic Auth
        if (userSession == null)
            return new ResponseEntity<Ciudad>(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

        // Preguntar si esta enabled
        if (userSession.getEnabled() == 0)
            return  new ResponseEntity<Ciudad>(HttpStatus.BAD_REQUEST);

        // Solo los usuarios con Rol de WRITE
        if (userSession.getAuthorities().get(0).getName().toString() != "WRITE")
            return  new ResponseEntity<Ciudad>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Ciudad>(ciudadService.insert(ciudad), HttpStatus.CREATED);
    }

}
