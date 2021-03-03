package br.com.zup.viagens.paises;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/paises")
public class PaisesController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    public String criaPais(@Valid @RequestBody NovoPaisRequest request){
        return request.toString();

    }
}
