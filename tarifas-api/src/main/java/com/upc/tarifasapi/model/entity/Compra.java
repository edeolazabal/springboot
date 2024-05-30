package com.upc.tarifasapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private Date fecha = new Date();

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnoreProperties( {"hibernateLazyInitializar", "handler"})
    private Tarifa tarifa;
}
