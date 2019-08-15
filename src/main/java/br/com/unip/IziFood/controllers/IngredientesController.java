package br.com.unip.IziFood.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ingredientes")
public class IngredientesController {

	@PostMapping("/listar")
	public ModelAndView listar(@RequestParam List<Long> ingrediente) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ingredientes", ingrediente);
		mv.setViewName("ingredientes/listar");
		return mv;
	}
}
