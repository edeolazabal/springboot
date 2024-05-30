package com.upc.demosec.service;

import com.upc.demosec.repository.UserRepository;
import com.upc.demosec.security.SecurityUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    //private final SecurityUser securityUser;

    public SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = this.userRepository.findByUsername(username);

        if (optUser.isPresent()) {
            // Define datos de usuario en una HttpSession
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

            HttpSession session = attr.getRequest().getSession(true);

            session.setAttribute("typeSession", optUser.get());
            //-----------
            return new SecurityUser(optUser.get());
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }

}
