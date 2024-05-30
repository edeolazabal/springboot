package com.com.jwtdemo.repository;

import com.com.jwtdemo.model.Pais;
import com.com.jwtdemo.model.PaisDTO;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
    // Consulta que usa un parametro para buscar por el nombre, metodo personalizado
    @Query(value = "SELECT id, name from pais where name = ?1", nativeQuery = true)
    List<Pais> listaPorNombre (String nombre);

    // Cuando el numero de columnas de salida no es el mismo que el de la entidad, se usa TUPLE
    @Query (value ="SELECT name FROM pais ORDER BY name DESC", nativeQuery = true)
    List<Tuple> listaNombreOrdenado();

    // Jpa no proporciona la búsqueda por Name, la construimos con sintaxis Jpa
    List<Pais> findByName (String nombre);

}
