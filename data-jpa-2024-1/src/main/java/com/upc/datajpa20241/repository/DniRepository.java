package com.upc.datajpa20241.repository;

import com.upc.datajpa20241.model.Dni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DniRepository extends JpaRepository<Dni, Integer> {
}