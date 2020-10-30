package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.form;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.config.validacao.anotacoes.CpfCnpj;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Proposta;

public class NovaPropostaForm {

	@NotBlank
	@Email(message = "O email informado deve estar com formato válido!")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String endereco;
	@NotNull
	@Positive
	private BigDecimal salario;
	@CpfCnpj
	@NotBlank
	private String documento;

	public NovaPropostaForm(@NotBlank @Email(message = "O email informado deve estar com formato válido!") String email,
			@NotBlank String nome, @NotBlank String endereco, @NotNull @Positive BigDecimal salario,
			@NotBlank String documento) {
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.documento = documento;
	}

	public Proposta toModel() {

		return new Proposta(this.email, this.nome, this.endereco, this.salario, this.documento);
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

}
