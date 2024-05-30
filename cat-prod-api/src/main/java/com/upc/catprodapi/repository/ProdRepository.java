package com.upc.catprodapi.repository;

import com.upc.catprodapi.model.Prod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepository extends JpaRepository<Prod, Long> {
}
