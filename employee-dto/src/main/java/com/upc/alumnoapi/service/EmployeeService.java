package com.upc.alumnoapi.service;

import com.upc.alumnoapi.model.dto.EmployeeCategoryDTO;
import com.upc.alumnoapi.model.dto.EmployeeDTO;
import com.upc.alumnoapi.model.entity.Category;
import com.upc.alumnoapi.model.entity.Employee;
import com.upc.alumnoapi.model.IListado;
import com.upc.alumnoapi.repository.CategoryRepository;
import com.upc.alumnoapi.repository.EmployeeRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CategoryRepository categoryRepository;

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
    /// @Transactional(readOnly = true)
    public List<EmployeeCategoryDTO> findAllEmployeesCategory(Integer month) {
        List<EmployeeCategoryDTO> listaDTO = new ArrayList<EmployeeCategoryDTO>();
        List<Employee> employees = employeeRepository.findAllEmployeesByMonthOrderByLastname(month);
        Category category;
        EmployeeCategoryDTO dto;
        String d = "";

        for (Employee emp: employees) {
            dto = new EmployeeCategoryDTO();
            category = categoryRepository.findCategoryByEmployee(emp.getId());
            dto.setMonth(monthInLetters(emp.getMonthOfYear()));
            dto.setFullName(emp.getLastname() + ", " + emp.getFirstname());
            dto.setWorkedHours(emp.getWorkedHours());
            if (category != null)
                { dto.setSalaryByHour(category.getSalaryByHour()); }
            else
                {dto.setSalaryByHour(0.0);}
            // Pago doble en Julio y Diciembre
            dto.setSalaryOfMonth(emp.getWorkedHours() * dto.getSalaryByHour());
            //System.out.println("dto.getMonth() "+dto.getMonth());
            if (emp.getMonthOfYear().equals(7)  || emp.getMonthOfYear().equals(12))
                dto.setSalaryOfMonth(2 * dto.getSalaryOfMonth());
            d = LocalDate.now() + " " + LocalTime.now();
            dto.setReportDateTime(d);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    private String monthInLetters(int month) {
        String res = "";
        switch (month) {
            case 1: { res = "ENERO"; break;}
            case 2: { res = "FEBRERO"; break;}
            case 3: { res = "MARZO"; break;}
            case 4: { res = "ABRIL"; break;}
            case 5: { res = "MAYO"; break;}
            case 6: { res = "JUNIO"; break;}
            case 7: { res = "JULIO"; break;}
            case 8: { res = "AGOSTO"; break;}
            case 9: { res = "SETIEMBRE"; break;}
            case 10: { res = "OCTUBRE"; break;}
            case 11: { res = "NOVIEMBRE"; break;}
            case 12: { res = "DICIEMBRE"; break;}
        }
        return res;
    }


    @Transactional(readOnly = true)
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Empleado con ID = " + employeeId + " no existe"));
    }

    @Transactional
    public Employee insertEmployee (EmployeeDTO employeeDetails) {
        Employee emp = new Employee();
        Category cat;
        emp.setFirstname(employeeDetails.getFirstname());
        emp.setLastname(employeeDetails.getLastname());
        emp.setMonthOfYear(employeeDetails.getMonthOfYear());
        emp.setWorkedHours(employeeDetails.getWorkedHours());

        // Categoria
        System.out.println("employeeDetails "+employeeDetails);
        System.out.println("employeeDetails.getIdCategory() "+employeeDetails.getCategoryId());
        cat = categoryRepository.findById(employeeDetails.getCategoryId())
                .orElse(cat = null);
        emp.setCategory(cat);
        return employeeRepository.save(emp);
    }

    @Transactional
    public Employee updateEmployee(Long employeeId, EmployeeDTO employee)  {
        // Validar que existe el Id
        Employee emp = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Empleado con ID = " + employeeId + " no existe"));
        Category cat;
        // Mes debe estar entre 1 y 12
        if (emp.getMonthOfYear() < 1 || employee.getMonthOfYear() > 12)
            throw new OpenApiResourceNotFoundException("Mes no puede ser mayor que 12 o menor que 1");
  //      if (employee1.equals(employee)) {
  //          return employee1; }
        emp.setFirstname(employee.getFirstname());
        emp.setLastname(employee.getLastname());
        emp.setMonthOfYear(employee.getMonthOfYear());
        emp.setWorkedHours(employee.getWorkedHours());
        // Categoria
        System.out.println("employeeDetails "+employee);
        System.out.println("employeeDetails.getIdCategory() "+employee.getCategoryId());
        cat = categoryRepository.findById(employee.getCategoryId())
                .orElse(cat = null);
        emp.setCategory(cat);
 //       employee1.setCategory(employee.getCategory());

        return employeeRepository.save(emp);
        }

    }
