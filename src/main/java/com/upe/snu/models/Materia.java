package com.upe.snu.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
public class Materia {

	public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    private Long id;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private String nome;

    public List<Matricula> getMatricula() {
        return matricula;
    }
    public void setMatricula(List<Matricula> matricula) { this.matricula = matricula; }
    private List<Matricula> matricula;


    public String toString() {
        return String.format(
                "Materia[id=%d, nome='%s']",
                id, nome);
    }
}
