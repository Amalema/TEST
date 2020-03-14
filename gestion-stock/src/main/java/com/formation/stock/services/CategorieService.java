package com.formation.stock.services;

import java.util.List;

import com.formation.stock.dto.MessageDto;
import com.formation.stock.entities.Categorie;

public interface CategorieService {

	public MessageDto save(Categorie categorie);
	public MessageDto update(Categorie categorie);
	public MessageDto delete(Integer idCategorie);
	public List<Categorie> findAll();
	public Categorie findById(Integer idCategorie);
}
