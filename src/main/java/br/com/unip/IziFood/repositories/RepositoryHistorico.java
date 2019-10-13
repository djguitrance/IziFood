package br.com.unip.IziFood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unip.IziFood.models.Historico;
import br.com.unip.IziFood.models.HistoricoId;

public interface RepositoryHistorico extends JpaRepository<Historico, HistoricoId>{
	
}
