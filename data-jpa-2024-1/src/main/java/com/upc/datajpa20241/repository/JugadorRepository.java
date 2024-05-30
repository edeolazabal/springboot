package com.upc.datajpa20241.repository;

import com.upc.datajpa20241.dto.CuentaJugadorDto;
import com.upc.datajpa20241.model.Jugador;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    @Query(value="select nombre from jugador where id = :id", nativeQuery = true)
    String obtieneNombre (@Param("id") Integer id);

    @Query(value="select denominacion, count(*) cantidad from jugador j INNER JOIN equipo e ON j.equipo_id = e.id where e.id = :id GROUP BY denominacion", nativeQuery = true)
    Tuple obtieneNombre2 (@Param("id") Integer id);  // genera una tupla a partir de una consulta a 2 tablas
}
