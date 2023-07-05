package com.techno.web.jdbc;

public class Product {

	private int productId;
	private String name;
	private String description;
	private double price;
	private String brand;

	public Product() {
		name = "";
		description ="";
		price =0.0;
		brand ="";
	}

	public Product(String name, String description, double price, String brand) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
	}

	public Product(int productId, String name, String description, double price, String brand) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId=" + productId +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", brand='" + brand + '\'' +
				'}';
	}
}
