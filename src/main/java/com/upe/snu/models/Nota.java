package com.upe.snu.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
public class Nota {

	public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    private Long id;

    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    private double nota;

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    private String comentario;

    public Matricula getMatricula() {
        return matricula;
    }
    public void setMatricula(Matricula matricula) { this.matricula = matricula; }
    private Matricula matricula;
}
