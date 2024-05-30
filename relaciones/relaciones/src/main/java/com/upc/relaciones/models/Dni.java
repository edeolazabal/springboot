package com.upc.relaciones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToOne
    @JoinColumn(name = "persona_id")
    Persona persona;
    public Dni (String nombre, Persona persona) {
        this.nombre = nombre;
        this.persona = persona;
    }
}
