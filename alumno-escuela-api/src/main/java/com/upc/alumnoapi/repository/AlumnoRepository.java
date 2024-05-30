package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.dto.AlumnoDTO;
import com.upc.alumnoapi.model.entity.Alumno;
import com.upc.alumnoapi.model.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
