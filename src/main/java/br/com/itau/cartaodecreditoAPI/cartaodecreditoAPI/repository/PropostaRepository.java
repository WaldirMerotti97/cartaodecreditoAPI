package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

}
