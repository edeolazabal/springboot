package com.upc.pc2api.repository;

import com.upc.pc2api.model.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    @Query(value = "SELECT p.* " +
            "from passenger p " +
            "where month_of_year = :month " +
            "order by p.lastname", nativeQuery = true )
    List<Passenger> findAllPassengersByMonthOrderByLastname(Integer month);
}
