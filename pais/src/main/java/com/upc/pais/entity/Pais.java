package com.upc.pais.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pais {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String capital;

}
