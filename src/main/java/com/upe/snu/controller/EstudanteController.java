package com.upe.snu.controller;

import com.upe.snu.jpa.entity.Estudante;
import com.upe.snu.jpa.entity.Materia;
import com.upe.snu.jpa.entity.Matricula;
import com.upe.snu.jpa.repository.EstudanteRepository;
import com.upe.snu.jpa.repository.MateriaRepository;
import com.upe.snu.jpa.repository.MatriculaRepository;
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

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

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

    @RequestMapping(value = "matricula/{id}", method = RequestMethod.GET)
    public String matriculaEstudante(@PathVariable("id") long id, Model model) {

        model.addAttribute("estudante", this.estudanteRepository.findOne(id));
        model.addAttribute("materiaList", this.materiaRepository.findAll());
        return "estudante/matricula";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newEstudante(Model model) {
        return "estudante/new";
    }

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("estudante") Estudante estudante, Model model){
        this.estudanteRepository.save(estudante);

        model.addAttribute("estudantesList", this.estudanteRepository.findAll());

        return "estudante/index";
    }

    @RequestMapping(value= "/addMatricula", method = RequestMethod.POST)
    public String addMatricula(@ModelAttribute("estudante") Estudante estudante,
                               @ModelAttribute("semestre") String semestre,
                               @ModelAttribute("materia") String materiaId, Model model){

        Materia materia = materiaRepository.findOne(Long.valueOf(materiaId));

        Matricula matricula = new Matricula();
        matricula.setSemestre(semestre);
        matricula.setEstudante(estudante);
        matricula.setMateria(materia);
        matriculaRepository.save(matricula);


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
