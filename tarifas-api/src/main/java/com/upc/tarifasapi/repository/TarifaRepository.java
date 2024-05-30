package com.upc.tarifasapi.repository;

import com.upc.tarifasapi.model.entity.Tarifa;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
//    @Query(value = "SELECT categoria FROM Tarifa WHERE precio > 10 AND > 20", nativeQuery = true)
//      List<Tuple> ListaSoloCategoria();

      @Query(value = "SELECT MAX(precio) FROM Tarifa")
      int precioMaximo();

    List<Tarifa> findAllByCategoria(String Categoria);
}
