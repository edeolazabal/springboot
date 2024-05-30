package com.upc.alumnoscrud.controller;

import com.upc.alumnoscrud.model.Alumno;
import com.upc.alumnoscrud.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prueba")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // Obtener lista de todos los alumnos
    @GetMapping("/alumnos")
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }
    // Obtener alumno por Id
    @GetMapping("/alumnos/{id}")
    public Optional<Alumno> getAlumno (@PathVariable(value = "id") Long alumnoID) {
        return alumnoRepository.findById(alumnoID);
    }
    // Crear Alumno
    @PostMapping("/alumnos")
    public Alumno insertAlumno (@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    // Modificar alumno
    @PutMapping("/alumnos/{id}")
    public Alumno updateAlumno (@PathVariable(value = "id") Long alumnoId,
                                @RequestBody Alumno alumnoModificado) {
        Optional<Alumno> alumno = alumnoRepository.findById(alumnoId);
        if (alumno.stream().count() == 0)
        {
            return new Alumno("No existe en BD", "No se actualizó");
        }
        Alumno alumnoFinal = alumnoRepository.getById(alumnoId);
        alumnoFinal.setNombre(alumnoModificado.getNombre());
        alumnoFinal.setApellido(alumnoModificado.getApellido());
        return alumnoRepository.save(alumnoFinal);

    }

    // Eliminar alumno
     //  si el registro existe --> elimina, caso contrario --> mensaje no existe
    @DeleteMapping("/alumnos/{id}")
    public String deleteAlumno(@PathVariable(value = "id") Long alumnoId) {
        Optional<Alumno> alumno = alumnoRepository.findById(alumnoId);
        if (alumno.stream().count() == 0) {
            return "Registro con ID = " + alumnoId + " NO Existe";
        }
        alumnoRepository.deleteById(alumnoId);
        return "Registro con ID = " + alumnoId + " Ha sido eliminado de la BD";
    }

}
