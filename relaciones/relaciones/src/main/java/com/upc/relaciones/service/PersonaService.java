package com.upc.relaciones.service;

import com.upc.relaciones.dto.PersonaDto;
import com.upc.relaciones.models.Persona;
import com.upc.relaciones.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<PersonaDto> GetAll () {
        List<Persona> lista = personaRepository.findAll();
        List<PersonaDto> listaDto = new ArrayList<>();
        PersonaDto item;
        for (Persona cur : lista) {
            item = new PersonaDto(cur.getId(), cur.getNombre());
            listaDto.add(item);
        }
        return listaDto;
    }
    public PersonaDto GetById (int id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        if (persona == null) return null;
        PersonaDto personaDto = new PersonaDto(persona.getId(), persona.getNombre());
        return personaDto;
    }
    public Persona Add (PersonaDto personaDto) {
        Persona persona = new Persona(personaDto.getNombre());
        return personaRepository.save(persona);
    }
}
