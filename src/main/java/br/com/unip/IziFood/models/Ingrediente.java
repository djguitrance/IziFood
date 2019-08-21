package br.com.unip.IziFood.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ing_ingredientes")
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ing_id")
	private Long id;
	
	@NotNull(message = "O nome é obrigatório")
	@Column(name = "ing_nome")
	private String nome;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		Ingrediente ingrediente = (Ingrediente) obj;
		if (ingrediente.getNome() == this.nome) {
			return true;
		}
		
		return false;
	}
	
	
}
