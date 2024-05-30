package domesticpro.com.domesticpro.controllers;
import domesticpro.com.domesticpro.dtos.EmpleadoDTO;
import domesticpro.com.domesticpro.entities.Empleado;
import domesticpro.com.domesticpro.services.IEmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService eS;

    @PostMapping
    public void insert(@RequestBody EmpleadoDTO dto){
        ModelMapper m= new ModelMapper();
        Empleado a = m.map(dto, Empleado.class);
        eS.insert(a);
    }

    @GetMapping
    public List<EmpleadoDTO> list(){
        return eS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,EmpleadoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Empleado listId(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return eS.listId(id);
    }
}
