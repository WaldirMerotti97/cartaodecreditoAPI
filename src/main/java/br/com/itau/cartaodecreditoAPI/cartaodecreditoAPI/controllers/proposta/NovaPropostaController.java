package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.controllers.proposta;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.config.validacao.BloqueiaDocumentoIgualValidator;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.enums.AnalisePropostaStatus;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.form.AnalisePropostaForm;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.form.NovaPropostaForm;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Proposta;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.dto.AnalisePropostaDto;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.dto.PropostaDto;

@RestController
@RequestMapping("propostas")
public class NovaPropostaController {

	private final Logger log = LoggerFactory.getLogger(NovaPropostaController.class);
	private EntityManager entityManager;
	// 1
	private final BloqueiaDocumentoIgualValidator bloqueiaDocumentoIgualValidator;
	private RestTemplate restTemplate;

	public NovaPropostaController(EntityManager entityManager,
			BloqueiaDocumentoIgualValidator bloqueiaDocumentoIgualValidator, RestTemplate restTemplate) {
		this.entityManager = entityManager;
		this.bloqueiaDocumentoIgualValidator = bloqueiaDocumentoIgualValidator;
		this.restTemplate = restTemplate;
	}

	@PostMapping("/nova")
	@Transactional
	// 1
	public ResponseEntity<PropostaDto> criaProposta(@RequestBody @Valid NovaPropostaForm novaPropostaForm,
			UriComponentsBuilder uriComponentsBuilder, @Value("${analise.host}") String analiseHost,
			@Value("${criacao.cartao.host}") String criacaoCartaoHost) {

		// 1
		if (!bloqueiaDocumentoIgualValidator.estaValido(novaPropostaForm)) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		// 1
		Proposta proposta = novaPropostaForm.toModel();

		AnalisePropostaForm analisePropostaForm = proposta.toAnalisePropostaForm();

		final String uriAnalise = analiseHost + "/api/solicitacao";
		log.info("Chamando {}", uriAnalise);

		// 1
		AnalisePropostaDto analisePropostaDto = this.restTemplate.postForObject(uriAnalise, analisePropostaForm,
				AnalisePropostaDto.class);

		// 1
		proposta.setPropostaStatus(AnalisePropostaStatus.obtemStatus(analisePropostaDto));

//		final String uriGeracaoCartao = criacaoCartaoHost + "/api/cartoes";

		// faz a criacao do cartao em segundo plano e retorna o http status da
		// requisicao
//		ResponseEntity<String> resposta = this.restTemplate.exchange(uriGeracaoCartao, HttpMethod.POST,
//				analisePropostaForm.toHttpEntity(), String.class);

		entityManager.persist(proposta);

		URI uri = uriComponentsBuilder.path("propostas/{id}").buildAndExpand(proposta.getId()).toUri();
		return ResponseEntity.created(uri).body(new PropostaDto(proposta));

	}

}
