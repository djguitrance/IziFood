package br.com.unip.IziFood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Ingrediente;
import br.com.unip.IziFood.repositories.RepositorieIngrediente;

@Controller
public class HomeController {
	
	@Autowired
	private RepositorieIngrediente repIngrediente;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		List<Ingrediente> ingredientes = repIngrediente.findAll();
		mv.addObject("ingredientes", ingredientes);
		mv.setViewName("home/home");
		return mv;
	}
}
