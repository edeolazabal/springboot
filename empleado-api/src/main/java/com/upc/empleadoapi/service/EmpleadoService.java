package com.upc.empleadoapi.service;

import com.upc.empleadoapi.model.Empleado;
import com.upc.empleadoapi.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> list() {
        return empleadoRepository.findAll();
    }
    public Empleado insert (Empleado empleado) {
        Empleado nuevoEmpleado = empleadoRepository.save(empleado);
        return nuevoEmpleado;
    }
}
