package com.upc.demosec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
// @EnableWebSecurity
public class WebSecurityConfig {

     @Bean
     public     PasswordEncoder passwordEncoder() {
         //return NoOpPasswordEncoder.getInstance(); // No apto para producción
         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
     }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .httpBasic(withDefaults())
                .csrf().disable();
     //           .authorizeHttpRequests((authz) -> authz
     //                   .anyRequest().permitAll()
     //                   .anyRequest().authenticated()
     //                   .anyRequest().authenticated()
     //                           .anyRequest().
        return http.build();
   }
//     para encriptar
//     public static  void main (String[] args) {
//         System.out.println("Pass: " + new BCryptPasswordEncoder().encode("claveUpc"));
//     }
}
