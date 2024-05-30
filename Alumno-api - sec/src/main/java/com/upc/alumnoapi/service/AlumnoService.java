package com.upc.alumnoapi.service;

import com.upc.alumnoapi.model.dto.AlumnoDTO;
import com.upc.alumnoapi.model.dto.AlumnoEscuelaDTO;
import com.upc.alumnoapi.model.entity.Alumno;
import com.upc.alumnoapi.model.entity.Escuela;
import com.upc.alumnoapi.repository.AlumnoRepository;
import com.upc.alumnoapi.repository.EscuelaRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    EscuelaRepository escuelaRepository;

    // Lectura de todos los registros
       // Leer todos

    @Transactional (readOnly = true)
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    // Lectura por ID
       // Leer por ID -> si no existe lanzar una excepcion
    @Transactional (readOnly = true)
    public Alumno getAlumno(Long alumnoId) {
        return alumnoRepository.findById(alumnoId)
                .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con Id = "+ alumnoId));
    }

    // Crear un alumno
        // Crear  --> Nuevo registro en alumnos, sumar 1 al campo Nro. de alumnos en la tabla Escuela
    @Transactional
    public Alumno insertAlumno (AlumnoDTO alumnoDetalle) {
        Alumno alum = new Alumno();
        Escuela esc;
        alum.setFirstname(alumnoDetalle.getFirstname());
        alum.setLastname(alumnoDetalle.getLastname());
        // Escuela
        esc = escuelaRepository.findById(alumnoDetalle.getSchoolId())
                .orElse(esc = null);
        alum.setEscuela(esc);

        return alumnoRepository.save(alum);
    }
    // Modificar un alumno

    // Actualizar
    @Transactional
    public Alumno updateAlumno (Long alumnoId, AlumnoDTO alumnoDetalle) {
        // Leer por ID -> si no existe lanzar una excepcion
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con ID = "+ alumnoId));
        Escuela esc;
        // Verificar que hay cambios en los campos --> salir
        if (alumno.getEscuela() != null)
            if (alumno.getEscuela().getId().equals(alumnoDetalle.getSchoolId()) &&
                alumno.getFirstname().equals(alumnoDetalle.getFirstname()) &&
                alumno.getLastname().equals(alumnoDetalle.getLastname()))
            return alumno;
        //if (alumno.equals(alumnoDetalle))
        //{ return alumnoDetalle; }

        alumno.setFirstname(alumnoDetalle.getFirstname());
        alumno.setLastname(alumnoDetalle.getLastname());
        esc = escuelaRepository.findById((alumnoDetalle.getSchoolId()))
                .orElse(esc = null);
        alumno.setEscuela(esc);
        return alumnoRepository.save(alumno);
    }
     // Eliminar un alumno
        // Leer por ID -> si no existe lanzar una excepcion
        // Eliminar
    @Transactional
    public Alumno deleteAlumno (Long alumnoId) {
        // Leer por ID -> si no existe lanzar una excepcion
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con ID = "+ alumnoId));
        alumnoRepository.deleteById(alumnoId);
        return alumno;

    }
    @Transactional(readOnly = true)
    public List<AlumnoEscuelaDTO> getAllAlumnosEscuela() {
        List<AlumnoEscuelaDTO> listaDTO = new ArrayList<AlumnoEscuelaDTO>();
        List<Alumno> alumnos = alumnoRepository.findAll();
        Escuela escuela;
        for (Alumno alumno: alumnos)
        {
            AlumnoEscuelaDTO dto = new AlumnoEscuelaDTO();
            escuela = escuelaRepository.findEscuelaByAlumno(alumno.getId());
            dto.setNombreCompleto(alumno.getLastname() + ", " + alumno.getFirstname());
            dto.setNombreEscuela("Sin Escuela");
            dto.setLocalidad("Virtual");
            if (escuela != null) {
                dto.setNombreEscuela(escuela.getDescription());
                dto.setLocalidad("Monterrico");
                if (escuela.getId() > 1)
                    dto.setLocalidad("San Isidro");
            }
            dto.setId(alumno.getId());
            listaDTO.add(dto);
        }
        return listaDTO;
    }



}
