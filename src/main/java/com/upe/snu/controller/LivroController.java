package com.upe.snu.controller;

import com.upe.snu.controller.api.LivroAPI;
import com.upe.snu.jpa.database.entity.MateriaEntity;
import com.upe.snu.jpa.database.entity.MatriculaEntity;
import com.upe.snu.jpa.database.entity.NotaEntity;
import com.upe.snu.jpa.database.repository.MateriaRepository;
import com.upe.snu.jpa.database.repository.MatriculaRepository;
import com.upe.snu.jpa.database.repository.NotaRepository;
import com.upe.snu.jpa.search.repository.LivroRepository;
import com.upe.snu.models.Livro;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;



    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("livroList", this.livroRepository.findAll().iterator());
        return "livro/index";
    }

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("query") String query, Model model) {
        if(query !=null && !query.isEmpty()) {
            Iterable<com.upe.snu.jpa.search.entity.Livro> result = this.livroRepository.search(QueryBuilders.queryStringQuery(query));
            model.addAttribute("livroList", result.iterator());
            model.addAttribute("query", query);
            return "livro/index";
        }else{
            return index(model);
        }
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editlivro(@PathVariable("id") String id, Model model) {
        model.addAttribute("livro", this.livroRepository.findOne(id));
        return "livro/edit";
    }


    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newlivro(Model model) {
        return "livro/new";
    }

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("livro") Livro livro, Model model){
        com.upe.snu.jpa.search.entity.Livro convert = LivroAPI.convert(livro);
        this.livroRepository.save(convert);
        return index(model);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") String id, Model model){
        this.livroRepository.delete(id);
        return index(model);
    }
}
