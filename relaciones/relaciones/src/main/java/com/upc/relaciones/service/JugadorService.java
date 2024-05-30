package com.upc.relaciones.service;

import com.upc.relaciones.dto.CuentaJugadorDto;
import com.upc.relaciones.dto.JugadorDto;
import com.upc.relaciones.models.Equipo;
import com.upc.relaciones.models.Jugador;
import com.upc.relaciones.repository.EquipoRepository;
import com.upc.relaciones.repository.JugadorRepository;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public String obtieneNombre(Integer id) {
        return jugadorRepository.obtieneNombre(id);
    }


    public Jugador cuentaJugador (Integer id) {
        return jugadorRepository.cuentaJugadores(id);
    }
    public CuentaJugadorDto cuentaJugador2 (Integer id) {
        Tuple t = jugadorRepository.cuentaJugadores2(id);
        CuentaJugadorDto cuenta = new CuentaJugadorDto(
                t.get("denominacion", String.class),
                t.get("cantidad", Long.class));

        return cuenta;
    }


}
