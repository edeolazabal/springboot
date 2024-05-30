package com.upc.demosec.service;

import com.upc.demosec.model.User;
import com.upc.demosec.repository.UserRepository;
import com.upc.demosec.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario: " + username+ " no existe"));

        return new UserDetailsImpl(user);
    }
}
