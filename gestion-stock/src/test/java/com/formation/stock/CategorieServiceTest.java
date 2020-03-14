package com.formation.stock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.formation.stock.dto.MessageDto;
import com.formation.stock.entities.Categorie;
import com.formation.stock.repositories.CategorieRepository;
import com.formation.stock.services.CategorieService;


@RunWith(SpringRunner.class)
@SpringBootTest 
public class CategorieServiceTest {
	
	@Autowired
	CategorieService categorieService;
	
	@MockBean
	CategorieRepository categorieRepository;
	
	@Test
	public void findAllTest() 
	{
		List listCategories = new ArrayList<>();
		listCategories.add(new Categorie(null, "categorietest1", null));
		listCategories.add(new Categorie(null, "categorietest2", null));
		listCategories.add(new Categorie(null, "categorietest3", null));  
		
		when(categorieRepository.findAll()).thenReturn(listCategories);
		assertEquals(3, categorieService.findAll().size());
	}
	
	@Test
	public void findByIdTest()     //ce test je dois le vérifier avec mourad
	{
		Categorie categorie = new Categorie(1, "categorie", null);
		when(categorieRepository.findById(1).orElse(null)).thenReturn(categorie);
		assertEquals("categorie", categorieService.findById(1).getLibelle());
	}
	
	
	@Test
	public void saveTest()   // hedha zeda
	{
		Categorie categorie = new Categorie(1, "categorietest1", null);
		when(categorieRepository.save(categorie)).thenReturn(categorie);
		assertEquals("operation effectuee avec success", categorieService.save(categorie).getMessage());
	}
	
	
	@Test
	public void updateTest()   // hedha zeda
	{
		Categorie categorie = new Categorie(1, "categorietest1", null);
		when(categorieRepository.save(categorie)).thenReturn(categorie);
		assertEquals("operation effectuee avec success", categorieService.update(new Categorie(1, "categorietest2", null)).getMessage());
	}
	

}
