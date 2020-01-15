package com.algaworks;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatosControle {

	private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();

	static {

		LISTA_CONTATOS.add(new Contato("01", "Rodrigo", "+55 34 99264 8193"));
		LISTA_CONTATOS.add(new Contato("02", "Ana Camila", "+55 34 99264 1234"));
		LISTA_CONTATOS.add(new Contato("03", "Rafaella", "+55 34 99264 4566"));
		LISTA_CONTATOS.add(new Contato("04", "Henrique", "+55 34 99264 7899"));
		LISTA_CONTATOS.add(new Contato("05", "Rogério", "+55 34 99264 1452"));
		LISTA_CONTATOS.add(new Contato("06", "Célia Regina", "+55 34 99264 1123"));

	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contatos")
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("listar");
		modelAndView.addObject("contatos",LISTA_CONTATOS);
		
		return modelAndView;
	}
	
}
