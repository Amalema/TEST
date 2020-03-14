package com.formation.stock;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formation.stock.controllers.CategorieController;
import com.formation.stock.dto.MessageDto;
import com.formation.stock.entities.Categorie;
import com.formation.stock.services.CategorieService;

@RunWith(SpringRunner.class)
@WebMvcTest(CategorieController.class)
//@SpringBootTest
//@ExtendWith(SpringExtension.class) 
public class CategorieControllerTest  {

	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategorieService categorieService;
	@Test
	public void findAllControllerTest() throws Exception {
		
		List listCategories = new ArrayList<>();
		listCategories.add(new Categorie(1, "categorietest1", null));
		listCategories.add(new Categorie(2, "categorietest2", null));
		listCategories.add(new Categorie(3, "categorietest3", null));  
		
		when(categorieService.findAll()).thenReturn(listCategories);
		
		mockMvc.perform(get("/categories")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				//.andExpect(jsonPath("$", hasSize(1)))
		
				.andExpect(jsonPath("$[0].libelle", is("categorietest1")));

	}
	@Test
	public void findByIdControllerTest() throws Exception {
		
		
		Categorie categorie = new Categorie(1, "categorietest", null);

		//when(categorieService.findById(1)).thenReturn(categorie);
		when(categorieService.findById(1)).thenReturn(categorie);
		//mockMvc.perform(get("/categories/{id}",1) .content(str))
		mockMvc.perform(get("/categories/{id}",1))
		.andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$").value(new Categorie(1, "categorietest", null)));

	}
	
	@Test
	public void createCategorie() throws Exception 
	{

		when(categorieService.save(new  Categorie(null, "categorietest", null))).thenReturn(new MessageDto(true, " ok"));
	
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/categories")
	      .content(asJsonString(new  Categorie(null, "categorietest", null)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isCreated())
	    .andExpect(jsonPath("$.success").value(true));
	}
	
	@Test
	public void updateCategorie() throws Exception 
	{

		when(categorieService.update(new  Categorie(2, "categorietest2", null))).thenReturn(new MessageDto(true, " ok"));
	
		mockMvc.perform( MockMvcRequestBuilders
	      .put("/categories")
	      .content(asJsonString(new  Categorie(2, "categorietest2", null)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	    .andExpect(jsonPath("$.success").value(true));
	}
	 
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
