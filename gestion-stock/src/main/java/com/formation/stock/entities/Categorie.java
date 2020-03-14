package com.formation.stock.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer idCategorie;
private String libelle;

@JsonIgnore
@OneToMany(mappedBy = "categorie")
private List<Produit> produits;

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Categorie other = (Categorie) obj;
	if (idCategorie == null) {
		if (other.idCategorie != null)
			return false;
	} else if (!idCategorie.equals(other.idCategorie))
		return false;
	if (libelle == null) {
		if (other.libelle != null)
			return false;
	} else if (!libelle.equals(other.libelle))
		return false;
	if (produits == null) {
		if (other.produits != null)
			return false;
	} else if (!produits.equals(other.produits))
		return false;
	return true;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((idCategorie == null) ? 0 : idCategorie.hashCode());
	result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
	result = prime * result + ((produits == null) ? 0 : produits.hashCode());
	return result;
}


}
