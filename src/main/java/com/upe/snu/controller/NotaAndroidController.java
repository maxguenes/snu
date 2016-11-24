package com.upe.snu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upe.snu.jpa.entity.MatriculaEntity;
import com.upe.snu.jpa.entity.NotaEntity;
import com.upe.snu.jpa.repository.MatriculaRepository;
import com.upe.snu.jpa.repository.NotaRepository;
import com.upe.snu.models.Nota;

/**
 * Created by Max Guenes on 04/09/2016.
 */
@Controller
@RequestMapping("/android/nota")
public class NotaAndroidController {

	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	static Nota convert(NotaEntity n)
	{
		Nota result = new Nota();
		
		result.setId(n.getId());
		result.setNota(n.getNota());
		result.setComentario(n.getComentario());
		
		return result;
	}
	
	private NotaEntity convert(Nota n)
	{
		NotaEntity result = new NotaEntity();
		
		result.setId(n.getId());
		result.setNota(n.getNota());
		result.setComentario(n.getComentario());
		
		MatriculaEntity matricula = matriculaRepository.findOne(n.getMatricula().getId());
		result.setMatricula(matricula);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addNota", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Nota addNota(@RequestBody Nota nota) {
		NotaEntity notaEnity = convert(nota);
		return convert(notaRepository.save(notaEnity));
	}
}
