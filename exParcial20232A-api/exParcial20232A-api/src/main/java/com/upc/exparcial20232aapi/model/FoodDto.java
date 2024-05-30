package com.upc.exparcial20232aapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    String name;
    double quantityInKg;
    Date entryDate;
    Integer storageId;
}
