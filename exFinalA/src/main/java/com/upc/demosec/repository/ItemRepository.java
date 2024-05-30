package com.upc.demosec.repository;

import com.upc.demosec.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM item WHERE warehouse = ?1 ORDER BY description", nativeQuery = true)
    List<Item> search (Integer warehouse);

     List<Item> findAllByWarehouseOrderByDescription (Integer warehouse);
}
