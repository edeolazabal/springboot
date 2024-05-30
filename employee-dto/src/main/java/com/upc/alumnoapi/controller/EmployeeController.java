package com.upc.alumnoapi.controller;

import com.upc.alumnoapi.model.dto.EmployeeCategoryDTO;
import com.upc.alumnoapi.model.dto.EmployeeDTO;
import com.upc.alumnoapi.model.entity.Employee;
import com.upc.alumnoapi.model.IListado;
import com.upc.alumnoapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/employees/lastname/{name}")
    public ResponseEntity<List<Employee>> getbyIdLastnameContainsIgnoreCase(@PathVariable (value = "name") String name) {
        return new ResponseEntity<List<Employee>>(employeeService.findByLastnameContainsIgnoreCase(name), HttpStatus.OK);
    }
    @GetMapping("/dto/{month}")
    public ResponseEntity<List<EmployeeCategoryDTO>> findAllEmployeesCategory(@PathVariable (value = "month") Integer month) {
        return new ResponseEntity<List<EmployeeCategoryDTO>>(employeeService.findAllEmployeesCategory(month), HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findbyIdEmployees(@PathVariable (value = "id") Long employeeId) {
        return new ResponseEntity<Employee>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable (value = "id") Long employeeId, @RequestBody EmployeeDTO employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employeeId, employee), HttpStatus.OK);
    }
    @PostMapping("/employees")
    public ResponseEntity<Employee> insertEmployee(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<Employee>(employeeService.insertEmployee(employee), HttpStatus.CREATED);
    }

}
