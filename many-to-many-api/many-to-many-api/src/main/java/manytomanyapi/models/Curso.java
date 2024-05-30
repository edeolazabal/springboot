package manytomanyapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String description;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "alumnos_cursos", joinColumns =  @JoinColumn(name= "curso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    )
    List<Alumno> alumnos;
}
