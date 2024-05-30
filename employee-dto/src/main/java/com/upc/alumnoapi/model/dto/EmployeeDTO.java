package com.upc.alumnoapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private Long Id;
    private String firstname;
    private String lastname;
    private Integer monthOfYear;
    private Double  workedHours;
    private Long categoryId;
}
