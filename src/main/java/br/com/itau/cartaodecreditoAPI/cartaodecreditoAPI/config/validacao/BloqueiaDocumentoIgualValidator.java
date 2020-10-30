package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.config.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.form.NovaPropostaForm;

@Component
public class BloqueiaDocumentoIgualValidator {

	@PersistenceContext
	private EntityManager entityManager;

	public boolean estaValido(NovaPropostaForm novaPropostaForm) {

		return entityManager.createQuery("select p.documento from Proposta p where p.documento = :documento")
				.setParameter("documento", novaPropostaForm.getDocumento()).getResultList().isEmpty();

	}

}
