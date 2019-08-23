package br.com.unip.IziFood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContaController {

	@RequestMapping("/login")
	public String login() {
		return "conta/login";
	}
}
