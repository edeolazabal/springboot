package domesticpro.com.domesticpro.services;

import domesticpro.com.domesticpro.entities.Empleado;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IEmpleadoService {
    public void insert(Empleado empleado);

    List<Empleado> list();

    Empleado listId(Integer id) throws ChangeSetPersister.NotFoundException;
}
