package com.book.bookstore.entity;

public class Book {
    protected String title;
    protected int id;
    protected float price;
    protected String author;
    public Book() {
    }
    public Book(int id, String author, String title, float price) {
        this(author, title, price);
        this.id = id;
    }
    public Book(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public Book(String author, String title, float price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public float getPrice() {
        return price;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
