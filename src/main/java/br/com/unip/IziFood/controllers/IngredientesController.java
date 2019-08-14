package br.com.unip.IziFood.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ingredientes")
public class IngredientesController {

	@PostMapping("/listar")
	public ModelAndView listar(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ingredientes/listar");
		System.out.println();
		return mv;
	}
}
