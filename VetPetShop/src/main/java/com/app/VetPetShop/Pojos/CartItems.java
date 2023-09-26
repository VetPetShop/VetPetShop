package com.app.VetPetShop.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CartItems")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	@ManyToOne
	@JoinColumn(name = "cartId", referencedColumnName = "cartId")
	private Cart cartId;
	
	@ManyToOne
	@JoinColumn(name = "petId", referencedColumnName = "petId")
	private Pets petId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderId", referencedColumnName = "orderId")
	private Orders orderId;
	
	@Column
	private int quantity;

	public CartItems(int quantity) {
		super();
		this.quantity = quantity;
	}

	public CartItems() {
		super();
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Cart getCartId() {
		return cartId;
	}

	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}

	public Pets getPetId() {
		return petId;
	}

	public void setPetId(Pets petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItems [itemId=" + itemId + ", cartId=" + cartId + ", petId=" + petId + ", quantity=" + quantity
				+ "]";
	}

}
