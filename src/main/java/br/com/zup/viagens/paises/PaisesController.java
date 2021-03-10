package br.com.zup.viagens.paises;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;


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
    public ResponseEntity<?> listaPais(@PathVariable("id") Long id) {


       Optional<Pais> pais = Optional.ofNullable(manager.find(Pais.class, id));
       if(pais.isEmpty()){
           return ResponseStatus(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.ok(new NovoPaisResponseDto(pais));

    }
