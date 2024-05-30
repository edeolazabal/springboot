package com.upc.relaciones.repository;

import com.upc.relaciones.dto.CuentaJugadorDto;
import com.upc.relaciones.models.Jugador;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {


    @Query(value= "select * from jugador  where equipo_id = ?1", nativeQuery = true)
    Jugador cuentaJugadores (Integer id);

    @Query(value = "select denominacion, count(*) cantidad from jugador j inner join equipo e on equipo_id = e.id where j.equipo_id = :id group by denominacion", nativeQuery = true)
    Tuple cuentaJugadores2 (@Param("id") Integer id);

    @Query(value="select nombre from jugador where id = :id", nativeQuery = true)
    String obtieneNombre (@Param ("id") Integer id);


}
