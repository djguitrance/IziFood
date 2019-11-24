package br.com.unip.IziFood.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Categoria;
import br.com.unip.IziFood.models.Historico;
import br.com.unip.IziFood.models.HistoricoId;
import br.com.unip.IziFood.models.Ingrediente;
import br.com.unip.IziFood.models.Receita;
import br.com.unip.IziFood.models.Usuario;
import br.com.unip.IziFood.repositories.RepositoryCategoria;
import br.com.unip.IziFood.repositories.RepositoryHistorico;
import br.com.unip.IziFood.repositories.RepositoryIngrediente;
import br.com.unip.IziFood.repositories.RepositoryReceita;
import br.com.unip.IziFood.services.ServiceUsuario;

@Controller
@RequestMapping("/receitas")
public class ReceitasController {
	
	@Autowired
	private RepositoryReceita repReceita;
	
	@Autowired
	private RepositoryIngrediente repIngrediente;
	
	@Autowired
	private RepositoryCategoria repCategoria;
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@Autowired
	private RepositoryHistorico repHistorico;

	@PostMapping("/pesquisar")
	public ModelAndView buscar(@RequestParam String buscar) {
		ModelAndView mv = new ModelAndView("receitas/listar");
		mv.addObject("receitas", repReceita.search(buscar));
		return mv;
		
	}
	
	//Busca receitas a partir de uma lista de ingredientes
	@PostMapping("/buscar")
	public ModelAndView buscar(@RequestParam List<Long> IdIngredientes) {
		ModelAndView mv = new ModelAndView();
		
		List<Receita> receitas = repReceita.buscaReceitas(IdIngredientes);
		List<Ingrediente> ingredientes = repIngrediente.buscarPorId(IdIngredientes);
		
		List<Receita> filtradas = new ArrayList<Receita>();
		List<Receita> rejeitadas = new ArrayList<Receita>();
		
		for (Receita receita : receitas) {
			List<Ingrediente> ingredientesReceita = receita.getIngredientes();
			if (ingredientes.containsAll(ingredientesReceita)) {
				filtradas.add(receita);
			}
			
		}
		
		mv.addObject("receitas", filtradas);
		mv.setViewName("receitas/listar");
		return mv;
	}
	
	@GetMapping("/buscarSelecionados/{id}")
	public ModelAndView buscarSelecionados(@PathVariable("id") List<Long> id) {
		ModelAndView mv = new ModelAndView("/home");
		return mv;
	}
	
	@GetMapping("/exibir/{id}")
	public ModelAndView exibir(@PathVariable("id") Long id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("receitas/exibir");
		Receita receita = repReceita.getOne(id);
		mv.addObject("receita", receita);
		
		
//		if (SecurityContextHolder.getContext().getAuthentication().getName() != "anonymousUser") {
//			String username = request.getUserPrincipal().getName();
//			Usuario usuario = serviceUsuario.encontrarPorUsername(username);
//			HistoricoId historicoId = new HistoricoId(usuario.getId());
//			List<Ingrediente> ingredientes = receita.getIngredientes();
//			System.out.println(ingredientes);
//			Historico historico = new Historico(historicoId, ingredientes);
//			repHistorico.save(historico);
//		}
		
		
		return mv;
	}
	
	@GetMapping("/buscarPorCategoria/{id}")
	public ModelAndView buscarPorCategoria(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("receitas/listar");
		Categoria categoria = repCategoria.getOne(id);
		mv.addObject("receitas", repReceita.findAllByCategoria(categoria) );
		return mv;
	}
	
	@GetMapping("/novaReceita")
	public ModelAndView novaReceita() {
		ModelAndView mv = new ModelAndView("receitas/novaReceita");
		return mv;
	}
}
