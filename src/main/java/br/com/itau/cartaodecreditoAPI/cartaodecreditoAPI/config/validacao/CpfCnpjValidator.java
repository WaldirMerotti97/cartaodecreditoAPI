package br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.config.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import br.com.itau.cartaodecreditoAPI.cartaodecreditoAPI.config.validacao.anotacoes.CpfCnpj;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, CharSequence> {

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {

		CNPJValidator cnpjValidator = new CNPJValidator();
		CPFValidator cpfValidator = new CPFValidator();

		cnpjValidator.initialize(null);
		cpfValidator.initialize(null);

		return cnpjValidator.isValid(value, context) || cpfValidator.isValid(value, context);
	}

}