package br.com.unip.IziFood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.IziFood.models.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	Usuario findByUsername(String username);

}
