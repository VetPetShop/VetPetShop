package com.app.VetPetShop.DTO;

public class CartItemsDto {
	
	private Long itemId;
	
	private Long cartId;
	
	private Long petId;
	
	private int quantity;

	public CartItemsDto(Long itemId, Long cartId, Long petId, int quantity) {
		super();
		this.itemId = itemId;
		this.cartId = cartId;
		this.petId = petId;
		this.quantity = quantity;
	}

	public CartItemsDto() {
		super();
	}



	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
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
		return "CartItemsDto [itemId=" + itemId + ", cartId=" + cartId + ", petId=" + petId + ", quantity=" + quantity
				+ "]";
	}

}
