package com.upc.demosec.repository;

import com.upc.demosec.model.Authority;
import com.upc.demosec.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> findByName (AuthorityName name);
}
