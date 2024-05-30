package upc.rutas.demo.service;

import org.springframework.stereotype.Service;
import upc.rutas.demo.model.Rutas;
import upc.rutas.demo.model.RutasDto;
import upc.rutas.demo.repository.RutasRepository;

import java.util.List;

@Service
public class RutasService {
    final RutasRepository rutasRepository;

    public RutasService(RutasRepository rutasRepository) {
        this.rutasRepository = rutasRepository;
    }
    public List<Rutas> getAll() {
        return rutasRepository.findAll();
    }
    public Rutas add (RutasDto rutasDto) {
        Rutas ruta = new Rutas(
                0L,
                rutasDto.getNombre(),
                rutasDto.getTipo(),
                rutasDto.getFechaCreacion(),
                rutasDto.getExtension());
        return rutasRepository.save(ruta);
    }
}
