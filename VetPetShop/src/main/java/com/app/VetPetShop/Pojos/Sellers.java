package com.app.VetPetShop.Pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Sellers")
public class Sellers implements Serializable {
	
	@Id
	private String gstNo;
	
	@OneToOne
	@JoinColumn(name = "sellerId",referencedColumnName = "userId")
	private Users sellerId;
	
	@Column(nullable = false)
	private String sellerPolicy;
	
	@Column
	private int totalSales;
	
	@OneToMany(mappedBy = "sellerId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pets> pets = new ArrayList<Pets>();

	public Sellers(String gstNo, String sellerPolicy, int totalSales) {
		super();
		this.gstNo = gstNo;
		this.sellerPolicy = sellerPolicy;
		this.totalSales = totalSales;
	}

	public Sellers() {
		super();
	}

//	public Sellers(Long id) {
//		this.sellerId = id;
//	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public Users getSellerId() {
		return sellerId;
	}

	public void setSellerId(Users sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerPolicy() {
		return sellerPolicy;
	}

	public void setSellerPolicy(String sellerPolicy) {
		this.sellerPolicy = sellerPolicy;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
	public List<Pets> getPets() {
		return pets;
	}

	public void setPets(List<Pets> pets) {
		this.pets = pets;
	}

	public void addPets(Pets pet)
	{
		pets.add(pet);
		pet.setSellerId(this);
	}
	
	public void removePets(Pets pet)
	{
		pets.remove(pet);
		pet.setSellerId(null);
	}

	@Override
	public String toString() {
		return "Sellers [gstNo=" + gstNo + ", sellerId=" + sellerId + ", sellerPolicy=" + sellerPolicy + ", totalSales="
				+ totalSales + ", pets=" + pets + "]";
	}

}
