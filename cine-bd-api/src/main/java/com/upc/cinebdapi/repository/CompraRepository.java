package com.upc.cinebdapi.repository;

import com.upc.cinebdapi.model.Compra;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

 //   @Query(value = "SELECT new com.upc.cinebdapi.model.CompraDto(c.cantidad, c.tarifa_id) FROM compra c")
    @Query(value = "SELECT c.cantidad, c.tarifa_id FROM compra c", nativeQuery = true)
    List<Compra> findCompraDto();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query (value = "INSERT INTO compra (cantidad, fecha, tarifa_id) VALUES (?1, current_timestamp, ?2)", nativeQuery = true)
    void  insertCompraDto (Integer cantidad, Long tarfica_id);
}
