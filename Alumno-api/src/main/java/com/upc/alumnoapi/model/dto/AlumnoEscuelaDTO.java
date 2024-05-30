package com.upc.alumnoapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoEscuelaDTO implements Serializable {
    private Long id;
    private String nombreCompleto;
    private String nombreEscuela;
    private String localidad;
}
