package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.dto;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.enums.PropostaStatus;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Proposta;

public class PropostaDetalhesDto {

	private String id = UUID.randomUUID().toString();
	private String email;
	private String nome;
	private String endereco;
	private BigDecimal salario;
	private String documento;
	private PropostaStatus propostaStatus;

	public PropostaDetalhesDto(Proposta proposta) {
		this.id = proposta.getId();
		this.email = proposta.getEmail();
		this.nome = proposta.getNome();
		this.endereco = proposta.getEndereco();
		this.salario = proposta.getSalario();
		this.documento = proposta.getDocumento();
		this.propostaStatus = proposta.getPropostaStatus();
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public PropostaStatus getPropostaStatus() {
		return propostaStatus;
	}

	public void setPropostaStatus(PropostaStatus propostaStatus) {
		this.propostaStatus = propostaStatus;
	}

}
