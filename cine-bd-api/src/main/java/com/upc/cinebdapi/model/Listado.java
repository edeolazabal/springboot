package com.upc.cinebdapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Listado implements Serializable {
    private String categoria;
    private Integer cantidad;
    private Date fecha;
    private Double importe;



}
