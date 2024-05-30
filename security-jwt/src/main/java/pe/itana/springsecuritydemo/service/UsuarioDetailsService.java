package pe.itana.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.itana.springsecuritydemo.model.Usuario;

import java.util.Map;
import java.util.Optional;

@Service
public class UsuarioDetailsService implements UserDetailsService  {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Map<String, String> usuarios = Map.of(
        "upc", "USER",
        "jperez", "ADMIN"
    );
    var rol = usuarios.get(username);
    if (rol != null) {
      User.UserBuilder userBuilder = User.withUsername(username);
      // "secreto" => [BCrypt] => $2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq
      String encryptedPassword = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq";
      userBuilder.password(encryptedPassword).roles(rol);
      return userBuilder.build();
    } else {
      throw new UsernameNotFoundException(username);
    }

  }
/*
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    UsuarioService usuarioService = new UsuarioService();

    Optional<Usuario> usuario = usuarioService.findByUsuario(username);
    System.out.println("1. usuario: " +usuario.toString());
    if (usuario != null) {
      User.UserBuilder userBuilder = User.withUsername(usuario.get().getUsuario());
      //userBuilder.password(usuario.get().getClave()).roles(usuario.get().getRol());
      //"secreto" => [BCrypt] => $2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq
      String encryptedPassword = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq";
      userBuilder.password(encryptedPassword).roles("ADMIN");
      return userBuilder.build();
    } else {
      throw new UsernameNotFoundException(username);
    }

  }
*/
}
