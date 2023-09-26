package com.app.VetPetShop.Pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	@OneToOne
	@JoinColumn(name = "userId",referencedColumnName = "userId")
	private Users userId;	
	
	@OneToMany(mappedBy = "cartId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartItems> items = new ArrayList<CartItems>();
	
	@Column
	private int totalItems;
	
	public Cart(int totalItems) {
		super();
		this.totalItems = totalItems;
	}

	public Cart() {
		super();
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public List<CartItems> getItems() {
		return items;
	}

	public void setItems(List<CartItems> items) {
		this.items = items;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public void addItem(CartItems item)
	{
		items.add(item);
		item.setCartId(this);
	}
	
	public void removeItem(CartItems item)
	{
		items.remove(item);
		item.setCartId(null);
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", items=" + items
				+ ", totalItems=" + totalItems + "]";
	}

}
