package domesticpro.com.domesticpro.services;

import domesticpro.com.domesticpro.entities.Empleador;

import java.util.List;

public interface IEmpleadorService {

    public void insert(Empleador empleador);

    List<Empleador> list();

}
