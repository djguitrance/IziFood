package br.com.unip.IziFood.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Ingrediente;
import br.com.unip.IziFood.repositories.RepositoryIngrediente;

@Controller
public class HomeController {
	
	@Autowired
	private RepositoryIngrediente repIngrediente;

	//Página inicial - carrega a lista de ingredientes.
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {
		System.out.println(request.getServletContext().getRealPath(""));
		ModelAndView mv = new ModelAndView();
		List<Ingrediente> ingredientes = repIngrediente.findByOrderByNomeAsc();
		mv.addObject("ingredientes", ingredientes);
		mv.setViewName("home/home");
		return mv;
	}
	
	@GetMapping("/home")
	public String home2() {
		return "redirect:/";
	}
	
//	@GetMapping("/search")
//	@ResponseBody
//	public List<String> search(HttpServletRequest request) {
//		return repIngrediente.search(request.getParameter("term"));
//	}
}
