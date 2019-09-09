package br.com.unip.IziFood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.unip.IziFood.models.Ingrediente;
import br.com.unip.IziFood.models.Receita;

public interface RepositoryReceita extends JpaRepository<Receita, Long> {

	List<Receita> findAllByIngredientes(List<Ingrediente> ingrediente);
	
	@Query("SELECT t from Receita t where t.nome like %:buscar%")
	public List<Receita> search(String buscar);
	
	@Query("SELECT distinct t from Receita t inner join t.ingredientes i where i.id in (:IdIngredientes)")
	public List<Receita> buscaReceitas (List<Long> IdIngredientes);

}
