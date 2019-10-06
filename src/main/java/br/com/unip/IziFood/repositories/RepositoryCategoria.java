package br.com.unip.IziFood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.IziFood.models.Categoria;
import br.com.unip.IziFood.models.Ingrediente;

public interface RepositoryCategoria extends JpaRepository<Categoria, Long>{

}
