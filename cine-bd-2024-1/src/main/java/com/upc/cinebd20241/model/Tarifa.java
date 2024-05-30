package com.upc.cinebd20241.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String categoria;
    private Double precio;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tarifa", cascade = CascadeType.ALL)
    List<Compra> compra;

}
