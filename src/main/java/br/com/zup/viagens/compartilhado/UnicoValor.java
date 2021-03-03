package br.com.zup.viagens.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Documented
@Constraint
@Target(ElementType.FIELD)

public @interface UnicoValor {

}
