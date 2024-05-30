package com.upc.pc120232api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalidaDto {
    String tribune;
    Integer quantity;
    Double price;
    Date matchDate;
    String stadium;
    Double amount;
}
