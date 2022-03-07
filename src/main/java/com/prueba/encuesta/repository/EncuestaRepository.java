package com.prueba.encuesta.repository;

import com.prueba.encuesta.entities.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {

}
