package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Entity
@Table(name = "cartao")
public class Cartao {

	@Id
	private String id;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime emitidoEm;
	private String titular;
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Bloqueio> bloqueios;
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Aviso> avisos;
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Carteira> carteiras;
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
	private List<Parcela> parcelas;
	private BigDecimal limite;
	@OneToOne(cascade = CascadeType.ALL)
	private Renegociacao renegociacao;
	@OneToOne(cascade = CascadeType.ALL)
	private Vencimento vencimento;
	private String idProposta;

	public Cartao() {

	}

	public Cartao(String id, LocalDateTime emitidoEm, String titular, List<Bloqueio> bloqueios, List<Aviso> avisos,
			List<Carteira> carteiras, List<Parcela> parcelas, BigDecimal limite, Renegociacao renegociacao,
			Vencimento vencimento, String idProposta) {
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueios = bloqueios;
		this.avisos = avisos;
		this.carteiras = carteiras;
		this.parcelas = parcelas;
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public void setEmitidoEm(LocalDateTime emitidoEm) {
		this.emitidoEm = emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public List<Bloqueio> getBloqueios() {
		return bloqueios;
	}

	public void setBloqueios(List<Bloqueio> bloqueios) {
		this.bloqueios = bloqueios;
	}

	public List<Aviso> getAvisos() {
		return avisos;
	}

	public void setAvisos(List<Aviso> avisos) {
		this.avisos = avisos;
	}

	public List<Carteira> getCarteiras() {
		return carteiras;
	}

	public void setCarteiras(List<Carteira> carteiras) {
		this.carteiras = carteiras;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public Renegociacao getRenegociacao() {
		return renegociacao;
	}

	public void setRenegociacao(Renegociacao renegociacao) {
		this.renegociacao = renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public void setVencimento(Vencimento vencimento) {
		this.vencimento = vencimento;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}

	@Override
	public String toString() {
		return "Cartao [id=" + id + ", emitidoEm=" + emitidoEm + ", titular=" + titular + ", bloqueios=" + bloqueios
				+ ", avisos=" + avisos + ", carteiras=" + carteiras + ", parcelas=" + parcelas + ", limite=" + limite
				+ ", renegociacao=" + renegociacao + ", vencimento=" + vencimento + ", idProposta=" + idProposta + "]";
	}

}
