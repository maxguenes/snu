package com.upe.snu.jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    private Long id;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "matricula")
    public List<Nota> getNotas() {
        return notas;
    }
    public void setNotas(List<Nota> notas) { this.notas = notas; }
    private List<Nota> notas = new ArrayList<>();


    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    private String semestre;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estudante")
    public Estudante getEstudante() {
        return estudante;
    }
    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
    private Estudante estudante;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materia")
    public Materia getMateria() {
        return materia;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    private Materia materia;

}

