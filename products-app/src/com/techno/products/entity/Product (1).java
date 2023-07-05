package com.techno.products.entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int productId;
    private String name;
    private String description;
    private String brand;

    private List<ProductDetail> productDetailList = new ArrayList<ProductDetail>();
    public Product() {
    }

    public Product(String name, String description, String brand) {
        this.name = name;
        this.description = description;
        this.brand = brand;
    }

    public Product(int productId, String name, String description, String brand) {
        this.productId = productId;
        this.name = name;
        this.description = description;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void addProductDetails(ProductDetail productDetail){
        productDetailList.add(productDetail);
    }
    public void removeProductDetails(ProductDetail productDetail){
        productDetailList.remove(productDetail);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
