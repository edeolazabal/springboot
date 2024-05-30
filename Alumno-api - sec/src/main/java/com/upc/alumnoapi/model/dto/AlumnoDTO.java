package com.upc.alumnoapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO implements Serializable {
    private Long Id;
    private String firstname;
    private String lastname;
    private Long schoolId;
}
