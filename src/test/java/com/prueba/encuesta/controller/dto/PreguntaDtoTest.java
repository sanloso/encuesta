package com.prueba.encuesta.controller.dto;

import com.prueba.encuesta.entities.Pregunta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class PreguntaDtoTest {
    @Mock
    List<Pregunta> preguntas;
    @InjectMocks
    PreguntaDto preguntaDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSetNombre() {
        preguntaDto.setNombre("nombre");
    }

    @Test
    void testSetPreguntas() {
        preguntaDto.setPreguntas(Arrays.<Pregunta>asList(new Pregunta(0L, 0, "pregunta", "nombreEncuesta", 0L)));
    }

    @Test
    void testEquals() {
        boolean result = preguntaDto.equals("o");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testCanEqual() {
        boolean result = preguntaDto.canEqual("other");
        Assertions.assertEquals(false, result);
    }

    @Test
    void testToString() {
        String result = preguntaDto.toString();
        Assertions.assertEquals("PreguntaDto(nombre=null, preguntas=preguntas)", result);
    }
}
