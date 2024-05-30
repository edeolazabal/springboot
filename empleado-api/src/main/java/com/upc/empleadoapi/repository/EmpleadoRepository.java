package com.upc.empleadoapi.repository;

import com.upc.empleadoapi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
