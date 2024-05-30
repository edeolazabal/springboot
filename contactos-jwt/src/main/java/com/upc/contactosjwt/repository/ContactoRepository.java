package com.upc.contactosjwt.repository;

import com.upc.contactosjwt.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
