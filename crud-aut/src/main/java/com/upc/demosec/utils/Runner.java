package com.upc.demosec.utils;

import com.upc.demosec.model.Authority;
import com.upc.demosec.model.User;
import com.upc.demosec.repository.AuthorityRepository;
import com.upc.demosec.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
   //     System.out.println("Hola Mundo!");
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
         }
        if (this.userRepository.count() == 0) {
            var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            this.userRepository.saveAll(List.of(
                    new User("upc", encoders.encode("upc123"), 1, List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("user01",encoders.encode("user01123"), 0, List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                    new User("user02", encoders.encode("user02123"), 1, List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get()))
            ));
        }
    }
}
