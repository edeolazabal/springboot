package com.upc.alumnoapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstname;
    private String lastname;
    private Integer monthOfYear;
    @Column(name = "worked_hours", nullable = false, scale = 2)
    private Double  workedHours;
    @Column(name = "salary_by_hour", nullable = false, scale = 2)
    private Double  salaryByHour;
}
