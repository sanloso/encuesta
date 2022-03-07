package com.prueba.encuesta.service.exception;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;

public class NoPreguntaException extends Exception{
    public NoPreguntaException(){
        super ( "No se ha encontrado ninguna pregunta");
    }
}
