package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.entity.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EscuelaRepository extends JpaRepository <Escuela, Long> {
    @Query(value="SELECT e.* FROM schools e JOIN students a ON e.id_school = a.id_school WHERE a.Id = :id", nativeQuery = true)
    Escuela findEscuelaByAlumno(Long id);

 //   @Query(value="SELECT e.* FROM schools e  WHERE e.Id_school = :id", nativeQuery = true)
 //   Escuela findByIdEscuela(Long id);
}
