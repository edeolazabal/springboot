package com.upc.alumnoapi.controller;

import com.upc.alumnoapi.model.dto.AlumnoDTO;
import com.upc.alumnoapi.model.dto.AlumnoEscuelaDTO;
import com.upc.alumnoapi.model.entity.Alumno;
import com.upc.alumnoapi.service.AlumnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prueba")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Datos del usuario: {}", auth.getPrincipal());
        logger.info("Datos de los permisos {}", auth.getAuthorities());
        logger.info("Está autenticado {}", auth.isAuthenticated());

        return new ResponseEntity<List<Alumno>>(alumnoService.getAllAlumnos(), HttpStatus.OK);
    }
    @GetMapping("/alumnosprot")
    public ResponseEntity<List<Alumno>> getAllAlumnosProt() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Datos del usuario: {}", auth.getPrincipal());
        logger.info("Datos de los permisos {}", auth.getAuthorities());
        logger.info("Está autenticado {}", auth.isAuthenticated());

        return new ResponseEntity<List<Alumno>>(alumnoService.getAllAlumnos(), HttpStatus.OK);
    }
    @GetMapping("/alumnosadmin")
    public ResponseEntity<List<Alumno>> getAllAlumnosAdmin() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Datos del usuario: {}", auth.getPrincipal());
        logger.info("Datos de los permisos {}", auth.getAuthorities());
        logger.info("Está autenticado {}", auth.isAuthenticated());

        return new ResponseEntity<List<Alumno>>(alumnoService.getAllAlumnos(), HttpStatus.OK);
    }
    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable (value = "id") Long alumnoId) {
        return new ResponseEntity<Alumno>(alumnoService.getAlumno(alumnoId), HttpStatus.OK);
    }
    @GetMapping("/alumnos/dto")
    public ResponseEntity<List<AlumnoEscuelaDTO>> getAllAlumnosEscuela() {
        return new ResponseEntity<List<AlumnoEscuelaDTO>>(alumnoService.getAllAlumnosEscuela(), HttpStatus.OK);
    }
    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> insertAlumno (@RequestBody AlumnoDTO alumno) {
        return new ResponseEntity<Alumno>(alumnoService.insertAlumno(alumno), HttpStatus.CREATED);
    }
    @PutMapping("/alumno/{id}")
    public ResponseEntity<Alumno> updateAlumno (@PathVariable (value = "id") Long alumnoId, @RequestBody AlumnoDTO alumno) {
        return new ResponseEntity<Alumno>(alumnoService.updateAlumno(alumnoId, alumno), HttpStatus.OK);
    }
    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> deleteAlumno (@PathVariable (value = "id") Long alumnoId) {
        return new ResponseEntity<Alumno>(alumnoService.deleteAlumno(alumnoId), HttpStatus.NO_CONTENT);
    }

}
