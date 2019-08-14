package br.com.unip.IziFood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.repositories.RepositorieIngrediente;

@Controller
public class HomeController {
	
	@Autowired
	private RepositorieIngrediente RepositorieIngrediente;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ingredientes", RepositorieIngrediente.findAll());
		mv.setViewName("home/home");
		return mv;
	}
}
