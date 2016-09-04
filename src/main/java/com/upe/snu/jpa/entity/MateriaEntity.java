package com.upe.snu.jpa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Entity
@Table(name="materia")
public class MateriaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;

    @OneToMany
    private List<MatriculaEntity> matricula;

    public MateriaEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return String.format(
                "Materia[id=%d, nome='%s']",
                id, nome);
    }
}
