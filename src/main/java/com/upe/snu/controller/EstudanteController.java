package com.upe.snu.controller;

import com.upe.snu.jpa.entity.Estudante;
import com.upe.snu.jpa.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Controller
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("estudantesList", this.estudanteRepository.findAll());
        return "estudante/index";
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editEstudante(@PathVariable("id") long id, Model model) {

        model.addAttribute("estudante", this.estudanteRepository.findOne(id));
        return "estudante/edit";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newEstudante(Model model) {
        return "estudante/new";
    }

    //For add and update person both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("estudante") Estudante estudante, Model model){
        this.estudanteRepository.save(estudante);

        model.addAttribute("estudantesList", this.estudanteRepository.findAll());

        return "estudante/index";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") long id, Model model){
        this.estudanteRepository.delete(id);
        model.addAttribute("estudantesList", this.estudanteRepository.findAll());
        return "estudante/index";
    }
}
