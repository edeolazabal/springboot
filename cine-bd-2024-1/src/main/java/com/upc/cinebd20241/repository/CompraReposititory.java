package com.upc.cinebd20241.repository;

import com.upc.cinebd20241.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraReposititory extends JpaRepository<Compra, Long> {

}
