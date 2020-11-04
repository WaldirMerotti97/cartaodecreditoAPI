package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.controllers.biometria;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.form.BiometriaForm;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Biometria;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Cartao;

@RestController
@RequestMapping(value = "/biometrias")
public class BiometriaController {

	private final EntityManager entityManager;

	public BiometriaController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@PostMapping(value = "/nova", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	@Transactional
	public ResponseEntity<?> cadastraBiometria(
			@Valid @RequestPart(value = "biometriaForm", required = true) String biometriaForm,
			@RequestPart(value = "biometria", required = true) MultipartFile biometria,
			UriComponentsBuilder uriComponentsBuilder, HttpServletRequest httpServletRequest,
			@RequestHeader(value = "User-Agent") String userAgent) {

		System.out.println(httpServletRequest.getRemoteAddr());

		System.out.println(userAgent);

		BiometriaForm biometriaFormDeserialized = new BiometriaForm();

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			biometriaFormDeserialized = objectMapper.readValue(biometriaForm, BiometriaForm.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		Cartao cartao = this.entityManager.find(Cartao.class, biometriaFormDeserialized.getIdCartao());

		Biometria biometriaModel = biometriaFormDeserialized.toModel(biometria, cartao);

		if (cartao != null) {

			cartao.getBiometrias().add(biometriaModel);

			this.entityManager.persist(biometriaModel);

			entityManager.merge(cartao);

		} else {
			ResponseEntity.notFound();
		}

		URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(biometriaModel.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

}
