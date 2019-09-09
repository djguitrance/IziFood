package br.com.unip.IziFood.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Ingrediente;
import br.com.unip.IziFood.repositories.RepositoryIngrediente;
import br.com.unip.IziFood.repositories.RepositoryReceita;

@Controller
@RequestMapping("/receitas")
public class ReceitasController {
	
	@Autowired
	private RepositoryReceita repReceita;
	
	@Autowired
	private RepositoryIngrediente repIngrediente;

	@PostMapping("/buscar")
	public ModelAndView buscar(@RequestParam String buscar) {
		ModelAndView mv = new ModelAndView("receitas/listar");
		mv.addObject("receitas", repReceita.search(buscar));
		return mv;
		
	}
	
	//Busca receitas a partir de uma lista de ingredientes
	@PostMapping("/listar")
	public ModelAndView listar(@RequestParam List<Long> IdIngredientes) {

//		List<Ingrediente> ingredientes = repIngrediente.findAllById(IdIngredientes);
			
		ModelAndView mv = new ModelAndView();
		mv.addObject("receitas", repReceita.buscaReceitas(IdIngredientes));
		mv.setViewName("receitas/listar");
		return mv;
	}
}
