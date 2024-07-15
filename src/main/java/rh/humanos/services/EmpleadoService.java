
package rh.humanos.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rh.humanos.modelos.Empleados;
import rh.humanos.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService{

     @Autowired EmpleadoRepository empleadoRptory;
    
    @Override
    public List<Empleados> GetAllEmploys() {

         return empleadoRptory.findAll();
    }

    @Override
    public Empleados GetByID(Integer idEmpleado) {
       
      Empleados empleado = empleadoRptory.findById(idEmpleado).orElse(null);
      return  empleado;
    }

    @Override
    public Empleados saveEmploy(Empleados empleado) {
        return empleadoRptory.save(empleado);
    }

    @Override
    public void DeleteEmploys(Empleados empleado) {
       
        empleadoRptory.delete(empleado);
    }
    
}
