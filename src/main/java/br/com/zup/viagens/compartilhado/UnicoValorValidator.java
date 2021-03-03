package br.com.zup.viagens.compartilhado;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

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
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query $query = manager.createQuery(" select 1 from " +classe.getName()+" where " +atributo+
                " = :value ");
        $query.setParameter("value", value);

        List<?>list= $query.getResultList();
        Assert.isTrue(list.size() <=1);
        return false;
    }
}
