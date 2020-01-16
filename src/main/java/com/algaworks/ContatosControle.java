package com.algaworks;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/contatos/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("formulario");
		modelAndView.addObject("contato",new Contato() );
		return modelAndView;
	}
	
	@PostMapping("/contatos")
	public String cadastrar(Contato contato) {
		
		String id = UUID.randomUUID().toString();
		contato.setId(id);
		LISTA_CONTATOS.add(contato);
		return "redirect:/contatos";
	}
	
	@GetMapping("/contatos/{id}/editar")
	public ModelAndView editar(@PathVariable String id) {
		
		
		ModelAndView modelAndView = new ModelAndView("formulario");
		Contato contato = procurarContato(id);
		
		
		modelAndView.addObject("contato",contato );
		return modelAndView;
	}
	
	public Contato procurarContato(String id) {
		for (int i = 0; i < LISTA_CONTATOS.size(); i++) {
			Contato contato = LISTA_CONTATOS.get(i);
			
			if (contato.getId().equals(id)) {
				return contato;				
			}
		}
		return null;
	}
	
}
