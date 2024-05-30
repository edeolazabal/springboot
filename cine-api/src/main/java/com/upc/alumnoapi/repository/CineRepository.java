package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.Cine;
import com.upc.alumnoapi.model.IBoletaCine;
import com.upc.alumnoapi.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CineRepository extends JpaRepository<Cine, Long> {

    @Query(value = "SELECT current_date || ' ' || current_time as fechaHora, " +
            ":cantidad as cantidad, " +
            "Category as categoria, " +
            "CASE :cantidad > 20 " +
            "WHEN true THEN (price * :cantidad) * 0.9 " +
            "WHEN false THEN (price * :cantidad) " +
            "END as importeTotal, " +
            "(price * :cantidad * 0.18) as igv, " +
            "(price * :cantidad * ( 1 - 0.18)) as imponibleBase " +
            "FROM Cine " +
            "WHERE id = :categoriaId", nativeQuery = true)
    Ticket findByCategoria(Integer cantidad, Long categoriaId);

    @Query(value = "SELECT current_date || ' ' || current_time as fechaHora, " +
            ":cantidad as cantidad, " +
            "Category as categoria, " +
            "CASE :cantidad > 20 " +
            "WHEN true THEN " +
            "   CASE id " +
            "   WHEN 1 THEN (price * (0.75) * :cantidad) * 0.9 " +
            "   WHEN 2 THEN (price * (0.80) * :cantidad) * 0.9 " +
            "   WHEN 3 THEN (price * (0.85) * :cantidad) * 0.9 " +
            "   WHEN 4  THEN (price * (0.90) * :cantidad) * 0.9 " +
                "END " +
            "WHEN false THEN " +
                "CASE id " +
            "    WHEN 1 THEN (price * (0.75) * :cantidad) " +
            "    WHEN 2 THEN (price * (0.80) * :cantidad) " +
            "    WHEN 3 THEN (price * (0.85) * :cantidad) " +
            "    WHEN 4 THEN (price * (0.90) * :cantidad) " +
            "    END " +
            "END as importeTotal, " +
            "(price * :cantidad * 0.18) as igv, " +
            "(price * :cantidad * ( 1 - 0.18)) as imponibleBase " +
            "FROM Cine ", nativeQuery = true)
   List<Ticket> findAllCategoria(Integer cantidad);

    List<Cine> findByCategory(String name);

    List<Cine> findByCategoryContainingIgnoreCase(String contenido);

}
