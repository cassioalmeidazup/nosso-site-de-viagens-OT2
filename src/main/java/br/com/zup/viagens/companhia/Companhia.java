package br.com.zup.viagens.companhia;

import br.com.zup.viagens.paises.Pais;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @ManyToOne
    private Pais pais;
    private LocalDateTime localDateTime;

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
        this.localDateTime = LocalDateTime.now();
    }

    @Deprecated
    protected Companhia() {
    }
}
