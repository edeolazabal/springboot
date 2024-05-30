package com.upc.relaciones.services;
import com.upc.relaciones.dto.DniDto;
import com.upc.relaciones.models.Dni;
import com.upc.relaciones.models.Jugador;
import com.upc.relaciones.models.Persona;
import com.upc.relaciones.repository.DniRepository;
import com.upc.relaciones.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DniService {
    final DniRepository dniRepository;
    final PersonaRepository personaRepository;

    public DniService(DniRepository dniRepository, PersonaRepository personaRepository) {
        this.dniRepository = dniRepository;
        this.personaRepository = personaRepository;
    }
    public List<DniDto> GetAll() {
        List<Dni> lista = dniRepository.findAll();
        List<DniDto> listaDto = new ArrayList<>();
        DniDto item;
        for (Dni dni: lista) {
            item = new DniDto(dni.getId(), dni.getNombre(), dni.getPersona().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
    public DniDto GetById(Integer id) {
        Dni dni = dniRepository.findById(id).orElse(null);
        if (dni == null) return null;

        DniDto dniDto = new DniDto(dni.getId(), dni.getNombre(), dni.getPersona().getId());
        return dniDto;
    }
    public Dni Add (DniDto dniDto) {
        Persona persona =  personaRepository.findById(dniDto.getPersonaId()).orElse(null);
        if (persona == null) return null;
        Dni dni = new Dni(dniDto.getNombre(), persona);

        return dniRepository.save(dni);

    }
}
