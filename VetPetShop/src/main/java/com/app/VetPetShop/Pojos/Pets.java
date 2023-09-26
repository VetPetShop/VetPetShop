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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Pets")
public class Pets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "breedId", nullable = false, referencedColumnName = "petBreedId")
	private PetBreed breedId;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellerId", nullable = false, referencedColumnName = "sellerId")
	private Sellers sellerId;
	
	@OneToMany(mappedBy = "petId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItems> items = new ArrayList<CartItems>();
	
	@Column(nullable = false)
	private int petAge;
	
	@Column(nullable = false)
	private char gender;
	
	@Column(nullable = false)
	private double height;
	
	@Column(nullable = false)
	private double weight;
	
	@Column(nullable = false)
	private String petColour;
	
	@Column(columnDefinition = "TEXT")
	private String medicalDetails;
	
	@Column(nullable = false)
	private double price;
	
	@Lob
	private String petImages;

	public Pets(String description, int petAge, char gender, double height, double weight, String petColour,
			String medicalDetails, double price) {
		super();
		this.description = description;
		this.petAge = petAge;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.petColour = petColour;
		this.medicalDetails = medicalDetails;
		this.price = price;
	}

	public Pets() {
		super();
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public PetBreed getBreedId() {
		return breedId;
	}

	public void setBreedId(PetBreed breedId) {
		this.breedId = breedId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Sellers getSellerId() {
		return sellerId;
	}

	public void setSellerId(Sellers sellerId) {
		this.sellerId = sellerId;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPetColour() {
		return petColour;
	}

	public void setPetColour(String petColour) {
		this.petColour = petColour;
	}

	public String getMedicalDetails() {
		return medicalDetails;
	}

	public void setMedicalDetails(String medicalDetails) {
		this.medicalDetails = medicalDetails;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPetImages() {
		return petImages;
	}

	public void setPetImages(String petImages) {
		this.petImages = petImages;
	}

	public List<CartItems> getItems() {
		return items;
	}

	public void setItems(List<CartItems> items) {
		this.items = items;
	}

	
	@Override
	public String toString() {
		return "Pets [petId=" + petId + ", breedId=" + breedId + ", description=" + description + ", sellerId="
				+ sellerId + ", items=" + items + ", petAge=" + petAge + ", gender=" + gender + ", height=" + height
				+ ", weight=" + weight + ", petColour=" + petColour + ", medicalDetails=" + medicalDetails + ", price="
				+ price + ", petImages=" + petImages + "]";
	}

}
