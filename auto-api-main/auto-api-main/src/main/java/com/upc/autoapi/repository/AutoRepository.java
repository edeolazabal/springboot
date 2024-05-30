package com.upc.autoapi.repository;

import com.upc.autoapi.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Integer> {
}
