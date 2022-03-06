package com.prueba.encuesta.service.impl;

import com.prueba.encuesta.entities.Pregunta;
import com.prueba.encuesta.service.IEncuestaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EncuestaService implements IEncuestaService {
    @Override
    public Optional<Pregunta> ListarEncuesta(long id) {
        return Optional.empty();
    }

    @Override
    public boolean crearEncuesta() {
        return false;
    }
}
