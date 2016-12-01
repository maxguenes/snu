package com.upe.snu.controller;

import com.upe.snu.jpa.database.entity.EstudanteEntity;
import com.upe.snu.jpa.database.entity.MateriaEntity;
import com.upe.snu.jpa.database.entity.MatriculaEntity;
import com.upe.snu.jpa.database.entity.NotaEntity;
import com.upe.snu.jpa.database.repository.EstudanteRepository;
import com.upe.snu.jpa.database.repository.MateriaRepository;
import com.upe.snu.jpa.database.repository.MatriculaRepository;
import com.upe.snu.jpa.database.repository.NotaRepository;
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

    @Autowired
    private NotaRepository notaRepository;

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

    @RequestMapping(value = "nota/{id}", method = RequestMethod.GET)
    public String notaEstudante(@PathVariable("id") long id, Model model) {

        model.addAttribute("matricula", this.matriculaRepository.findOne(id));
        return "estudante/nota";
    }

    @RequestMapping(value = "history/{id}", method = RequestMethod.GET)
    public String historyEstudante(@PathVariable("id") long id, Model model) {

        model.addAttribute("estudante", this.estudanteRepository.findOne(id));

        return "estudante/history";
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
    public String addPerson(@ModelAttribute("estudante") EstudanteEntity estudante, Model model){
        this.estudanteRepository.save(estudante);

        model.addAttribute("estudantesList", this.estudanteRepository.findAll());

        return "estudante/index";
    }

    @RequestMapping(value= "/addMatricula", method = RequestMethod.POST)
    public String addMatricula(@ModelAttribute("estudante") EstudanteEntity estudante,
                               @ModelAttribute("semestre") String semestre,
                               @ModelAttribute("materia") String materiaId, Model model){

        MateriaEntity materia = materiaRepository.findOne(Long.valueOf(materiaId));

        MatriculaEntity matricula = new MatriculaEntity();
        matricula.setSemestre(semestre);
        matricula.setEstudante(estudante);
        matricula.setMateria(materia);
        matriculaRepository.save(matricula);


        model.addAttribute("estudantesList", this.estudanteRepository.findAll());

        return "estudante/index";
    }

    @RequestMapping(value= "/addNota", method = RequestMethod.POST)
    public String addNota(@ModelAttribute("matricula") MatriculaEntity matricula,
                               @ModelAttribute("nota") String nota,
                               @ModelAttribute("comentario") String comentario, Model model){

        NotaEntity notaEnity = new NotaEntity();
        notaEnity.setNota(Double.valueOf(nota));
        notaEnity.setComentario(comentario);
        notaEnity.setMatricula(matricula);

        notaRepository.save(notaEnity);

        matricula = matriculaRepository.findOne(matricula.getId());

        return historyEstudante(matricula.getEstudante().getId() ,model);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removePerson(@PathVariable("id") long id, Model model){
        this.estudanteRepository.delete(id);
        model.addAttribute("estudantesList", this.estudanteRepository.findAll());
        return "estudante/index";
    }
}
