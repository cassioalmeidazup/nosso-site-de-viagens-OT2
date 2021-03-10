package br.com.zup.viagens.paises;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PaisesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;



    @Test
    void deveriaCriarNovoPais() throws Exception {

        ResultActions brasil = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/paises")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new NovoPaisRequest("Brasil")))

        ).andExpect(
                status().isCreated()
        );

        Query query  = entityManager.createQuery("select p from Pais p where p.nome = :nome");
        query.setParameter("nome", "Brasil");
        assertFalse(query.getResultList().isEmpty());
    }

}