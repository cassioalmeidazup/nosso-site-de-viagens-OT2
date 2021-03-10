package br.com.zup.viagens.paises;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/paises")
public class PaisesController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> criaPais(@Valid @RequestBody NovoPaisRequest request, UriComponentsBuilder uriComponentsBuilder)  {

        Pais pais = request.toModel();
        manager.persist(pais);

        URI uri = uriComponentsBuilder.path("/api/paises/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
