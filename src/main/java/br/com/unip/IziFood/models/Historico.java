package br.com.unip.IziFood.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "historico")
public class Historico {

	@EmbeddedId
	private HistoricoId id;
	
	@ManyToMany
	@JoinTable(name = "historico_has_ingrediente",
				joinColumns = {@JoinColumn(name = "historico_dt_hora"), @JoinColumn(name = "historico_usuario_id")},
				inverseJoinColumns = {@JoinColumn(name = "ingrediente_id")})
	private List<Ingrediente> ingredientes;
	
	public Historico() {
	}
	
	public Historico(HistoricoId historicoId, List<Ingrediente> ingredientes) {
		this.id = historicoId;
		this.ingredientes = ingredientes;
	}

	public HistoricoId getId() {
		return id;
	}

	public void setId(HistoricoId id) {
		this.id = id;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	
}
