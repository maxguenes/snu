package com.upe.snu.jpa.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */

@Entity
@Table(name="nota")
public class NotaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private double nota;
    private String comentario;

    @ManyToOne(cascade = CascadeType.MERGE)
    private MatriculaEntity matricula;

}
