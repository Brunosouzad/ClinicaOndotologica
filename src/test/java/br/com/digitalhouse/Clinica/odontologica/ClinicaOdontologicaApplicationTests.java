package br.com.digitalhouse.Clinica.odontologica;

import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.clinica.CreateClinicaRequest;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.service.ClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class ClinicaOdontologicaApplicationTests {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@SpyBean
	private ClinicaService clinicaService;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(mvc);
	}

	@Test
	void dadoRegistrosNoBanco_quandoChamamosEndpointBuscarClinica_entaoRetornarRegistrosPaginados() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/v1/clinicas")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		this.mvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.totalElements", equalTo(1)))
				.andExpect(jsonPath("$", hasKey("size")));
	}


	@Test
	void dadaListaVazia_quandoChamamosEndpointBuscarClinicaCom5Elementos_entaoRetornarPaginaVaziaa() throws Exception {
		Pageable pageable = PageRequest.of(0, 10);

		Mockito.when(clinicaService.buscarTodasClinicas(pageable))
				.thenReturn(new PageImpl<>(List.of()));

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("/v1/clinicas")
				.param("page", "0")
				.param("size", "10")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		this.mvc.perform(request)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(0)))
				.andExpect(jsonPath("$.totalElements", equalTo(0)))
				.andExpect(jsonPath("$", hasKey("size")));
	}

	@Test
	void dadoUmObjetoValido_quandoChamamosCriarClinica_entaoRetornarObjetoMockado() throws Exception {
		CreateClinicaRequest game = Fixture.ClinicaFake.anyClinica();

		String gameAsJson = mapper.writeValueAsString(game);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("/v1/clinicas")
				.content(gameAsJson)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		this.mvc.perform(request)
				.andDo(print())
				.andExpect(status().isCreated());
	}

}
