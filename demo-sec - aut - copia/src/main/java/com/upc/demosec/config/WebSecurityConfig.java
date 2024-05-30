package com.upc.demosec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
//     @Bean
//    public UserDetailsService userDetailsService() {
//         var user = User.withUsername("upc")
//                 .password("password")
//                 .roles("read")
//                 .build();
//
//         return new InMemoryUserDetailsManager(user);
//     }
     @Bean
     public     PasswordEncoder passwordEncoder() {
         //return NoOpPasswordEncoder.getInstance(); // No apto para producción
         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
     }
     // para encriptar
     public static  void main (String[] args) {
         System.out.println("Pass: " + new BCryptPasswordEncoder().encode("claveUpc"));
     }
}
