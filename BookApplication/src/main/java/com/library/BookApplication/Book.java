package com.library.BookApplication;

public class Book {

    private int id;
    private String BookTitle;
    private String AuthorName;
    private String Category;
    private int Price;

    public Book(String BookTitle, String AuthorName, String Category, int Price) {
        this.BookTitle = BookTitle;
        this.AuthorName = AuthorName;
        this.Category = Category;
        this.Price = Price;
    }

    public Book(int id, String BookTitle, String AuthorName, String Category, int Price) {
        this.id = id;
        this.BookTitle = BookTitle;
        this.AuthorName = AuthorName;
        this.Category = Category;
        this.Price = Price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", BookTitle=" + BookTitle + ", AuthorName=" + AuthorName + ", Category=" + Category + ", Price=" + Price + "]";
    }
}

