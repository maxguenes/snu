package com.upe.snu.controller.api;

import com.upe.snu.jpa.search.repository.LivroRepository;
import com.upe.snu.models.Livro;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Controller
@RequestMapping("/api/livro")
public class LivroAPI {

    @Autowired
    private LivroRepository livroRepository;
    
    public static Livro convert(com.upe.snu.jpa.search.entity.Livro livro){
        Livro result = new Livro();
    	result.setId(livro.getId());
    	result.setNome(livro.getNome());
        result.setCodigo(livro.getCodigo());
        result.setAno(livro.getAno());
        result.setAutor(livro.getAutor());
    	result.setEditora(livro.getEditora());

    	return result;
    }

    public static com.upe.snu.jpa.search.entity.Livro convert(Livro livro){
        com.upe.snu.jpa.search.entity.Livro result = new com.upe.snu.jpa.search.entity.Livro();
        result.setId(livro.getId());
        result.setNome(livro.getNome());
        result.setCodigo(livro.getCodigo());
        result.setAno(livro.getAno());
        result.setAutor(livro.getAutor());
        result.setEditora(livro.getEditora());

        return result;
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody List<Livro> list() {
    	List<Livro> targetCollection = new ArrayList<Livro>();
    	for(com.upe.snu.jpa.search.entity.Livro livro : this.livroRepository.findAll()){
    		targetCollection.add(convert(livro));
    	}
        return targetCollection;
    }

    @RequestMapping(value="/search/{query}", method = RequestMethod.GET)
    public @ResponseBody List<Livro> list(@PathVariable("query") String query) {
        Iterable<com.upe.snu.jpa.search.entity.Livro> result = this.livroRepository.search(QueryBuilders.queryStringQuery(query));
        List<Livro> targetCollection = new ArrayList<Livro>();
        for(com.upe.snu.jpa.search.entity.Livro livro : result){
            targetCollection.add(convert(livro));
        }
        return targetCollection;
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Livro get(@PathVariable("id") String id) {
        return convert(this.livroRepository.findOne(id));
    }

    @ResponseBody
    @RequestMapping(value= "/save", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Livro addPerson(@RequestBody Livro Livro){
        return convert(this.livroRepository.save(convert(Livro)));
    }
    
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> removePerson(@PathVariable("id") String id){
        this.livroRepository.delete(id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
