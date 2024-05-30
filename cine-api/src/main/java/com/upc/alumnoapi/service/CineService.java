package com.upc.alumnoapi.service;

import com.upc.alumnoapi.model.Cine;
import com.upc.alumnoapi.model.IBoletaCine;
import com.upc.alumnoapi.model.Ticket;
import com.upc.alumnoapi.repository.CineRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CineService {
    @Autowired
    CineRepository cineRepository;

    // Lectura de todos los registros
    // Leer todos

    @Transactional(readOnly = true)
    public List<Cine> getAllCines() {
        return cineRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Ticket getByCategoria(Integer cantidad, Long categoriaId) {
        return cineRepository.findByCategoria(cantidad, categoriaId);
    }
    @Transactional(readOnly = true)
    public List<Ticket> getAllCategoria(Integer cantidad) {
        return cineRepository.findAllCategoria(cantidad);
    }
    @Transactional(readOnly = true)
    public List<Cine> findByCategory (String name) {
        return cineRepository.findByCategoryContainingIgnoreCase(name);
    }
    // Lectura por ID
    // Leer por ID -> si no existe lanzar una excepcion
    @Transactional(readOnly = true)
    public Cine getCine(Long cineId) {
        return cineRepository.findById(cineId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con Id = " + cineId));
    }


    // Crear un alumno
    // Crear  --> Nuevo registro en alumnos, sumar 1 al campo Nro. de alumnos en la tabla Escuela
    @Transactional
    public Cine insertCine(Cine cineDetalle) {
        return cineRepository.save(cineDetalle);
    }
    // Modificar un alumno

    // Actualizar
    @Transactional
    public Cine updateCine(Long cineId, Cine cineDetalle) {
        // Leer por ID -> si no existe lanzar una excepcion
        Cine cine = cineRepository.findById(cineId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID = " + cineId));
        // Verificar que hay cambios en los campos --> salir
        if (cine.equals(cineDetalle)) {
            return cineDetalle;
        }
        cine.setCategory(cineDetalle.getCategory());
        cine.setPrice(cineDetalle.getPrice());
        return cineRepository.save(cine);
    }

    // Eliminar un alumno
    // Leer por ID -> si no existe lanzar una excepcion
    // Eliminar
    @Transactional
    public Cine deleteCine(Long cineId) {
        // Leer por ID -> si no existe lanzar una excepcion
        Cine cine = cineRepository.findById(cineId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe registro con ID = " + cineId));
        cineRepository.deleteById(cineId);
        return cine;
    }
}
