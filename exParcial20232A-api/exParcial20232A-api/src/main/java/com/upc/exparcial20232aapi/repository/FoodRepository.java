package com.upc.exparcial20232aapi.repository;

import com.upc.exparcial20232aapi.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query(value = "SELECT SUM(quantity_In_Kg) Quantity FROM food where storage_Id =?1", nativeQuery = true)
    Double sumOfKg (Integer storage_id);
}
