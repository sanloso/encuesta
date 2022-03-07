package com.prueba.encuesta.repository;

import com.prueba.encuesta.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    Optional<List<Pregunta>> findPreguntaBynombreEncuesta(String nombreEncuesta);
}
