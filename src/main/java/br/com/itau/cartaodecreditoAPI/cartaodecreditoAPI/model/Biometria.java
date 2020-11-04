package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "biometria")
public class Biometria {

	@Id
	private String id = UUID.randomUUID().toString();
	private byte[] bytesBiometria;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartao_id", referencedColumnName = "id")
	private Cartao cartao;

	public Biometria(byte[] bytesBiometria, Cartao cartao) {
		this.bytesBiometria = bytesBiometria;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getBytesBiometria() {
		return bytesBiometria;
	}

	public void setBytesBiometria(byte[] bytesBiometria) {
		this.bytesBiometria = bytesBiometria;
	}

}
