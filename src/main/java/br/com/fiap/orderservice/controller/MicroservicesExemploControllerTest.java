package br.com.fiap.orderservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.com.fiap.orderservice.Order;

@RunWith(SpringRunner.class)
@WebMvcTest(MicroservicesExemploController.class)
public class MicroservicesExemploControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private Order repository;
	
	@Test
	public void notFoundOrder() throws Exception {
		mvc.perform(
                get("/findById/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

	}
	
}
