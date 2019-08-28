package br.com.unip.IziFood.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Usuario;
import br.com.unip.IziFood.services.ServiceUsuario;

@Controller
public class UsuarioController {

	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/minhaConta")
	public ModelAndView minhaConta(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("usuario/minhaConta");
		String username = request.getUserPrincipal().getName();
		Usuario usuario = serviceUsuario.encontrarPorUsername(username);
		mv.addObject("usuario", usuario);
		return mv;
	}
}
