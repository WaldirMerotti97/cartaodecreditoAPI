package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.form;

import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpEntity;

public class AnalisePropostaForm {

	@NotBlank
	private final String documento;
	@NotBlank
	private final String nome;
	@NotBlank
	private final String idProposta;

	public AnalisePropostaForm(@NotBlank String documento, @NotBlank String nome, @NotBlank String idProposta) {
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
	}
	
	public HttpEntity<AnalisePropostaForm> toHttpEntity() {
		return new HttpEntity<AnalisePropostaForm>(this);
		
	}

	public String getDocumento() {
		return documento;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public String getNome() {
		return nome;
	}

}
