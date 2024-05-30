package com.upc.datajpa20241.service;

import com.upc.datajpa20241.dto.CursoDto;
import com.upc.datajpa20241.model.Curso;
import com.upc.datajpa20241.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {
    final CursoRepository cursoRepository;
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    public List<CursoDto> GetAll () {
        List<Curso> lista = cursoRepository.findAll();
        List<CursoDto> listaDto = new ArrayList<>();
        CursoDto item;
        for (Curso cur: lista) {
            item = new CursoDto(cur.getId(), cur.getNombre());
            listaDto.add(item);
        }
        return listaDto;
    }
    public CursoDto GetById (int id) {
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso == null) return null;
        CursoDto cursoDto = new CursoDto(curso.getId(), curso.getNombre());
        return cursoDto;
    }
    public Curso Add (CursoDto cursoDto) {
        Curso curso = new Curso(cursoDto.getNombre());
        return cursoRepository.save(curso);
    }

}
