package com.upe.snu.jpa.search.repository;

import com.upe.snu.jpa.search.entity.Livro;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by Max Guenes on 01/12/2016.
 */
public interface LivroRepository extends ElasticsearchRepository<Livro, String> {
    public List<Livro> findByNome(String nome);
}
