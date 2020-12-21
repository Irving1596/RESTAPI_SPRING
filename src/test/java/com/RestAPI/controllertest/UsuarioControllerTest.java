package com.RestAPI.controllertest;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.RestAPI.model.Usuario;
import com.RestAPI.service.UsuarioService;
@RunWith(SpringRunner.class)
@WebMvcTest
@WithMockUser

class UsuarioControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsuarioService usuarioService;
	
	 String fecha="2015-03-31";  
	Date date=Date.valueOf(fecha);//converting string into sql date  
	
	Usuario mockUsuario = new Usuario(1,"Irving", "Sanchez", "M",24, "irving.sanchezp@up.ac.pa",date,"Irving",date,"Irving");

	String exampleCourseJson = "{\"id\":\"1\",\"nombre\":\"Irving\",\"apellido\":\"Sanchez\",\"sexo\":\"M\",\"edad\":\"24\",\"correo\":\"irving.sanchezp@up.ac.pa\",\"createdAt\":\"2015-03-31\",\"createdBy\":\"Irving\",\"updatedAt\":\"2015-03-31\",\"updatedBy\":\"Irving\"}";

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testList() throws Exception  {

		Mockito.when(
				usuarioService.listAllUser()).thenReturn(Lists.newArrayList(mockUsuario));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/v1/users").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{id:1,nombre:Irving,apellido:Sanchez}]";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
