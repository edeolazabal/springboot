package com.upc.relaciones.dto;

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
