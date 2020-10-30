package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parcela")
public class Parcela {

	@Id
	private String id;
	private int quantidade;
	private BigDecimal valor;
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "", referencedColumnName = "")
	private Cartao cartao;

	@Deprecated
	public Parcela() {

	}

	public Parcela(String id, int quantidade, BigDecimal valor) {
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
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

}
