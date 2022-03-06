package com.prueba.encuesta.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column (name = "tipoPregunta")
    private int tipoPregunta;

    @Column (name = "pregunta")
    private String pregunta;

    @Column (name = "idEncuesta")
    private long idEncuesta;

    @Column (name = "respuestaCorrecta")
    private long respuestaCorrecta;

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", tipoPregunta=" + tipoPregunta +
                ", pregunta='" + pregunta + '\'' +
                ", idEncuesta=" + idEncuesta +
                ", respuestaCorrecta=" + respuestaCorrecta +
                '}';
    }
}
