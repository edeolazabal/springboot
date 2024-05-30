package manytomanyapi.repository;

import manytomanyapi.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface alumnoRepository extends JpaRepository<Alumno, Integer> {
}
