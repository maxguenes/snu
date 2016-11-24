package com.upe.snu.jpa.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
@Entity(name = "materia")
public class MateriaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "materia")
    public List<MatriculaEntity> getMatricula() {
        return matricula;
    }
    public void setMatricula(List<MatriculaEntity> matricula) { this.matricula = matricula; }
    private List<MatriculaEntity> matricula;


    public String toString() {
        return String.format(
                "Materia[id=%d, nome='%s']",
                id, nome);
    }
}
