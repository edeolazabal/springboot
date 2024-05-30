package com.upc.relaciones.repository;

import com.upc.relaciones.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
}
