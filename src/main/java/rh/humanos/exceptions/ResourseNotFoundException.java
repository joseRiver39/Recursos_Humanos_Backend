/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rh.humanos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author ANTONIO
 */
@ResponseStatus(value =  HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends  RuntimeException{

    public ResourseNotFoundException(String Mensaje) {
        super(Mensaje);
    }
    
}
