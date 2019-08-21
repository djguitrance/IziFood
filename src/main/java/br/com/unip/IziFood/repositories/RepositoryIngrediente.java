package br.com.unip.IziFood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.IziFood.models.Ingrediente;

public interface RepositoryIngrediente extends JpaRepository<Ingrediente, Long>{

	List<Ingrediente> findByOrderByNomeAsc();

}
