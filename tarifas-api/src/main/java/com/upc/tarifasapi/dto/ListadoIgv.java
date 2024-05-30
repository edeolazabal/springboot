package com.upc.tarifasapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadoIgv implements Serializable {
    private String categoria;
    private Integer cantidad;
    private Date fecha;
    private double importe;
    private double igv;
    private double importe_con_igv;

}
