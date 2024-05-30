package com.upc.pecerosmila.repository;

import com.upc.pecerosmila.model.entity.BudgetCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BudgetCityRepository extends JpaRepository<BudgetCity, Long> {


    @Query(value ="SELECT e.* FROM budgetcities e JOIN cities s ON s.budgetcity_id = e.id WHERE s.id = :id", nativeQuery =true)
    BudgetCity findBudgetCityByCity (Long id);


}
