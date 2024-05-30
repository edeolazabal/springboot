package com.upc.alumnoapi.repository;

import com.upc.alumnoapi.model.Employee;
import com.upc.alumnoapi.model.IListado;
import com.upc.alumnoapi.model.Listado;
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
             "CASE (e.month_of_year  IN (7,12)) " +
             "WHEN true  THEN " +
                "CASE 2 *(e.worked_hours * e.salary_by_hour) < 1500 " +
                "WHEN true THEN 0 " +
                "WHEN false THEN 2 * (e.worked_hours * e.salary_by_hour * 0.08) " +
                "END " +
             "WHEN false THEN " +
                 "CASE (e.worked_hours * e.salary_by_hour) < 1500 " +
                 "WHEN true THEN 0 " +
                 "WHEN false THEN (e.worked_hours * e.salary_by_hour * 0.08) " +
                 "END " +
             "END as tax, " +
             "CASE (e.month_of_year  IN (7,12)) " +
             "WHEN true  THEN " +
                 "CASE 2 *(e.worked_hours * e.salary_by_hour) < 1500 " +
                 "WHEN true THEN (2 * e.worked_hours * e.salary_by_hour) " +
                 "WHEN false THEN 2 * (e.worked_hours * e.salary_by_hour * (1- 0.08)) " +
                 "END " +
             "WHEN false THEN " +
                 "CASE (e.worked_hours * e.salary_by_hour) < 1500 " +
                 "WHEN true THEN e.worked_hours * e.salary_by_hour " +
                 "WHEN false THEN (e.worked_hours * e.salary_by_hour * (1-0.08)) " +
                 "END " +
             "END as netSalary, " +
             "current_date || ' ' || current_time as reportDateTime " +
             "from employee e " +
             "where month_of_year = :month " +
             "order by e.lastname", nativeQuery = true )
    List<IListado> findByMonthOrderByLastname(Integer month);

    List<Employee> findByLastnameContainsIgnoreCase(String name);



}
