package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.entity.Authority;
import com.upc.alumnoapi.util.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByName (AuthorityName name);
}
