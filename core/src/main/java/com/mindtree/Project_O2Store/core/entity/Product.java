package com.mindtree.Project_O2Store.core.entity;

public class Product {

	private int productId;
	private String productName;
	private String productDisplayName;
	private int price;
	private String pdpLink;

	public Product() {
		super();
	}

	public Product(int productId, String productName, String productDisplayName, int price, String pdpLink) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDisplayName = productDisplayName;
		this.price = price;
		this.pdpLink = pdpLink;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDisplayName() {
		return productDisplayName;
	}

	public void setProductDisplayName(String productDisplayName) {
		this.productDisplayName = productDisplayName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getPdpLink() {
		return pdpLink;
	}

	public void setPdpLink(String pdpLink) {
		this.pdpLink = pdpLink;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDisplayName="
				+ productDisplayName + ", price=" + price + ", pdpLink=" + pdpLink + "]";
	}

}
