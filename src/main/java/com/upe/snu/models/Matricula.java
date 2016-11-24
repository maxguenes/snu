package com.upe.snu.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
public class Matricula {

	public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    private Long id;


    public List<Nota> getNotas() {
        return notas;
    }
    public void setNotas(List<Nota> notas) { this.notas = notas; }
    private List<Nota> notas = new ArrayList<Nota>();


    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    private String semestre;


    public Estudante getEstudante() {
        return estudante;
    }
    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
    private Estudante estudante;

    public Materia getMateria() {
        return materia;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    private Materia materia;

}
