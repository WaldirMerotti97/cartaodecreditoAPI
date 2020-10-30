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
@Table(name = "aviso")
public class Aviso {

	@Id
	private String id;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime validoAte;
	private String destino;
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "cartao_id", referencedColumnName = "id");
	private Cartao cartao;

	@Deprecated
	public Aviso() {

	}

	public Aviso(LocalDateTime validoAte, String destino) {
		this.validoAte = validoAte;
		this.destino = destino;
	}

	public LocalDateTime getValidoAte() {
		return validoAte;
	}

	public void setValidoAte(LocalDateTime validoAte) {
		this.validoAte = validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}
