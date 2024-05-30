package com.upc.cinebdapi.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto implements Serializable {
    private Integer cantidad;
    private Long id_Tarifa;
}
