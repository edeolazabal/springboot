package upc.rutas.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.rutas.demo.model.Rutas;
import upc.rutas.demo.model.RutasDto;
import upc.rutas.demo.service.RutasService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/rutas")
public class RutasController {
    final RutasService rutasService;

    public RutasController(RutasService rutasService) {
        this.rutasService = rutasService;
    }
    @GetMapping
    public ResponseEntity<List<Rutas>> getAll() {
        return new ResponseEntity<>(rutasService.getAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Rutas> add (@RequestBody RutasDto rutasDto) {
        return new ResponseEntity<>(rutasService.add(rutasDto), HttpStatus.CREATED);
    }
}
