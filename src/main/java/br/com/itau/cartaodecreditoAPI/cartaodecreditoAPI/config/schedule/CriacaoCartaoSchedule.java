package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.config.schedule;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.enums.PropostaStatus;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Cartao;
import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Proposta;

@Configuration
@EnableAsync
@EnableScheduling
public class CriacaoCartaoSchedule {

	private EntityManager entityManager;
	@Value("${criacao.cartao.host}")
	String criacaoCartaoHost;
	private RestTemplate restTemplate;

	public CriacaoCartaoSchedule(EntityManager entityManager, RestTemplate restTemplate) {
		this.entityManager = entityManager;
		this.restTemplate = restTemplate;
	}

	// responsavel por criar os cartoes de maneira assincrona
	// proposta status = 0 eh elegivel
	@Scheduled(fixedRate = 120000)
	@Transactional
	public void persisteCartao() {

		String urlGetCartoes = this.criacaoCartaoHost + "/api/cartoes?idProposta=";

		propostasElegiveis().forEach(proposta -> {

			String uriGetCartoesIdProposta = urlGetCartoes + proposta.getId().toString();

			ResponseEntity<String> resposta = this.restTemplate.exchange(uriGetCartoesIdProposta, HttpMethod.GET, null,
					String.class);

			Cartao cartao = retornaCartao(resposta);

			if (cartao != null && resposta.getStatusCode().is2xxSuccessful()) {
				proposta.setPropostaStatus(PropostaStatus.CONCLUIDA);
				entityManager.merge(proposta);
				entityManager.persist(cartao);
			}

		});

	}

	private Cartao retornaCartao(ResponseEntity<String> resposta) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(resposta.getBody(), Cartao.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public List<Proposta> propostasElegiveis() {

		Query query = entityManager.createQuery("select p from Proposta p where p.propostaStatus = 'ELEGIVEL'");
		List<Proposta> propostasElegiveis = query.getResultList();
		return propostasElegiveis;

	}

}
