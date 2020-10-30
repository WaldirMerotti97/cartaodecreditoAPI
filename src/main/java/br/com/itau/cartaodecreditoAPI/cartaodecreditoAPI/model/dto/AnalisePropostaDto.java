package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.dto;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.enums.AnalisePropostaStatus;

public class AnalisePropostaDto {

	private AnalisePropostaStatus resultadoSolicitacao;

	public AnalisePropostaStatus getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public void setResultadoSolicitacao(AnalisePropostaStatus resultadoSolicitacao) {
		this.resultadoSolicitacao = resultadoSolicitacao;
	}

}
