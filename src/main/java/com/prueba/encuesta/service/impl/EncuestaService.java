package com.prueba.encuesta.service.impl;

import com.prueba.encuesta.controller.dto.PreguntaDto;
import com.prueba.encuesta.entities.Encuesta;
import com.prueba.encuesta.entities.Pregunta;
import com.prueba.encuesta.repository.EncuestaRepository;
import com.prueba.encuesta.repository.PreguntaRepository;
import com.prueba.encuesta.service.IEncuestaService;
import com.prueba.encuesta.service.exception.NoPreguntaException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EncuestaService implements IEncuestaService {

    private final EncuestaRepository encuestaRepository;
    private final PreguntaRepository preguntaRepository;

    @Override
    public Optional<List<Pregunta>> ListarEncuesta(String nombreEncuesta) throws NoPreguntaException {
        Optional<List<Pregunta>> optionalPreguntas = preguntaRepository.findPreguntaBynombreEncuesta(nombreEncuesta);
        if(optionalPreguntas.isPresent()){
            return optionalPreguntas;
        }else{
            throw new NoPreguntaException();
        }

    }

    @Override
    public boolean crearEncuesta(String nombre) {
        boolean saved = false;
        Encuesta encuesta = new Encuesta(nombre);
        try{
            encuestaRepository.save(encuesta);
            saved = true;
        }catch (IllegalArgumentException e){
            return saved;
        }
        return saved;
    }
}
