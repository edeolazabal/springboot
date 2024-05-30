package com.upc.datajpa20241.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String denominacion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo", cascade = CascadeType.ALL)
    List<Jugador> jugadores;

    public Equipo(String denominacion) {
        this.denominacion = denominacion;
    }
}
