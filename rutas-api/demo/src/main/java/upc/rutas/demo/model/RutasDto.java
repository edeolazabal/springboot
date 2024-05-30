package upc.rutas.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutasDto {
    String nombre;
    String tipo;
    LocalDate fechaCreacion;
    Integer extension;
}
