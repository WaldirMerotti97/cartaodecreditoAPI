package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.controllers.proposta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Proposta;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.dto.PropostaDetalhesDto;

@RestController
@RequestMapping("propostas")
public class NovaPropostaController2 {

	@PersistenceContext
	private EntityManager entityManager;

	public NovaPropostaController2() {

	}

	@GetMapping("/{id}")
	@Transactional
	// 1
	public ResponseEntity<PropostaDetalhesDto> buscarDadosProposta(@PathVariable("id") String id) {

		Proposta proposta = entityManager.find(Proposta.class, id);

		return ResponseEntity.ok(new PropostaDetalhesDto(proposta));
	}

}
