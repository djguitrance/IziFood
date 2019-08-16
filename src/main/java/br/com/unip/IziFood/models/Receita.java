package br.com.unip.IziFood.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rec_receitas")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rec_id")
	private Long id;
	
	@Column(name = "rec_nome")
	private String nome;
	
	@Column(name = "rec_preparo")
	private String preparo;
	
	@ManyToMany
	@JoinTable(name = "rec_receitas_has_ing_ingredientes",
				joinColumns = @JoinColumn(name = "rec_id"),
				inverseJoinColumns = @JoinColumn(name = "ing_id"))
	private List<Ingrediente> ingredientes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreparo() {
		return preparo;
	}

	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
