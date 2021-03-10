package br.com.zup.viagens.paises;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

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

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public void listaPais(@PathVariable("id") Long id) {
        manager.find(Pais.class, id);
    }
}
