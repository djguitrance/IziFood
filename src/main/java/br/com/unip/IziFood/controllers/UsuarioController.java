package br.com.unip.IziFood.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Categoria;
import br.com.unip.IziFood.models.Usuario;
import br.com.unip.IziFood.repositories.RepositoryCategoria;
import br.com.unip.IziFood.repositories.RepositoryReceita;
import br.com.unip.IziFood.repositories.RepositoryUsuario;
import br.com.unip.IziFood.services.ServiceUsuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@Autowired
	private RepositoryUsuario repUsuario;
	
	@Autowired
	private RepositoryReceita repReceita;
	
	@Autowired
	private RepositoryCategoria repCategoria;
	
	@GetMapping("/minhaConta")
	public ModelAndView minhaConta(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("usuario/minhaConta");
		String username = request.getUserPrincipal().getName();
		Usuario usuario = serviceUsuario.encontrarPorUsername(username);
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public String alterar(@PathVariable("id") Long id, Model model) {
		Usuario usuario = serviceUsuario.getOne(id);
		model.addAttribute("usuario", usuario);
		return "usuario/editarConta";
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			mv.setViewName("usuario/editarConta");
			mv.addObject(usuario);
		} else {
			mv.setViewName("redirect:/usuario/minhaConta");
			repUsuario.save(usuario);
		}
		
		return mv;
	}
	
	@GetMapping("/alterarSenha/{id}")
	public String alterarSenha(@PathVariable("id") Long id, Model model) {
		Usuario usuario = repUsuario.getOne(id);
		model.addAttribute("usuario", usuario);
		return "usuario/editarSenha";
	}
	
	@PostMapping("/alterarSenha")
	public ModelAndView alterarSenha(@Valid Usuario usuario, @RequestParam String senhaAtual, @RequestParam String senhaNova, BindingResult result ) {
		ModelAndView mv = new ModelAndView();
		if (!serviceUsuario.corresponde(senhaAtual, usuario.getSenha())) {
			mv.setViewName("usuario/editarSenha");
			mv.addObject(usuario);
		}else {
			mv.setViewName("redirect:/usuario/minhaConta");
			serviceUsuario.salvarNovaSenha(usuario, senhaNova);
		}
		
		return mv;
	}
	
	@GetMapping("/minhasReceitas")
	public ModelAndView minhasReceitas(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String username = request.getUserPrincipal().getName();
		Usuario usuario = serviceUsuario.encontrarPorUsername(username);
		mv.addObject("receitas", repReceita.findAllByUsuario(usuario));
		mv.setViewName("usuario/minhasReceitas");
		return mv;
	}
	
	//Alterar depois ( INTELIGÊNCIA ARTIFICIAL ) //
	
	@GetMapping("/sugestoes")
	public ModelAndView sugestoes(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		if (SecurityContextHolder.getContext().getAuthentication().getName().equals("gabriel") ) {
			mv.addObject("receitas", repReceita.search("bolo"));
		}
		
		if (SecurityContextHolder.getContext().getAuthentication().getName().equals("guilherme")) {
			Categoria categoria = repCategoria.getOne((long) 6);
			mv.addObject("receitas", repReceita.findAllByCategoria(categoria));
		}
		
		
		mv.setViewName("receitas/listar");
		
		return mv;
	}
}
