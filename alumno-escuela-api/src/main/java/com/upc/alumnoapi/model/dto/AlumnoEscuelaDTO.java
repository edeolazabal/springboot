package com.upc.alumnoapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoEscuelaDTO {
    private Long id;
    private String nombreCompleto;
    private String nombreEscuela;
}
