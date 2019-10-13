package br.com.unip.IziFood.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HistoricoId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "usuario_id")
	private Long id;
	
	@Column(name = "dt_hora")
	private LocalDateTime dt_hora = LocalDateTime.now();
	
	public HistoricoId() {
	}
	
	public HistoricoId(Long usuario_id) {
		this.id = usuario_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDt_hora() {
		return dt_hora;
	}

	public void setDt_hora(LocalDateTime dt_hora) {
		this.dt_hora = dt_hora;
	}
	
	
	
}
