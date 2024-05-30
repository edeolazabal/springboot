package com.upc.catbd2api.repository;

import com.upc.catbd2api.model.Categoria;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>
{
    // Consulta a 2 tablas - LEFT JOIN, COUNT y GROUP BY
    @Query(value = "select c.id, c.descripcion, count(p.id) TOTAL\n" +
            "FROM Categoria c LEFT JOIN Producto p \n" +
            "ON c.id = categoria_id\n" +
            "GROUP BY c.id", nativeQuery = true)
    List<Tuple> listaTotalProductosPorCategoria();
}
