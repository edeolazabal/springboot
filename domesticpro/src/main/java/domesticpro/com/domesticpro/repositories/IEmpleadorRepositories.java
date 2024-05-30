package domesticpro.com.domesticpro.repositories;

import domesticpro.com.domesticpro.entities.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadorRepositories extends JpaRepository<Empleador,Integer>{

}
