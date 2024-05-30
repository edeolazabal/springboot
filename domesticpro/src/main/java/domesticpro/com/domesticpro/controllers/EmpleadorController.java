package domesticpro.com.domesticpro.controllers;


import domesticpro.com.domesticpro.dtos.EmpleadorDTO;
import domesticpro.com.domesticpro.entities.Empleador;
import domesticpro.com.domesticpro.services.IEmpleadorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/empleadores")

public class EmpleadorController {
    @Autowired
    private IEmpleadorService eS;

    @PostMapping
    public void insert(@RequestBody EmpleadorDTO dto){
        ModelMapper m= new ModelMapper();
        Empleador a = m.map(dto, Empleador.class);
        eS.insert(a);
    }

    @GetMapping
    public List<EmpleadorDTO> list(){
        return eS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,EmpleadorDTO.class);
        }).collect(Collectors.toList());
    }


}
