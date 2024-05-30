package com.upc.alumnoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Listado {
    private String fullName;
    private String Month;
    private Double workedHours;
    private Double salaryByHour;
    private Double salaryOfMonth;
    private Double tax;
    private Double netSalary;
    private String reportDateTime;
}
