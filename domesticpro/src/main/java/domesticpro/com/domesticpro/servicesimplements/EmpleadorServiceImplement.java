package domesticpro.com.domesticpro.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import domesticpro.com.domesticpro.entities.Empleador;
import domesticpro.com.domesticpro.repositories.IEmpleadorRepositories;
import domesticpro.com.domesticpro.services.IEmpleadorService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadorServiceImplement implements IEmpleadorService{
    @Autowired
    private IEmpleadorRepositories eR;
    @Override
    public void insert(Empleador empleador) {
        eR.save(empleador);
    }
    @Override
    public List<Empleador> list() {
        return eR.findAll();
    }

}
