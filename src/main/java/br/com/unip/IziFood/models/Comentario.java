package br.com.unip.IziFood.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table (name = "comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descricao", nullable = false, length = 2000)
	@NotNull(message = "Por favor comente algo!")
	@Length(min = 5, max = 2000, message = "Seu comentário deve conter entre 5 a 2000 caracteres!")
	private String descricao;
	
	@Column(name = "data")
	private LocalDateTime data = LocalDateTime.now();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinTable(name="receita_id")
	private Receita receita;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Long getId() {
		return id;
	}
	
	
}
