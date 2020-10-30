package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.dto;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Proposta;

public class PropostaDto {

	private String id;

	public PropostaDto(Proposta proposta) {

		this.id = proposta.getId();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
