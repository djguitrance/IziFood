package br.com.unip.IziFood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.unip.IziFood.models.Categoria;
import br.com.unip.IziFood.models.Ingrediente;
import br.com.unip.IziFood.models.Receita;
import br.com.unip.IziFood.models.Usuario;

public interface RepositoryReceita extends JpaRepository<Receita, Long> {

	List<Receita> findAllByIngredientes(List<Ingrediente> ingrediente);
	
	@Query("SELECT t from Receita t where t.nome like %:buscar%")
	List<Receita> search(@Param("buscar") String buscar);
	
	@Query("SELECT distinct t from Receita t inner join t.ingredientes i where i.id in (:IdIngredientes)")
	List<Receita> buscaReceitas (@Param("IdIngredientes") List<Long> IdIngredientes);

	List<Receita> findAllByUsuario(Usuario usuario);
	
	List<Receita> findAllByCategoria(Categoria categoria);
}
