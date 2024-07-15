package rh.humanos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.humanos.modelos.Empleados;



public interface EmpleadoRepository  extends JpaRepository<Empleados, Integer>{
    
}
