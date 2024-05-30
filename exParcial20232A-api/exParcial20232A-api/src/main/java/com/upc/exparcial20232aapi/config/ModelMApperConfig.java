package com.upc.exparcial20232aapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMApperConfig {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

