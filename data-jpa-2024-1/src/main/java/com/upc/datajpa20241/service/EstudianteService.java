package com.upc.datajpa20241.service;

import com.upc.datajpa20241.dto.EstudianteCursoDto;
import com.upc.datajpa20241.dto.EstudianteDto;
import com.upc.datajpa20241.model.Curso;
import com.upc.datajpa20241.model.Estudiante;
import com.upc.datajpa20241.repository.CursoRepository;
import com.upc.datajpa20241.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {
    final EstudianteRepository estudianteRepository;

    final CursoRepository cursoRepository;

    public EstudianteService(EstudianteRepository estudianteRepository, CursoRepository cursoRepository) {
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<EstudianteDto> GetAll () {
        List<Estudiante> lista = estudianteRepository.findAll();
        List<EstudianteDto> listaDto = new ArrayList<>();
        EstudianteDto item;
        for (Estudiante est: lista) {
            item = new EstudianteDto(est.getId(), est.getNombre());
            listaDto.add(item);
        }
        return listaDto;
    }
    public EstudianteDto GetById (int id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        if (estudiante == null) return null;
        EstudianteDto estudianteDto = new EstudianteDto(estudiante.getId(), estudiante.getNombre());
        return estudianteDto;
    }
    public Estudiante Add (EstudianteDto estudianteDto) {
        Estudiante estudiante = new Estudiante(estudianteDto.getNombre());
        return estudianteRepository.save(estudiante);
    }
    public EstudianteCursoDto AddEstudianteCurso (EstudianteCursoDto estudianteCursoDto)
    {
        Estudiante estudiante = estudianteRepository.findById(estudianteCursoDto.getEstudianteId()).orElse(null);
        Curso curso = cursoRepository.findById(estudianteCursoDto.getCursoId()).orElse(null);

        if (estudiante != null && curso != null) {
            estudiante.getCursos().add(curso);
            curso.getEstudiantes().add(estudiante);
            estudianteRepository.save(estudiante);
            cursoRepository.save(curso);
            return estudianteCursoDto;
        } else
        {
            return null;
        }
    }
}
