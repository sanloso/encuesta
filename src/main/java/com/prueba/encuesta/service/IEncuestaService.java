package com.prueba.encuesta.service;

import com.prueba.encuesta.entities.Pregunta;
import java.util.List;
import java.util.Optional;

public interface IEncuestaService {
    public Optional<List<Pregunta>> ListarEncuesta (long id);
    public boolean crearEncuesta ();
}
