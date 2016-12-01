package com.upe.snu.jpa.database.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
@Entity(name = "estudante")
public class EstudanteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "estudante")
    public Set<MatriculaEntity> getMatriculas() {
        return matriculas;
    }
    public void setMatriculas(Set<MatriculaEntity> matriculas) { this.matriculas = matriculas; }
    private Set<MatriculaEntity> matriculas;

    public String toString() {
        return String.format(
                "Estudante[id=%d, nome='%s']",
                id, nome);
    }

}
