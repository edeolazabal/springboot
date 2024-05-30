package com.upc.datajpa20241.service;

import com.upc.datajpa20241.model.Persona;
import com.upc.datajpa20241.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    public Optional<Persona> getPersona(Integer id) {
        Optional<Persona> pers = personaRepository.findById(id);
        return pers;
    }
    public List<Persona> getTodas () {
        return personaRepository.findAll();
    }
    public Persona agrega (Persona p) {
        return personaRepository.save(p);
    }
}
