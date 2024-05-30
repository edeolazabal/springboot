package com.upc.alumnoapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCategoryDTO implements Serializable {
//    private Long Id;
    private String fullName;
    private String month;
    private Double workedHours;
    private Double salaryByHour;
    private Double salaryOfMonth;
    private String reportDateTime;
}
