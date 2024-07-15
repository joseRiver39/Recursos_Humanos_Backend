package rh.humanos.Controller;

import rh.humanos.exceptions.ResourseNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rh.humanos.modelos.Empleados;
import rh.humanos.services.IEmpleadoService;

@RestController
@RequestMapping("rh-app")
public class EmployController {

    private static final Logger logger
            = LoggerFactory.getLogger(EmployController.class);

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/empleados")

    public List<Empleados> GetEmploys() {
        var empleados = empleadoService.GetAllEmploys();
        empleados.forEach(empleado -> logger.info(empleado.toString()));

        return empleados;
    }

    @GetMapping("/empleados/{id}")

    public ResponseEntity<Empleados> GetEmployById(@PathVariable Integer id) {

        Empleados empleado = empleadoService.GetByID(id);
        if (empleado == null) {
            throw new ResourseNotFoundException("no se encontro el  id = " + id);
        }

        return ResponseEntity.ok(empleado);

    }

    @PostMapping("/empleados")

    public Empleados AddEmploy(@RequestBody Empleados empleado) {
        return empleadoService.saveEmploy(empleado);
    }
    
    @PutMapping("/empleados/{id}")

    public ResponseEntity<Empleados> AddEmploy (@PathVariable Integer id,
                                                @RequestBody Empleados empleadoRecibido) {
        Empleados empleado = empleadoService.GetByID(id); if(empleado == null)
        if(empleado == null)
           throw new ResourseNotFoundException(" el  id recibido no existe: " + id);
        
        empleado.setNombre(empleadoRecibido.getNombre());
        empleado.setDepartamento(empleadoRecibido.getDepartamento());
        empleado.setSueldo(empleadoRecibido.getSueldo());
        
        empleadoService.saveEmploy(empleado);
        return ResponseEntity.ok(empleado);
    }
    
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmploy(@PathVariable Integer id){
        Empleados empleado = empleadoService.GetByID(id); 
        if(empleado == null)
           throw new ResourseNotFoundException(" el  id recibido no existe: " + id);
        empleadoService.DeleteEmploys(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", true);                
        return ResponseEntity.ok(respuesta);

}
}
