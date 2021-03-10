package br.com.zup.viagens.companhia;

import br.com.zup.viagens.compartilhado.UnicoValor;
import br.com.zup.viagens.paises.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCompanhiaRequest {
    @NotBlank
    @UnicoValor(fieldName = "nome", domainClass = Companhia.class)
    private String nome;
    @NotNull
    private Long idPais;

    public NovaCompanhiaRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Companhia toModel(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.idPais);
        return new Companhia(this.nome, pais);
    }
}
