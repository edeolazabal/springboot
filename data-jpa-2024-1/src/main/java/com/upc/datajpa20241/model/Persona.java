package com.upc.datajpa20241.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Dni dni;

    public Persona(String nombre) {
        this.nombre = nombre;
    }
}
