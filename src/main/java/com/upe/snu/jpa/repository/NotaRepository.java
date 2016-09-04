package com.upe.snu.jpa.repository;

import com.upe.snu.jpa.entity.EstudanteEntity;
import com.upe.snu.jpa.entity.NotaEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Max Guenes on 04/09/2016.
 */
public interface NotaRepository extends CrudRepository<NotaEntity, Long> {

}
