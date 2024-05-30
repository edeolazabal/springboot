package com.upc.relaciones.repository;

import com.upc.relaciones.models.Dni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DniRepository extends JpaRepository <Dni, Integer> {
}
