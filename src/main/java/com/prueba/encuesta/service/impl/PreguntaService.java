package com.prueba.encuesta.service.impl;

import com.prueba.encuesta.controller.dto.PreguntaDto;
import com.prueba.encuesta.repository.PreguntaRepository;
import com.prueba.encuesta.service.IPreguntaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PreguntaService implements IPreguntaService {

    private final PreguntaRepository preguntaRepository;

    /**
     *
     * @param preguntaDto pregunta a crear
     * @return saved indicando si la creacion de la pregunta fue exitosa o no
     */
    @Override
    public boolean crearPregunta(PreguntaDto preguntaDto) {
        boolean saved = false;
        try{
            preguntaDto.getPreguntas().stream().forEach(t -> {t.setNombreEncuesta(preguntaDto.getNombre());preguntaRepository.save(t);});
            saved = true;
        }catch (IllegalArgumentException e){
            return saved;
        }
        return saved;
    }
}
