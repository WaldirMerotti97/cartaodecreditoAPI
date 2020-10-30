package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.enums.PropostaStatus;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.form.AnalisePropostaForm;

@Entity
@Table(name = "proposta")
public class Proposta {

	@Id
	private String id = UUID.randomUUID().toString();
	private @NotBlank @Email(message = "O email informado deve estar com formato válido!") String email;
	private @NotBlank String nome;
	private @NotBlank String endereco;
	private @NotNull @Positive BigDecimal salario;
	private @NotBlank String documento;
	@Enumerated(EnumType.STRING)
	private PropostaStatus propostaStatus;

	public Proposta(@NotBlank @Email(message = "O email informado deve estar com formato válido!") String email,
			@NotBlank String nome, @NotBlank String endereco, @NotNull @Positive BigDecimal salario,
			@NotBlank String documento) {
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.documento = documento;

	}

	@Deprecated
	public Proposta() {

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PropostaStatus getPropostaStatus() {
		return propostaStatus;
	}

	public void setPropostaStatus(PropostaStatus propostaStatus) {
		this.propostaStatus = propostaStatus;
	}

	public AnalisePropostaForm toAnalisePropostaForm() {
		//
		return new AnalisePropostaForm(this.documento, this.nome, this.id);
	}

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", email=" + email + ", nome=" + nome + ", endereco=" + endereco + ", salario="
				+ salario + ", documento=" + documento + ", propostaStatus=" + propostaStatus + "]";
	}

}
