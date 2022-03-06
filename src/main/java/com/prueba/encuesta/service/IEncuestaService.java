package com.prueba.encuesta.service;

import com.prueba.encuesta.entities.Pregunta;
import java.util.Optional;

public interface IEncuestaService {
    public Optional<Pregunta> ListarEncuesta (long id);
    public boolean crearEncuesta ();
}
