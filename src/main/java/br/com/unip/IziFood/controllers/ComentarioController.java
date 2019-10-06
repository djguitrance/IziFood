package br.com.unip.IziFood.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Comentario;
import br.com.unip.IziFood.models.Receita;
import br.com.unip.IziFood.models.Usuario;
import br.com.unip.IziFood.repositories.RepositoryComentario;
import br.com.unip.IziFood.repositories.RepositoryReceita;
import br.com.unip.IziFood.repositories.RepositoryUsuario;
import br.com.unip.IziFood.services.ServiceUsuario;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@Autowired
	private RepositoryUsuario repUsuario;
	
	@Autowired
	private RepositoryReceita repReceita;
	
	@Autowired
	private RepositoryComentario repComentario;

	@RequestMapping("/adicionar")
	public ModelAndView adicionar(@RequestParam Long idReceita, @RequestParam String comentario ,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		String username = request.getUserPrincipal().getName();
		Usuario usuario = serviceUsuario.encontrarPorUsername(username);
		Receita receita = repReceita.getOne(idReceita);
		Comentario coment = new Comentario();
		coment.setUsuario(usuario);
		coment.setDescricao(comentario);
		coment.setReceita(receita);
		repComentario.save(coment);
		return mv;
	}
}
