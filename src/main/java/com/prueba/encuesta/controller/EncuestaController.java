package com.prueba.encuesta.controller;

import com.prueba.encuesta.controller.dto.PreguntaDto;
import com.prueba.encuesta.entities.Encuesta;
import com.prueba.encuesta.entities.Pregunta;
import com.prueba.encuesta.service.exception.NoPreguntaException;
import com.prueba.encuesta.service.impl.EncuestaService;
import com.prueba.encuesta.service.impl.PreguntaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@CrossOrigin(origins = "*")
public class EncuestaController {

    private final EncuestaService encuestaService;
    private final PreguntaService preguntaService;

    public EncuestaController(EncuestaService encuestaService, PreguntaService preguntaService) {
        this.encuestaService = encuestaService;
        this.preguntaService = preguntaService;
    }

    /**
     * Crea una nueva encuesta
     * @param preguntaDto con preguntas relacionadas a la encuesta
     * @return booleano indicando si se ha creado con exito o no
     */
    @PostMapping("/crear-encuesta")
    public boolean crearEncuesta(@Valid @RequestBody PreguntaDto preguntaDto){
        boolean saved = encuestaService.crearEncuesta(preguntaDto.getNombre());
        preguntaService.crearPregunta(preguntaDto);
        return saved;
    }

    /**
     * Encuentra las preguntas relacionadas a la encuesta
     * @param nombreEncuesta para poder encontrar el listado de preguntas correspondientes
     * @return List<Pregunta> con el listado de preguntas correspondientes a la encuesta
     */
    @GetMapping("/listar-encuesta")
    public List<Pregunta> listarEncuesta(@RequestParam String nombreEncuesta) throws NoPreguntaException {
        try{
            Optional<List<Pregunta>> entity = encuestaService.ListarEncuesta(nombreEncuesta);
            List<Pregunta> preguntaList = new ArrayList<Pregunta>();
            entity.get().forEach(t -> preguntaList.add(t));
            return preguntaList;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Verificar el estado del controlador
     * @return String para verificar respuesta por parte del servidor
     */
    @GetMapping("/healt")
    public String healt (){
        return "ok";
    }
}
