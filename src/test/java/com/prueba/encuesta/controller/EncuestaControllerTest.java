package com.prueba.encuesta.controller;

import com.prueba.encuesta.controller.dto.PreguntaDto;
import com.prueba.encuesta.entities.Pregunta;
import com.prueba.encuesta.service.exception.NoPreguntaException;
import com.prueba.encuesta.service.impl.EncuestaService;
import com.prueba.encuesta.service.impl.PreguntaService;
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

class EncuestaControllerTest {
    @Mock
    EncuestaService encuestaService;
    @Mock
    PreguntaService preguntaService;
    @InjectMocks
    EncuestaController encuestaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCrearEncuesta() {
        when(encuestaService.crearEncuesta("nombre")).thenReturn(true);
        when(preguntaService.crearPregunta(any())).thenReturn(true);

        boolean result = encuestaController.crearEncuesta(new PreguntaDto("nombre", Arrays.<Pregunta>asList(new Pregunta(0L, 0, "pregunta", "nombreEncuesta", 0L))));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testListarEncuesta() throws NoPreguntaException {
        Pregunta pregunta = new Pregunta(0L, 0, "pregunta", "nombreEncuesta", 0L);
        List<Pregunta> result = new ArrayList<>();
        result.add(pregunta);
        when(encuestaService.ListarEncuesta("nombreEncuesta")).thenReturn(Optional.of(result));

        List<Pregunta> result1 = encuestaController.listarEncuesta("nombreEncuesta");
        Assertions.assertEquals(Arrays.<Pregunta>asList(new Pregunta(0L, 0, "pregunta", "nombreEncuesta", 0L)), result1);
    }

    @Test
    void testHealt() {
        String result = encuestaController.healt();
        Assertions.assertEquals("ok", result);
    }
}