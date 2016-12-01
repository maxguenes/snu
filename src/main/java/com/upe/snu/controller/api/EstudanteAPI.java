package com.upe.snu.controller.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upe.snu.jpa.database.entity.EstudanteEntity;
import com.upe.snu.jpa.database.entity.MatriculaEntity;
import com.upe.snu.jpa.database.repository.EstudanteRepository;
import com.upe.snu.models.Estudante;
import com.upe.snu.models.Matricula;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Controller
@RequestMapping("/api/estudante")
public class EstudanteAPI {

    @Autowired
    private EstudanteRepository estudanteRepository;
    
    static Estudante convert(EstudanteEntity e){
    	Estudante result = new Estudante();
    	result.setId(e.getId());
    	result.setNome(e.getNome());
    	
    	Set<Matricula> matriculas = new HashSet<>();
    	if(e.getMatriculas()!=null){
	    	for(MatriculaEntity m : e.getMatriculas()){
	    		matriculas.add(MatriculaAPI.convert(m));
	    	}
    	}
    	result.setMatriculas(matriculas);
    	
    	return result;
    }
    
    private EstudanteEntity convert(Estudante e){
    	EstudanteEntity result = null;
    	
    	if(e.getId()==null){
    		result = new EstudanteEntity();
    	}else{
    		result = this.estudanteRepository.findOne(e.getId());
    	}
    			
    	result.setNome(e.getNome());
    	return result;
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody List<Estudante> list() {
    	List<Estudante> targetCollection = new ArrayList<Estudante>();
    	for(EstudanteEntity e : this.estudanteRepository.findAll()){
    		e.setMatriculas(null);
    		targetCollection.add(convert(e));
    	}
        return targetCollection;
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Estudante get(@PathVariable("id") long id) {
        return convert(this.estudanteRepository.findOne(id));
    }

    @ResponseBody
    @RequestMapping(value= "/save", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Estudante addPerson(@RequestBody Estudante estudante){
        return convert(this.estudanteRepository.save(convert(estudante)));
    }
    
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> removePerson(@PathVariable("id") long id){
        this.estudanteRepository.delete(id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
