package com.formation.stock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.formation.stock.entities.Categorie;
import com.formation.stock.repositories.CategorieRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest    
//@DataJpaTest
@TestMethodOrder(OrderAnnotation.class) 
//@AutoConfigureTestDatabase(replace = Replace.NONE) par defaut true in @DataJpaTest
public class CategorieRepositoryTest {

	@Autowired
	CategorieRepository categorieRepository;

	@Order(1)
	@Test
	public void testAjoutCategory() {

		Categorie categorie = categorieRepository.save(new Categorie(null, "categorietest1", null));
		assertThat(categorie.getIdCategorie()).isNotNull();	
	}

	@Order(2)
	@Test
	public void testFindAllCategory() {

		List<Categorie> list = categorieRepository.findAll();
		assertThat(list).isNotEmpty();    //assertEqual
	}

	@Order(3)
	@Test
	public void testExistCategory() {

		boolean exist = categorieRepository.existsByLibelle("aa");
		// assertThat(list).isEmpty();
		assertFalse(exist);  
	}


	@Order(3)
	@Test
	public void testFindByIdCategory() {

		Optional<Categorie> categorie = categorieRepository.findById(1);
		assertThat(categorie).isNotNull();
		//assertFalse(exist);  
	}
}
