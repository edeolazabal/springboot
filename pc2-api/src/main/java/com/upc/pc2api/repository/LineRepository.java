package com.upc.pc2api.repository;

import com.upc.pc2api.model.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LineRepository extends JpaRepository<Line, Long> {
    @Query(value = "SELECT l.* FROM line l, passenger p where p.line_Id = l.id AND p.ID = :id", nativeQuery = true)
    Line findLineByPassenger(Long id);
}
