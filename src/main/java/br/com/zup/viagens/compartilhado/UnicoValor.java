package br.com.zup.viagens.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = {UnicoValorValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface UnicoValor {
    String message() default "{custom.unique.field.validator}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName();
    Class<?> domainClass();
}