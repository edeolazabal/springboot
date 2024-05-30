package pe.itana.springsecuritydemo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.itana.springsecuritydemo.model.AuthenticationReq;
import pe.itana.springsecuritydemo.model.TokenInfo;
import pe.itana.springsecuritydemo.model.Usuario;
import pe.itana.springsecuritydemo.service.JwtUtilService;
import pe.itana.springsecuritydemo.service.UsuarioService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("")
public class DemoRest {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  UserDetailsService usuarioDetailsService;

  @Autowired
  private JwtUtilService jwtUtilService;

  @Autowired
  private UsuarioService usuarioService;

  private static final Logger logger = LoggerFactory.getLogger(DemoRest.class);

  @GetMapping("/mensaje")
  public ResponseEntity<?> getMensaje() {
    var auth =  SecurityContextHolder.getContext().getAuthentication();
    logger.info("Datos del Usuario: {}", auth.getPrincipal());
    logger.info("Datos de los Permisos {}", auth.getAuthorities());
    logger.info("Esta autenticado {}", auth.isAuthenticated());

    Map<String, String> mensaje = new HashMap<>();
    mensaje.put("contenido", "Hola Peru");
    return ResponseEntity.ok(mensaje);
  }

  @GetMapping("/admin")
  public ResponseEntity<?> getMensajeAdmin() {

    var auth =  SecurityContextHolder.getContext().getAuthentication();
    logger.info("Datos del Usuario: {}", auth.getPrincipal());
    logger.info("Datos de los Permisos {}", auth.getAuthorities());
    logger.info("Esta autenticado {}", auth.isAuthenticated());

    Map<String, String> mensaje = new HashMap<>();
    mensaje.put("contenido", "Hola Admin");
    return ResponseEntity.ok(mensaje);
  }

  @GetMapping("/publico")
  public ResponseEntity<?> getMensajePublico() {
    var auth =  SecurityContextHolder.getContext().getAuthentication();
    logger.info("Datos del Usuario: {}", auth.getPrincipal());
    logger.info("Datos de los Permisos {}", auth.getAuthorities());
    logger.info("Esta autenticado {}", auth.isAuthenticated());

    Map<String, String> mensaje = new HashMap<>();
    mensaje.put("contenido", "Hola Mundo");
    return ResponseEntity.ok(mensaje);
  }



  @PostMapping("/publico/authenticate")
  public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) {
    logger.info("Autenticando al usuario {}", authenticationReq.getUsuario());

    PasswordEncoder pe = new BCryptPasswordEncoder();

    Optional<Usuario> usuario = usuarioService.findByUsuario(authenticationReq.getUsuario());
    if (usuario != null) {
      logger.info("1. usuario: {}{}" ,  usuario.get().getUsuario(),  usuario.get().getClave());
      logger.info("1.1 authenticationReq: {}{}" ,  authenticationReq.getUsuario(), new BCryptPasswordEncoder().encode(authenticationReq.getClave()));
    } else {
      logger.info("1. usuario: {}{}" ,  "es nulo",  "es nulo");
    }

    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationReq.getUsuario(),
            authenticationReq.getClave()));



    final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
        authenticationReq.getUsuario());
    logger.info("2. userDetails  {}{}" ,  authenticationReq.getUsuario(),  authenticationReq.getClave());


    final String jwt = jwtUtilService.generateToken(userDetails);
    logger.info("3. Jwt  {}{}" ,  authenticationReq.getUsuario(),  authenticationReq.getClave());

    TokenInfo tokenInfo = new TokenInfo(jwt);
    logger.info("4. tokeInfo  {}{}" ,  authenticationReq.getUsuario(),  authenticationReq.getClave());


    return ResponseEntity.ok(tokenInfo);
  }
}
