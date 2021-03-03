package br.com.zup.viagens.paises;

import br.com.zup.viagens.compartilhado.UnicoValor;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UnicoValor(domainClass = Pais.class,fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public NovoPaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public NovoPaisRequest() {
    }

    @Override
    public String toString() {
        return "NovoPaisRequest{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public Pais toModel() {

        return new Pais(nome);
    }
}
