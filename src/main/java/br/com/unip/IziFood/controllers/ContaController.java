package br.com.unip.IziFood.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unip.IziFood.models.Usuario;
import br.com.unip.IziFood.services.ServiceUsuario;

@Controller
public class ContaController {

	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@RequestMapping("/login")
	public String login() {
		return "conta/login";
	}
	
	@GetMapping("/registration")
	public ModelAndView registrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("conta/registrar");
		return mv;
	}
	
	@PostMapping("/registration")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Usuario usr = serviceUsuario.encontrarPorEmail(usuario.getEmail());
		if (usr != null) {
			result.rejectValue("email", "", "Usuário já cadastrado");
		}
		if (result.hasErrors()) {
			mv.setViewName("conta/registrar");
			mv.addObject("usuario", usuario);
		} else {
			serviceUsuario.salvar(usuario);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
}
