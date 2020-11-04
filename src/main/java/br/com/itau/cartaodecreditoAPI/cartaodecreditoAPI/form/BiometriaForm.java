package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.form;

import java.io.IOException;
import java.util.Base64;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Biometria;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Cartao;

@Valid
public class BiometriaForm {

	@NotBlank
	private String idCartao;

	public String getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}

	public Biometria toModel(MultipartFile biometria, Cartao cartao) {
		try {
			return new Biometria(biometria.getBytes(), cartao);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
