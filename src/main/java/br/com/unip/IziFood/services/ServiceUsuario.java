package br.com.unip.IziFood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.unip.IziFood.models.Usuario;
import br.com.unip.IziFood.repositories.RepositoryUsuario;

@Service
public class ServiceUsuario {

	@Autowired
	private RepositoryUsuario repUsuario;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Usuario encontrarPorUsername(String Username) {
		return repUsuario.findByUsername(Username);
	}
	
	public Usuario encontrarPorEmail(String email) {
		return repUsuario.findByEmail(email);
	}
	
	public void salvar(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		repUsuario.save(usuario);
	}
	
	public void salvarNovaSenha(Usuario usuario, String novaSenha) {
		usuario.setSenha(passwordEncoder.encode(novaSenha));
		repUsuario.save(usuario);
	}
	
	public Usuario getOne(Long id) {
		return repUsuario.getOne(id);
	}
	
	public boolean corresponde(String rawPassword, String encodedPassword) {
		if (passwordEncoder.matches(rawPassword, encodedPassword)) {
		    return true;
		}
		
		return false;
	}
	
}
