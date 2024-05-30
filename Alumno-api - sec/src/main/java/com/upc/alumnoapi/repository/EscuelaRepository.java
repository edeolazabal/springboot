package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EscuelaRepository extends JpaRepository <Escuela, Long> {

    @Query(value ="SELECT e.* FROM schools e JOIN students s  ON s.school_id = e.id WHERE s.id = :id", nativeQuery =true)
    Escuela findEscuelaByAlumno (Long id);

}
