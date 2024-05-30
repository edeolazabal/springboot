package com.upc.demosec.repository;

import com.upc.demosec.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT * FROM account WHERE type = ?1 ORDER BY amount DESC", nativeQuery = true)
    List<Account> search (String type);

    List<Account> findAllByTypeOrderByAmountDesc (String type);
}
