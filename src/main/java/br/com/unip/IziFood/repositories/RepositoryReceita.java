package br.com.unip.IziFood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.IziFood.models.Ingrediente;
import br.com.unip.IziFood.models.Receita;

public interface RepositoryReceita extends JpaRepository<Receita, Long> {

	//List<Receita> findAllByIngrediente_Id(List<Long> ingrediente);

}
