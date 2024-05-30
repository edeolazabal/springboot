package com.upc.relaciones.services;

import com.upc.relaciones.dto.CursoDto;
import com.upc.relaciones.dto.EquipoDto;
import com.upc.relaciones.models.Curso;
import com.upc.relaciones.models.Equipo;
import com.upc.relaciones.models.Estudiante;
import com.upc.relaciones.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoService {
    final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }
    public List<EquipoDto> GetAll() {
        List<Equipo> lista = equipoRepository.findAll();
        List<EquipoDto> listaDto = new ArrayList<>();
        EquipoDto item;
        for (Equipo equ: lista) {
            item = new EquipoDto(equ.getId(), equ.getDenominacion());
            listaDto.add(item);
        }
        return listaDto;
    }
    public EquipoDto GetById(Integer id) {
        Equipo equipo = equipoRepository.findById(id).orElse(null);
        if (equipo == null) return null;
        EquipoDto equipoDto = new EquipoDto(equipo.getId(), equipo.getDenominacion());
        return equipoDto;
    }
    public Equipo Add (EquipoDto equipoDto) {
        Equipo equipo = new Equipo(equipoDto.getDenominacion());
        return equipoRepository.save(equipo);
    }
}
