package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
