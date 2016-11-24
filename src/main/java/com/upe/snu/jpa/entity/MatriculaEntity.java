package com.upe.snu.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
@Entity(name="matricula")
public class MatriculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    private Long id;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "matricula")
    public List<NotaEntity> getNotas() {
        return notas;
    }
    public void setNotas(List<NotaEntity> notas) { this.notas = notas; }
    private List<NotaEntity> notas = new ArrayList<>();


    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    private String semestre;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estudante")
    public EstudanteEntity getEstudante() {
        return estudante;
    }
    public void setEstudante(EstudanteEntity estudante) {
        this.estudante = estudante;
    }
    private EstudanteEntity estudante;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materia")
    public MateriaEntity getMateria() {
        return materia;
    }
    public void setMateria(MateriaEntity materia) {
        this.materia = materia;
    }
    private MateriaEntity materia;

}

