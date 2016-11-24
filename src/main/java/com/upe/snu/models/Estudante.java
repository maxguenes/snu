package com.upe.snu.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
public class Estudante {

    public Long getId() {
        return id;
    }
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

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }
    public void setMatriculas(Set<Matricula> matriculas) { this.matriculas = matriculas; }
    private Set<Matricula> matriculas;

    public String toString() {
        return String.format(
                "Estudante[id=%d, nome='%s']",
                id, nome);
    }

}