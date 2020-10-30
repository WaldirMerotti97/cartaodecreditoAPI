package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Entity
@Table(name = "renegociacao")
public class Renegociacao {

	@Id
	private String id;
	private int quantidade;
	private BigDecimal valor;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataDeCriacao;

	@Deprecated
	public Renegociacao() {

	}

	public Renegociacao(String id, int quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {

		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

}
