package com.formation.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.formation.stock.services.CategorieService;

@RestController
@RequestMapping("/categories")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;

	@GetMapping
	public List<Categorie> findAll() {
	
	
		List<Categorie> list = categorieService.findAll();
	
		return  list;
	}

	@GetMapping("/{id}")
	public Categorie findById(@PathVariable("id") Integer id) {
		return categorieService.findById(id);
	}

//	@GetMapping("/find")
//	public Categorie findById(@RequestParam Integer id)
//	{
//		return categorieService.findById(id);
//	}

	@PostMapping
	public ResponseEntity<MessageDto> save(@RequestBody Categorie categorie) {
		MessageDto result = categorieService.save(categorie);
		return new ResponseEntity<MessageDto>(result, HttpStatus.CREATED);
	}
	
//	@PostMapping
//	public MessageDto save(@RequestBody Categorie categorie) {
//		MessageDto result = categorieService.save(categorie);
//		return result;
//	}
//	
	@PutMapping
	public MessageDto update(@RequestBody Categorie categorie)
	{
		return categorieService.update(categorie);
	}
	
	@DeleteMapping("/{id}")
	public MessageDto delete(@PathVariable("id") Integer idCategorie)
	{
		return categorieService.delete(idCategorie);
	}
}
