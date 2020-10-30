package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.enums;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.dto.AnalisePropostaDto;

public enum AnalisePropostaStatus {

	COM_RESTRICAO, SEM_RESTRICAO;

	public static PropostaStatus obtemStatus(AnalisePropostaDto analise) {
		if (COM_RESTRICAO.equals(analise.getResultadoSolicitacao()))
			return PropostaStatus.NAO_ELEGIVEL;
		else
			return PropostaStatus.ELEGIVEL;
	}

}
