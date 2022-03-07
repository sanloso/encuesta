package com.prueba.encuesta.service.impl;

import com.prueba.encuesta.controller.dto.PreguntaDto;
import com.prueba.encuesta.entities.Pregunta;
import com.prueba.encuesta.repository.PreguntaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class PreguntaServiceTest {
    @Mock
    PreguntaRepository preguntaRepository;
    @InjectMocks
    PreguntaService preguntaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCrearPregunta() {
        boolean result = preguntaService.crearPregunta(new PreguntaDto("nombre", Arrays.<Pregunta>asList(new Pregunta(0L, 0, "pregunta", "nombreEncuesta", 0L))));
        Assertions.assertEquals(true, result);
    }
}