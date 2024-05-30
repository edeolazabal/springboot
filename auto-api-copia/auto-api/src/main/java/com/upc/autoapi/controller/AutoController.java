package com.upc.autoapi.controller;

import com.upc.autoapi.dto.AutoDto;
import com.upc.autoapi.model.Auto;
import com.upc.autoapi.service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin
@RestController
@RequestMapping("/api/auto")
public class AutoController {
    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<Auto>> GetAll () {
        return new ResponseEntity<>(autoService.GetAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public ResponseEntity<Auto> GetById (@PathVariable("id") Integer id) {
        Auto auto = autoService.GetById(id);
        if(auto == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(auto, HttpStatus.OK);
    }
    @Transactional
    @PostMapping
    public ResponseEntity<Auto> Add (@RequestBody AutoDto autoDto) {
        return new ResponseEntity<>(autoService.Add(autoDto), HttpStatus.CREATED);
    }
}
