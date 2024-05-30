package com.upc.cinebd20241.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Listado {
    private String categoria;
    private Integer cantidad;
    private Date fecha;
    private Double importe;
}
