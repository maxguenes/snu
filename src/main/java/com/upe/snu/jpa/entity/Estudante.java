package com.upe.snu.jpa.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Entity(name = "estudante")
public class Estudante {

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
