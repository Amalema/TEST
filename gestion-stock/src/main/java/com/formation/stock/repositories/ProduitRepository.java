package com.formation.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.formation.stock.entities.Categorie;
import com.formation.stock.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, String>{

	@Query("select p from Produit p where p.categorie.idCategorie = :idCategorie")
	public List<Produit> findByCategorie(@Param("idCategorie") Integer idCategorie);
	
	public List<Produit> findByCategorie(Categorie categorie);
	boolean existsByLibelle(String libelle);
}
