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
@Table(name = "bloqueio")
public class Bloqueio {

	@Id
	private String id;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime bloqueadoEm;
	private String sistemaResponsavel;
	private boolean ativo;
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "cartao_id", referencedColumnName = "id");
	private Cartao cartao;

	@Deprecated
	public Bloqueio() {

	}

	public Bloqueio(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo) {

		this.id = id;
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}

	public void setBloqueadoEm(LocalDateTime bloqueadoEm) {
		this.bloqueadoEm = bloqueadoEm;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public void setSistemaResponsavel(String sistemaResponsavel) {
		this.sistemaResponsavel = sistemaResponsavel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
