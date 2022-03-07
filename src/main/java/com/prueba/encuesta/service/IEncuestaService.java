package com.prueba.encuesta.service;

import com.prueba.encuesta.controller.dto.PreguntaDto;
import com.prueba.encuesta.entities.Pregunta;
import com.prueba.encuesta.service.exception.NoPreguntaException;

import java.util.List;
import java.util.Optional;

public interface IEncuestaService {
    public Optional<List<Pregunta>> ListarEncuesta (String nombreEncuesta) throws NoPreguntaException;
    public boolean crearEncuesta (String nombreEncuesta);
}
