package pe.itana.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.itana.springsecuritydemo.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String usuario);
}
