package br.com.zup.bootcamp.proposta.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, CharSequence> {

  @Override
  public boolean isValid(CharSequence value, ConstraintValidatorContext context) {

    if (value == null) {
      return false;
    }

    CNPJValidator cnpjValidator = new CNPJValidator();
    CPFValidator cpfValidator = new CPFValidator();

    cnpjValidator.initialize(null);
    cpfValidator.initialize(null);

    return cnpjValidator.isValid(value, context) || cpfValidator.isValid(value, context);
  }
}
