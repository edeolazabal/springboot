package com.upc.demosec.service;

import com.upc.demosec.repository.UserRepository;
import com.upc.demosec.security.SecurityUser;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = this.userRepository.findByUsername(username);

        if (optUser.isPresent()) {
            // Crear objeto con los datos de la sesion
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            HttpSession session = attributes.getRequest().getSession(true);

            session.setAttribute("ciudadSession", optUser.get());

            //----------------------------------------
            return new SecurityUser(optUser.get());
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }

}
