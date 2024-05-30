package manytomanyapi.repository;

import manytomanyapi.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cursoRepository extends JpaRepository<Curso, Integer> {
}
