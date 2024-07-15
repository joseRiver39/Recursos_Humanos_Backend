package rh.humanos.services;

import java.util.List;
import rh.humanos.modelos.Empleados;


public interface IEmpleadoService {
    
    public List <Empleados> GetAllEmploys();
    
    public Empleados GetByID(Integer idEmpleado);
    
    public Empleados saveEmploy( Empleados empleado);
    
    public void DeleteEmploys(Empleados empleado);
}
