package com.upe.snu.jpa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Entity
@Table(name="estudante")
public class EstudanteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;

    @OneToMany
    private List<MatriculaEntity> matriculas;

    public EstudanteEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return String.format(
                "Estudante[id=%d, nome='%s']",
                id, nome);
    }

}
