package com.upc.relaciones.services;

import com.upc.relaciones.dto.EquipoDto;
import com.upc.relaciones.dto.JugadorDto;
import com.upc.relaciones.models.Equipo;
import com.upc.relaciones.models.Jugador;
import com.upc.relaciones.repository.EquipoRepository;
import com.upc.relaciones.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    final JugadorRepository jugadorRepository;
    final EquipoRepository equipoRepository;

    public JugadorService(JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }
    public List<JugadorDto> GetAll() {
        List<Jugador> lista = jugadorRepository.findAll();
        List<JugadorDto> listaDto = new ArrayList<>();
        JugadorDto item;
        for (Jugador jug: lista) {
            item = new JugadorDto(jug.getId(), jug.getNombre(), jug.getEquipo().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
    public JugadorDto GetById(Integer id) {
        Jugador jugador = jugadorRepository.findById(id).orElse(null);
        if (jugador == null) return null;

        JugadorDto jugadorDto = new JugadorDto(jugador.getId(), jugador.getNombre(), jugador.getEquipo().getId());
        return jugadorDto;
    }
    public Jugador Add (JugadorDto jugadorDto) {
        Equipo equipo =  equipoRepository.findById(jugadorDto.getEquipoId()).orElse(null);
        if (equipo == null) return null;
        Jugador jugador = new Jugador(jugadorDto.getNombre(), equipo);

        return jugadorRepository.save(jugador);

    }
}
