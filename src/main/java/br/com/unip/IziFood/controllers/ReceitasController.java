package br.com.unip.IziFood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Categoria;
import br.com.unip.IziFood.models.Receita;
import br.com.unip.IziFood.repositories.RepositoryCategoria;
import br.com.unip.IziFood.repositories.RepositoryIngrediente;
import br.com.unip.IziFood.repositories.RepositoryReceita;

@Controller
@RequestMapping("/receitas")
public class ReceitasController {
	
	@Autowired
	private RepositoryReceita repReceita;
	
	@Autowired
	private RepositoryIngrediente repIngrediente;
	
	@Autowired
	private RepositoryCategoria repCategoria;

	@PostMapping("/pesquisar")
	public ModelAndView buscar(@RequestParam String buscar) {
		ModelAndView mv = new ModelAndView("receitas/listar");
		mv.addObject("receitas", repReceita.search(buscar));
		return mv;
		
	}
	
	//Busca receitas a partir de uma lista de ingredientes
	@PostMapping("/buscar")
	public ModelAndView buscar(@RequestParam List<Long> IdIngredientes) {
		System.out.println(IdIngredientes);
		ModelAndView mv = new ModelAndView();
		mv.addObject("receitas", repReceita.buscaReceitas(IdIngredientes));
		mv.setViewName("receitas/listar");
		return mv;
	}
	
	@GetMapping("/exibir/{id}")
	public String exibir(@PathVariable("id") Long id, Model model) {
		Receita receita = repReceita.getOne(id);
		model.addAttribute("receita", receita);
		return "receitas/exibir";
	}
	
	@GetMapping("/buscarPorCategoria/{id}")
	public ModelAndView buscarPorCategoria(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("receitas/listar");
		Categoria categoria = repCategoria.getOne(id);
		mv.addObject("receitas", repReceita.findAllByCategoria(categoria) );
		return mv;
	}
}
