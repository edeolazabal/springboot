package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository <Category, Long> {

    @Query(value = "SELECT c.* FROM category c, employee e where e.category_Id = c.id AND e.ID = :id", nativeQuery = true)
    Category findCategoryByEmployee(Long id);
}
