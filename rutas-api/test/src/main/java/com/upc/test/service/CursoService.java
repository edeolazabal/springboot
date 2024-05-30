package com.upc.test.service;

import com.upc.test.model.Curso;
import com.upc.test.model.CursoDto;
import com.upc.test.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    public Curso crear (CursoDto cursoDto) {
        Curso c = new Curso();
        c.setNombre(cursoDto.getNombre());
        c.setCreditos(cursoDto.getCreditos());
        return cursoRepository.save(c);
    }
    public List<Curso> listar () {
        return cursoRepository.findAll();
    }
}
