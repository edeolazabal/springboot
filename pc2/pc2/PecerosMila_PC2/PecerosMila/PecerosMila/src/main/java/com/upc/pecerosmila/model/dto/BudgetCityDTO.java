package com.upc.pecerosmila.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetCityDTO implements Serializable {
    private Long Id;
    private String classification;
    private double budgetAmount;
}
