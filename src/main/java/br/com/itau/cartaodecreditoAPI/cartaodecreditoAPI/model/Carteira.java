package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Entity
@Table(name = "carteira")
public class Carteira {

	@Id
	private String id;
	private String email;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime associadaEm;
	private String emissor;
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "", referencedColumnName = "")
	private Cartao cartao;

	@Deprecated
	public Carteira() {

	}

	public Carteira(String id, String email, LocalDateTime associadaEm, String emissor) {
		this.id = id;
		this.email = email;
		this.associadaEm = associadaEm;
		this.emissor = emissor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getAssociadaEm() {
		return associadaEm;
	}

	public void setAssociadaEm(LocalDateTime associadaEm) {
		this.associadaEm = associadaEm;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

}
