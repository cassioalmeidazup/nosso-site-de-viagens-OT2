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
    @Column(updatable = false)
    private LocalDateTime criadoEm;

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
        this.criadoEm = LocalDateTime.now();
    }

    @Deprecated
    protected Companhia() {
    }

    public Long getId() {
        return this.id;
    }
}
