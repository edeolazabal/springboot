package com.upc.datajpa20241.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoDto {
    private Integer id;
    private String denominacion;
}