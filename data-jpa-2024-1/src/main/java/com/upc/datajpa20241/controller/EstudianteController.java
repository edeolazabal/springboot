package com.upc.datajpa20241.controller;

import com.upc.datajpa20241.dto.EstudianteCursoDto;
import com.upc.datajpa20241.dto.EstudianteDto;
import com.upc.datajpa20241.model.Estudiante;
import com.upc.datajpa20241.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
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
