package br.com.zup.viagens.companhia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/companhias")
public class CompanhiasController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    public ResponseEntity<?> criaCompanhia(@RequestBody @Valid NovaCompanhiaRequest novaCompanhiaRequest){
        Companhia companhia = novaCompanhiaRequest.toModel(entityManager);
        entityManager.persist(companhia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(companhia.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }
}
