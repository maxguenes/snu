package com.upe.snu.controller;

import com.upe.snu.jpa.entity.MateriaEntity;
import com.upe.snu.jpa.repository.MateriaRepository;
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
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("materiaList", this.materiaRepository.findAll());
        return "materia/index";
    }


    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editMateria(@PathVariable("id") long id, Model model) {

        model.addAttribute("materia", this.materiaRepository.findOne(id));
        return "materia/edit";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newMteria(Model model) {
        return "materia/new";
    }

    //For add and update person both
    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("materia") MateriaEntity materia, Model model){
        this.materiaRepository.save(materia);
        return index(model);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") long id, Model model){
        this.materiaRepository.delete(id);
        return index(model);
    }
}
