package com.formation.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.stock.dto.MessageDto;
import com.formation.stock.entities.Categorie;
import com.formation.stock.repositories.CategorieRepository;
import com.formation.stock.services.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService { 

	@Autowired
	CategorieRepository categorieRepository;
	@Override
	public MessageDto save(Categorie categorie) {
		 //TODO Auto-generated method stub
		boolean exist = categorieRepository.existsByLibelle(categorie.getLibelle());
		if (exist)
			return new MessageDto(false, "libelle existe déja");
		categorieRepository.save(categorie);
		return new MessageDto(true, "operation effectuee avec success");
	}

	@Override
	public MessageDto update(Categorie categorie) {
		boolean exist = categorieRepository.existsByLibelle(categorie.getLibelle());
		if (exist)
			return new MessageDto(false, "libelle existe déja");
		categorieRepository.save(categorie);
		return new MessageDto(true, "operation effectuee avec success");
	}

	@Override
	public MessageDto delete(Integer idCategorie) {
		boolean exist = categorieRepository.existsByIdCategorieAndProduitsIsNotNull(idCategorie);
		if (exist)
			return new MessageDto(false, "categorie déja associé à  des produits");
		categorieRepository.deleteById(idCategorie);
		return new MessageDto(true, "operation effectuee avec success");
	}

	@Override
	public List<Categorie> findAll() {
	
		List<Categorie> list = categorieRepository.findAll();
		
		return list; 
	}

	@Override
	public Categorie findById(Integer idCategorie) {
		// TODO Auto-generated method stub
		return categorieRepository.findById(idCategorie).orElse(null);
	}

}
