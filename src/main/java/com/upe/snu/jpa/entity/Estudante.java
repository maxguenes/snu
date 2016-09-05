package com.upe.snu.jpa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Entity
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

    @OneToMany(fetch = FetchType.LAZY)
    public List<Matricula> getMatriculas() {
        return matriculas;
    }
    public void setMatriculas(List<Matricula> matriculas) { this.matriculas = matriculas; }
    private List<Matricula> matriculas;

    public String toString() {
        return String.format(
                "Estudante[id=%d, nome='%s']",
                id, nome);
    }

}
