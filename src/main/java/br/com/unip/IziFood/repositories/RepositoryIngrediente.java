package br.com.unip.IziFood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.unip.IziFood.models.Ingrediente;

public interface RepositoryIngrediente extends JpaRepository<Ingrediente, Long>{

	List<Ingrediente> findByOrderByNomeAsc();
	
	@Query("SELECT nome FROM Ingrediente where nome like %:keyword%")
	public List<String> search(@Param("keyword") String keyword);
	
	@Query("SELECT distinct i from Ingrediente i where i.id in (:IdIngredientes)")
	List<Ingrediente> buscarPorId(@Param("IdIngredientes") List<Long> IdIngredientes);

}
