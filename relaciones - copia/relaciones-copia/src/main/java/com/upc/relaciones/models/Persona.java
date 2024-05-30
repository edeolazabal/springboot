package com.upc.relaciones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Dni dni;
    public Persona( String nombre) {
        this.nombre = nombre;
    }
}
