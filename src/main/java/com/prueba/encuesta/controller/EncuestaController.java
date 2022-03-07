package com.prueba.encuesta.controller;

import com.prueba.encuesta.entities.Encuesta;
import com.prueba.encuesta.entities.Pregunta;
import com.prueba.encuesta.service.impl.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class EncuestaController {
    @Autowired
    private EncuestaService encuestaService;

    /**
     * Crea una nueva encuesta
     * @param
     * @return booleano indicando si se ha creado con exito o no
     */
    @PostMapping("/crear-encuesta")
    public boolean crearEncuesta(){
        boolean saved = encuestaService.crearEncuesta();
        return saved;
    }

    /**
     * Encuentra las preguntas relacionadas a la encuesta
     * @param newEncuesta para poder encontrar el listado de preguntas correspondientes
     * @return List<Pregunta> con el listado de preguntas correspondientes a la encuesta
     */
    @GetMapping("/listar-encuesta")
    public List<Pregunta> listarEncuesta(@RequestBody Encuesta newEncuesta){
        try{
            Optional<List<Pregunta>> entity = encuestaService.ListarEncuesta(newEncuesta.getId());

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
