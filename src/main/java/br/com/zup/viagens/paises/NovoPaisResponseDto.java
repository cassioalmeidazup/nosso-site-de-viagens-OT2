package br.com.zup.viagens.paises;

import java.util.Optional;

public class NovoPaisResponseDto {

    private String nome;

    public NovoPaisResponseDto(Pais pais) {
        this.nome = pais.getNome();
    }

    public String getNome() {
        return nome;
    }

}
