package com.upe.snu.jpa.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by Max Guenes on 04/09/2016.
 */

@JsonSerialize
@JsonInclude(Include.NON_EMPTY)
@Entity(name="nota")
public class NotaEntity {

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
    public MatriculaEntity getMatricula() {
        return matricula;
    }
    public void setMatricula(MatriculaEntity matricula) { this.matricula = matricula; }
    private MatriculaEntity matricula;

}
