package com.upc.pc2api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerLineDTO implements Serializable {
    private String fullName;
    private String month;
    private Integer quantity;
    private Double price;
    private Double totalAmount;
    private String reportDateTime;
}

