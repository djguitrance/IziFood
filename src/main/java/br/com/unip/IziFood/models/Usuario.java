package br.com.unip.IziFood.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 50)
	@NotNull(message = "O nome é obrigatório!")
	@Length(min = 3, max = 200, message = "O nome deve conter entre 3 a 50 caracteres!")
	private String nome;
	
	@Column(name = "sobrenome", nullable = false, length = 100)
	@NotNull(message = "O sobrenome é obrigatório!")
	@Length(min = 3, max = 100, message = "O sobrenome deve conter entre 3 a 100 caracteres!")
	private String sobrenome;
	
	@Column(name = "email", nullable = false, length = 200)
	@NotNull(message = "O e-mail é obrigatório!")
	@Length(min = 5, max = 200, message = "O e-mail deve conter entre 5 e 200 caracteres!")
	private String email;
	
	@Column(name = "senha", nullable = false, length = 20)
	@NotNull(message = "A senha é obrigatória!")
	private String senha;
	
	@Column(name = "username", nullable = false, length = 20)
	@NotNull(message = "O nome de usuário é obrigatório!")
	@Length(max = 20, message = "O usuário deve conter entre 5 à 20 caracteres!")
	private String username;
	
	@OneToMany(mappedBy = "usuario")
	private List<Receita> receita;
	
	@OneToMany(mappedBy = "usuario")
	private List<Comentario> comentario;

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Receita> getReceita() {
		return receita;
	}

	public void setReceita(List<Receita> receita) {
		this.receita = receita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
