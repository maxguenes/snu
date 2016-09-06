package com.upe.snu.jpa.entity;

import javax.persistence.*;

/**
 * Created by Max Guenes on 04/09/2016.
 */

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matricula")
    public Matricula getMatricula() {
        return matricula;
    }
    public void setMatricula(Matricula matricula) { this.matricula = matricula; }
    private Matricula matricula;

}
