package com.formation.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.stock.dto.MessageDto;
import com.formation.stock.entities.Categorie;
import com.formation.stock.entities.Produit;
import com.formation.stock.repositories.ProduitRepository;
import com.formation.stock.services.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Override
	public MessageDto save(Produit produit) {
		// TODO Auto-generated method stub
		boolean exist = produitRepository.existsById(produit.getReference());
		if (exist)
			return new MessageDto(false, "Reference existe déja");
		produitRepository.save(produit);
		return new MessageDto(true, "operation effectuee avec success");
	}

	@Override
	public MessageDto update(Produit produit) {   // si je veux faire que l'id ne change pas qu'est ce que je dois faire
		// TODO Auto-generated method stub
		boolean exist = produitRepository.existsByLibelle(produit.getLibelle());
		if (exist)
			return new MessageDto(false, "Libelle existe déja");
		produitRepository.save(produit);
		return new MessageDto(true, "operation effectuee avec success");
	}

	@Override
	public MessageDto delete(String reference) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(reference);
		return new MessageDto(true, "operation effectuee avec success");
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}

	@Override
	public Produit findById(String reference) {
		// TODO Auto-generated method stub
		return produitRepository.findById(reference).orElse(null);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return produitRepository.findByCategorie(categorie);
	}


}
