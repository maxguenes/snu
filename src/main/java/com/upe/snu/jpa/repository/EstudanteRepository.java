package com.upe.snu.jpa.repository;

import java.util.List;

import com.upe.snu.jpa.entity.EstudanteEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Max Guenes on 04/09/2016.
 */
public interface EstudanteRepository extends CrudRepository<EstudanteEntity, Long> {

}

