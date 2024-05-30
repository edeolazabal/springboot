package com.upc.alumnoapi.service;

import com.upc.alumnoapi.model.Employee;
import com.upc.alumnoapi.model.IListado;
import com.upc.alumnoapi.model.Listado;
import com.upc.alumnoapi.repository.EmployeeRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Employee> findByLastnameContainsIgnoreCase(String name) {
        return employeeRepository.findByLastnameContainsIgnoreCase(name);
    }
    @Transactional(readOnly = true)
    public List<IListado> findByMonthOrderByLastname(Integer month) {
        return employeeRepository.findByMonthOrderByLastname(month);
    }

    @Transactional(readOnly = true)
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Empleado con ID = " + employeeId + " no existe"));
    }

    @Transactional
    public Employee insertEmployee (Employee employeeDetails) {
        return employeeRepository.save(employeeDetails);
    }

    @Transactional
    public Employee updateEmployee(Long employeeId, Employee employee)  {
        // Validar que existe el Id
        Employee employee1 = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Empleado con ID = " + employeeId + " no existe"));
        // No debe cambiar el salrio por hora
        System.out.println("Salario employee1: "+ employee1.getSalaryByHour() +" Salario Employee: "+ employee.getSalaryByHour() );
        if (!employee1.getSalaryByHour().equals(employee.getSalaryByHour()))
            throw new OpenApiResourceNotFoundException("No se puede modificar el Salario por hora");
        // Mes debe estar entre 1 y 12
        if (employee1.getMonthOfYear() < 1 || employee.getMonthOfYear() > 12)
            throw new OpenApiResourceNotFoundException("Mes no puede ser mayor que 12 o menor que 1");
        if (employee1.equals(employee)) {
            return employee1; }
        employee1.setFirstname(employee.getFirstname());
        employee1.setLastname(employee.getLastname());
        employee1.setMonthOfYear(employee.getMonthOfYear());
        employee1.setWorkedHours(employee.getWorkedHours());

        return employeeRepository.save(employee1);
        }
    }
