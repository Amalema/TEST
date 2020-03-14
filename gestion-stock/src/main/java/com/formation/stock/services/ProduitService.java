package com.formation.stock.services;

import java.util.List;

import com.formation.stock.dto.MessageDto;
import com.formation.stock.entities.Categorie;
import com.formation.stock.entities.Produit;

public interface ProduitService {
	

	public MessageDto save(Produit produit);
	public MessageDto update(Produit produit);
	public MessageDto delete(String reference );
	public List<Produit> findAll();
	public Produit findById(String reference);
	public List<Produit> findByCategorie(Categorie categorie);

}
