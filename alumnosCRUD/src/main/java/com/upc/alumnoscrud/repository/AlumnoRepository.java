package com.upc.alumnoscrud.repository;

import com.upc.alumnoscrud.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
