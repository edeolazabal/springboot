package com.upc.alumnoapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {
    private Long Id;
    private String firstname;
    private String lastname;
    private Long idSchool;

}
