package br.com.zup.viagens.compartilhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UnicoValorValidator implements ConstraintValidator<UnicoValor, Object> {
    private String atributo;
    private Class<?> classe;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UnicoValor parametros) {
        atributo = parametros.fieldName();
        classe = parametros.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query $query = manager.createQuery("");
        return false;
    }
}
