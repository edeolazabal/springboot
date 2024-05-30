package com.upc.relaciones.repository;

import com.upc.relaciones.dto.CuentaJugadorDto;
import com.upc.relaciones.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
