package com.app.VetPetShop.DTO;

public class NewSellerDto {

	private String gstNo;
	
	private String sellerPolicy;
	
	private Long sellerId;
	
	private int totalSales;

	public NewSellerDto(String gstNo, String sellerPolicy, Long sellerId, int totalSales) {
		super();
		this.gstNo = gstNo;
		this.sellerPolicy = sellerPolicy;
		this.sellerId = sellerId;
		this.totalSales = totalSales;
	}

	public NewSellerDto() {
		super();
	}

	public String getGstNo() {
		return gstNo;
	}

	public String getSellerPolicy() {
		return sellerPolicy;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public Long getSellerId() {
		return sellerId;
	}

	@Override
	public String toString() {
		return "NewSellerDto [gstNo=" + gstNo + ", sellerPolicy=" + sellerPolicy + ", sellerId=" + sellerId
				+ ", totalSales=" + totalSales + "]";
	}
	
}
