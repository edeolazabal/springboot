package upc.rutas.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.rutas.demo.model.Rutas;

public interface RutasRepository extends JpaRepository<Rutas, Long> {
}
