package com.upc.datajpa20241.controller;

import com.upc.datajpa20241.dto.CursoDto;
import com.upc.datajpa20241.model.Curso;
import com.upc.datajpa20241.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoDto>> GetAll () {
        return new ResponseEntity<>(cursoService.GetAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> GetById (@PathVariable("id") Integer id) {
        CursoDto cursoDto = cursoService.GetById(id);
        if(cursoDto == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cursoDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Curso> Add (@RequestBody CursoDto cursoDto) {
        return new ResponseEntity<>(cursoService.Add(cursoDto), HttpStatus.CREATED);
    }
}
