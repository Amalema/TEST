package com.formation.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.stock.dto.MessageDto;
import com.formation.stock.entities.Categorie;
import com.formation.stock.entities.Produit;
import com.formation.stock.services.ProduitService;

@RestController
@RequestMapping("/produits")
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	
	@GetMapping
	public List<Produit> findAll()
	{
		return produitService.findAll();
	}
	
	@GetMapping("/{id}")
	public Produit findByReference(@PathVariable("id")String reference)
	{
		return produitService.findById(reference);
	}

	@GetMapping("/findByCategorie/{categorie}")  //{idCategorie} is not enough here because i have @GetMapping("/{id}")
	public List<Produit> findByCategorie(@PathVariable("categorie")Categorie categorie)
	{
		return produitService.findByCategorie(categorie);
	}
	
	@PostMapping
	public MessageDto save(@RequestBody Produit produit)
	{
		return produitService.save(produit);
	}
	
	@PutMapping 
	public MessageDto update(@RequestBody Produit produit)
	{
		return produitService.update(produit);
	}

	@DeleteMapping("/{id}")
	public MessageDto delete(@PathVariable("id") String reference)
	{
		return produitService.delete(reference);
	}
}
