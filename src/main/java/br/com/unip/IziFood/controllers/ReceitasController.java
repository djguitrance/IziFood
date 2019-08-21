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

	//Busca receitas a partir de uma lista de ingredientes
	@PostMapping("/listar")
	public ModelAndView listar(@RequestParam List<Long> IdIngredientes) {
		
		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		
		for (Long ingId : IdIngredientes) {
			Ingrediente ingrediente = repIngrediente.getOne(ingId);
			ingredientes.add(ingrediente);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("receitas", repReceita.findAllByIngredientes(ingredientes));
		mv.setViewName("receitas/listar");
		return mv;
	}
}
