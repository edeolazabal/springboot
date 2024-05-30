package com.upc.relaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteCursoDto {
    private Integer estudianteId;
    private Integer cursoId;
}
