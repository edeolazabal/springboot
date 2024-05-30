package com.upc.pecerosmila.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO implements Serializable {
    private Long Id;
    private String name;
    private String region;
    private Number monthOfYear;
    private Number population;
    private Long budgetCityId;
}
