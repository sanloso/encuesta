package com.prueba.encuesta.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.prueba.encuesta.entities.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Validated
public class PreguntaDto {

    @NotNull
    private String nombre;

    @NotNull
    private List<Pregunta> preguntas;

}
