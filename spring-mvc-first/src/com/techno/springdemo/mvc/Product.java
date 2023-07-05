package com.techno.springdemo.mvc;


import java.util.Arrays;
import java.util.LinkedHashMap;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;

    private String feedback[];
    private String category;

    private String favoriteBrand;

    private String[] categories;

    private LinkedHashMap<String,String> favoriteBrandsOptions;

    public Product() {
        favoriteBrandsOptions = new LinkedHashMap<String,String>();
        favoriteBrandsOptions.put("Coke", "Coca Cola");
        favoriteBrandsOptions.put("Nestle", "Nestle Milkpak");
        favoriteBrandsOptions.put("Lever Brothers", "Dalda Lever Brothers");
        favoriteBrandsOptions.put("Lipton", "Lipton Yellow Label");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", categories=" + Arrays.toString(categories) +
                ", favoriteBrandsOptions=" + favoriteBrandsOptions +
                '}';
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public LinkedHashMap<String, String> getFavoriteBrandsOptions() {
        return favoriteBrandsOptions;
    }

    public void setFavoriteBrandsOptions(LinkedHashMap<String, String> favoriteBrandsOptions) {
        this.favoriteBrandsOptions = favoriteBrandsOptions;
    }

    public String getFavoriteBrand() {
        return favoriteBrand;
    }

    public void setFavoriteBrand(String favoriteBrand) {
        this.favoriteBrand = favoriteBrand;
    }

    public String[] getFeedback() {
        return feedback;
    }

    public void setFeedback(String[] feedback) {
        this.feedback = feedback;
    }
}
