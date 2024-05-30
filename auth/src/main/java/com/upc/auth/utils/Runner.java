package com.upc.auth.utils;

import com.upc.auth.model.Authority;
import com.upc.auth.model.User;
import com.upc.auth.repository.AuthorityRepository;
import com.upc.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    final UserRepository userRepository;
    final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority((AuthorityName.WRITE))
            ));
        }
        if (this.userRepository.count() == 0) {
            this.userRepository.saveAll(List.of(
                    new User("upc", new BCryptPasswordEncoder().encode("upc"), List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("upc01", new BCryptPasswordEncoder().encode("upc01123"), List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("upc02", new BCryptPasswordEncoder().encode("upc02123"), List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get()))
            ));
        }
    }
}
