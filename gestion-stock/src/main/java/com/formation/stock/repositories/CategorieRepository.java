package com.formation.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.stock.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

	boolean existsByLibelle(String libelle);
	 // de meme pour methode findBy mais la différence dans le type de retour
	boolean existsByIdCategorieAndProduitsIsNotNull(Integer id); 

	

	


}

