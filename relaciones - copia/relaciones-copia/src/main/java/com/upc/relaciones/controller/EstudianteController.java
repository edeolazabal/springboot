package com.upc.relaciones.controller;

import com.upc.relaciones.dto.CursoDto;
import com.upc.relaciones.dto.EstudianteCursoDto;
import com.upc.relaciones.dto.EstudianteDto;
import com.upc.relaciones.models.Curso;
import com.upc.relaciones.models.Estudiante;
import com.upc.relaciones.repository.CursoRepository;
import com.upc.relaciones.services.CursoService;
import com.upc.relaciones.services.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/estudiante")
public class EstudianteController {
    final EstudianteService estudianteService;

    final CursoService cursoService;

    public EstudianteController(EstudianteService estudianteService,  CursoService cursoService) {
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDto>> GetAll () {
        return new ResponseEntity<>(estudianteService.GetAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> GetById (@PathVariable("id") Integer id) {
        EstudianteDto estudianteDto = estudianteService.GetById(id);
        if(estudianteDto == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(estudianteDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Estudiante> Add (@RequestBody EstudianteDto estudianteDto) {
        return new ResponseEntity<>(estudianteService.Add(estudianteDto), HttpStatus.CREATED);
    }

    @PostMapping("/estudianteCurso")
    public ResponseEntity<EstudianteCursoDto> AddEstudianteCurso(
            @RequestBody EstudianteCursoDto estudianteCurso)
    {
            EstudianteCursoDto estudianteCursoDto = estudianteService.AddEstudianteCurso(estudianteCurso);
            if(estudianteCursoDto == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(estudianteCursoDto, HttpStatus.CREATED);
    }
}
