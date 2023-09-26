package com.app.VetPetShop.Pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PetBreed")
public class PetBreed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petBreedId;
	
	@Column
	private String breedName;
	
	@Column(columnDefinition = "TEXT")
	private String breedDescription;
	
	@OneToMany(mappedBy = "breedId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pets> pets = new ArrayList<Pets>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "petCategoryId")
	private PetCategory petCategoryId;

	public PetBreed(String breedName, String breedDescription) {
		super();
		this.breedName = breedName;
		this.breedDescription = breedDescription;
	}

	public PetBreed() {
		super();
	}

	public int getPetBreedId() {
		return petBreedId;
	}

	public void setPetBreedId(int petBreedId) {
		this.petBreedId = petBreedId;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public String getBreedDescription() {
		return breedDescription;
	}

	public void setBreedDescription(String breedDescription) {
		this.breedDescription = breedDescription;
	}

	public List<Pets> getPets() {
		return pets;
	}

	public void setPets(List<Pets> pets) {
		this.pets = pets;
	}

	public PetCategory getPetCategoryId() {
		return petCategoryId;
	}

	public void setPetCategoryId(PetCategory petCategoryId) {
		this.petCategoryId = petCategoryId;
	}
	
	public void addPet(Pets pet) {
		pets.add(pet);
		pet.setBreedId(this);
	}
	
	public void removePet(Pets pet) {
		pets.remove(pet);
		pet.setBreedId(null);
	}

	@Override
	public String toString() {
		return "PetBreed [petBreedId=" + petBreedId + ", breedName=" + breedName + ", breedDescription="
				+ breedDescription + ", pets=" + pets + ", petCategoryId=" + petCategoryId + "]";
	}

}
