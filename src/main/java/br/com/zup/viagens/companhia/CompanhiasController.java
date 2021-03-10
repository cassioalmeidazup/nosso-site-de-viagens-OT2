package br.com.zup.viagens.companhia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RequestMapping("/api/companhias")
@RestController
public class CompanhiasController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    public ResponseEntity<?> criaCompanhia(@RequestBody @Valid NovaCompanhiaRequest novaCompanhiaRequest){
        Companhia companhia = novaCompanhiaRequest.toModel(entityManager);
    }
}
