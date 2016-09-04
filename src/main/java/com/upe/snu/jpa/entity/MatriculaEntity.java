package com.upe.snu.jpa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Entity
@Table(name="estudante")
public class MatriculaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String semestre;

    @OneToMany
    private List<NotaEntity> notas;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private EstudanteEntity estudante;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private MateriaEntity materia;

    public MatriculaEntity() {

    }

    public Long getId() {
        return id;
    }

    public List<NotaEntity> getNotas() {
        return notas;
    }
    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public EstudanteEntity getEstudante() {
        return estudante;
    }

    public void setEstudante(EstudanteEntity estudante) {
        this.estudante = estudante;
    }

    public MateriaEntity getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntity materia) {
        this.materia = materia;
    }
}
