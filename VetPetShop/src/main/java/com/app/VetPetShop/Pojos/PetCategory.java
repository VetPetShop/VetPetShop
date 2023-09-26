package com.app.VetPetShop.Pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PetCategory")
public class PetCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petCategoryId;
	
	private String petCategory;
	
	@OneToMany(mappedBy = "petCategoryId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PetBreed> petbreed = new ArrayList<PetBreed>();

	public PetCategory(String petCategory) {
		super();
		this.petCategory = petCategory;
	}

	public PetCategory() {
		super();
	}

	public int getPetCategoryId() {
		return petCategoryId;
	}

	public void setPetCategoryId(int petCategoryId) {
		this.petCategoryId = petCategoryId;
	}

	public String getPetCategory() {
		return petCategory;
	}

	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}

	public List<PetBreed> getPetbreed() {
		return petbreed;
	}

	public void setPetbreed(List<PetBreed> petbreed) {
		this.petbreed = petbreed;
	}
	
	public void addPetBreed(PetBreed breed)
	{
		petbreed.add(breed);
		breed.setPetCategoryId(this);
	}
	
	public void removePetBreed(PetBreed breed)
	{
		petbreed.remove(breed);
		breed.setPetCategoryId(null);
	}

	@Override
	public String toString() {
		return "PetCategory [petCategoryId=" + petCategoryId + ", petCategory=" + petCategory + ", petbreed=" + petbreed
				+ "]";
	}

}
