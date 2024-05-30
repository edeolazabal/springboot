package domesticpro.com.domesticpro.servicesimplements;

import domesticpro.com.domesticpro.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import domesticpro.com.domesticpro.entities.Empleado;
import domesticpro.com.domesticpro.repositories.IEmpleadoRepositories;


import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceImplement implements IEmpleadoService {
    @Autowired
    private IEmpleadoRepositories eR;
    @Override
    public void insert(Empleado empleado) {
        eR.save(empleado);
    }
    @Override
    public List<Empleado> list() {
        return eR.findAll();
    }
    @Override
    public Empleado listId(Integer id) throws ChangeSetPersister.NotFoundException {
        return eR.findById(id)
                .orElseThrow(()-> new ChangeSetPersister.NotFoundException());
    }
}
