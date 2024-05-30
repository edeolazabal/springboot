package com.upc.datajpa20241.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorDto {
    private Integer id;
    private String nombre;
    private Integer equipoId;
}

