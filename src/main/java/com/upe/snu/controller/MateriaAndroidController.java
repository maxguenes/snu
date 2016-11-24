package com.upe.snu.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.upe.snu.jpa.entity.MateriaEntity;
import com.upe.snu.jpa.repository.MateriaRepository;
import com.upe.snu.models.Materia;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Controller
@RequestMapping("/android/materia")
public class MateriaAndroidController {

	@Autowired
	private MateriaRepository materiaRepository;

	static Materia convert(MateriaEntity m)
	{
		Materia result = new Materia();
		result.setId(m.getId());
		result.setNome(m.getNome());
		return result;
	}
	
	private MateriaEntity convert(Materia m)
	{
		MateriaEntity result = new MateriaEntity();
		if(m.getId()==null){
    		result = new MateriaEntity();
    	}else{
    		result = this.materiaRepository.findOne(m.getId());
    	}
		result.setNome(m.getNome());
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<Materia> list() {
		List<Materia> targetCollection = new ArrayList<Materia>();
		for (MateriaEntity e : this.materiaRepository.findAll()) {
			e.setMatricula(null);
			targetCollection.add(convert(e));
		}
		return targetCollection;
	}
	
	@ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Materia get(@PathVariable("id") long id) {
        return convert(this.materiaRepository.findOne(id));
    }
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Materia addPerson(@RequestBody Materia materia) {
		return convert(this.materiaRepository.save(convert(materia)));
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> removePerson(@PathVariable("id") long id) {
		this.materiaRepository.delete(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
