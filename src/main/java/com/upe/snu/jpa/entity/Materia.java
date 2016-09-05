package com.upe.snu.jpa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Entity
public class Materia {

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

    @OneToMany()
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
