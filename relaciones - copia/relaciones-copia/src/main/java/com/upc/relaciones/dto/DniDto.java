package com.upc.relaciones.dto;

import com.upc.relaciones.models.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DniDto {
    private Integer id;
    private String nombre;
    private Integer personaId;
}
