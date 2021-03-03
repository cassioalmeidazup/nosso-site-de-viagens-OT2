package br.com.zup.viagens.paises;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
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
