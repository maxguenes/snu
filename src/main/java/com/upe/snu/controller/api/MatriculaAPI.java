package com.upe.snu.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upe.snu.jpa.database.entity.EstudanteEntity;
import com.upe.snu.jpa.database.entity.MateriaEntity;
import com.upe.snu.jpa.database.entity.MatriculaEntity;
import com.upe.snu.jpa.database.entity.NotaEntity;
import com.upe.snu.jpa.database.repository.EstudanteRepository;
import com.upe.snu.jpa.database.repository.MateriaRepository;
import com.upe.snu.jpa.database.repository.MatriculaRepository;
import com.upe.snu.models.Materia;
import com.upe.snu.models.Matricula;
import com.upe.snu.models.Nota;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Controller
@RequestMapping("/api/matricula")
public class MatriculaAPI {

    @Autowired
    private MatriculaRepository matriculaRepository;
    
    @Autowired
    private MateriaRepository materiaRepository;
    
    @Autowired
    private EstudanteRepository estudanteRepository;
    
    @ResponseBody
    @RequestMapping(value = "get/{id}", method = RequestMethod.POST)
    public MatriculaEntity editEstudante(@PathVariable("id") long id) {
        return this.matriculaRepository.findOne(id);
    }
    
    static Matricula convert(MatriculaEntity m){
    	Matricula result = new Matricula();
    	result.setId(m.getId());
    	result.setSemestre(m.getSemestre());
    	
    	List<Nota> notas = new ArrayList<>();
    	if(m.getNotas()!=null){
			for(NotaEntity notaEntity : m.getNotas()){
				notas.add(NotaAPI.convert(notaEntity));
			}
    	}
    	
    	Materia materia = MateriaAPI.convert(m.getMateria());
		result.setMateria(materia);
		result.setNotas(notas);
		
		return result;
    }
    
    private MatriculaEntity convert(Matricula m){
    	MatriculaEntity result = new MatriculaEntity();
    	result.setSemestre(m.getSemestre());
		
    	EstudanteEntity estudante = estudanteRepository.findOne(m.getEstudante().getId());
    	result.setEstudante(estudante);
    	
    	MateriaEntity materia = materiaRepository.findOne(m.getMateria().getId());
    	result.setMateria(materia);
    	
		return result;
    }

    @ResponseBody
    @RequestMapping(value= "/addMatricula", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Matricula addMatricula(@RequestBody Matricula matricula){
        MatriculaEntity matriculaEntity = convert(matricula);
        MatriculaEntity saved = matriculaRepository.save(matriculaEntity);
        return convert(saved);
    }

}
