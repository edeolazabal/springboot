package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.entity.Employee;
import com.upc.alumnoapi.model.IListado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

     @Query(value = "SELECT e.lastname || ', ' || e.firstname as fullName, CASE e.month_of_year " +
             "WHEN 1 THEN 'ENERO' " +
             "WHEN 2 THEN 'FEBRERO' " +
             "WHEN 3 THEN 'MARZO' " +
             "WHEN 4 THEN 'ABRIL' " +
             "WHEN 5 THEN 'MAYO' " +
             "WHEN 6 THEN 'JUNIO' " +
             "WHEN 7 THEN 'JULIO' " +
             "WHEN 8 THEN 'AGOSTO' " +
             "WHEN 9 THEN 'SETIEMBRE' " +
             "WHEN 10 THEN 'OCTUBRE' " +
             "WHEN 11 THEN 'NOVIEMBRE' " +
             "WHEN 13 THEN 'DICIEMBRE' " +
             "END as Month, " +
             "e.worked_hours as workedHours, " +
             "e.salary_by_hour as salaryByHour, " +
             "CASE (e.month_of_year  IN (7,12)) " +
             "WHEN true  THEN 2 *(e.worked_hours * e.salary_by_hour) " +
             "WHEN false THEN (e.worked_hours * e.salary_by_hour) END as salaryOfMonth, " +
             "current_date || ' ' || current_time as reportDateTime " +
             "from employee e " +
             "where month_of_year = :month " +
             "order by e.lastname", nativeQuery = true )
    List<IListado> findByMonthOrderByLastname(Integer month);

    @Query(value = "SELECT e.* " +
            "from employee e " +
            "where month_of_year = :month " +
            "order by e.lastname", nativeQuery = true )
    List<Employee> findAllEmployeesByMonthOrderByLastname(Integer month);
    List<Employee> findByLastnameContainsIgnoreCase(String name);

    List<Employee> findEmployeesByMonthOfYear(Integer month);



}
