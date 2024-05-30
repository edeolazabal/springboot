package pe.itana.springsecuritydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.itana.springsecuritydemo.model.Usuario;
import pe.itana.springsecuritydemo.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public Optional<Usuario> findByUsuario (String  usuario) { return usuarioRepository.findByUsuario(usuario);}

}
