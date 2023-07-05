package com.techno.products.entity;

public class ProductDetail {
    private int productDetailId;
    private double price;
    private String size;
    private Product product;

    public ProductDetail(int productDetailId, double price, String size, Product product) {
        this.productDetailId = productDetailId;
        this.price = price;
        this.size = size;
        this.product = product;
    }

    public ProductDetail(int productDetailId, double price, String size) {
        this.productDetailId = productDetailId;
        this.price = price;
        this.size = size;
    }

    public ProductDetail(double price, String size) {
        this.price = price;
        this.size = size;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setProduct(Product p){
        product = p;
    }
    public Product getProduct(){
        return product;
    }

}
