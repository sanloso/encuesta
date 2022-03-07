package com.prueba.encuesta.service.impl;

import com.prueba.encuesta.entities.Pregunta;
import com.prueba.encuesta.repository.EncuestaRepository;
import com.prueba.encuesta.repository.PreguntaRepository;
import com.prueba.encuesta.service.exception.NoPreguntaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class EncuestaServiceTest {
    @Mock
    EncuestaRepository encuestaRepository;
    @Mock
    PreguntaRepository preguntaRepository;
    @InjectMocks
    EncuestaService encuestaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testListarEncuesta() throws NoPreguntaException {
        Pregunta pregunta = new Pregunta(0L, 0, "pregunta", "nombreEncuesta", 0L);
        List<Pregunta> result = new ArrayList<>();
        result.add(pregunta);
        when(preguntaRepository.findPreguntaBynombreEncuesta("nombreEncuesta")).thenReturn(Optional.of(result));

        Optional<List<Pregunta>> result1 = encuestaService.ListarEncuesta("nombreEncuesta");
        Assertions.assertEquals(Optional.of(Arrays.<Pregunta>asList(new Pregunta(0L, 0, "pregunta", "nombreEncuesta", 0L))), result1);
    }

    @Test
    void testCrearEncuesta() {
        boolean result = encuestaService.crearEncuesta("nombre");
        Assertions.assertEquals(true, result);
    }
}