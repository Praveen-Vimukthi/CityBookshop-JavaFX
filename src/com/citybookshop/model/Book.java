package com.citybookshop.model;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private Category category;

    // getters
    public int getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public Category getCategory(){
        return category;
    }

    // setters
    public void setBookId(int bookId){
        this.bookId=bookId;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public void setCategory(Category category){
        this.category=category;
    }

    public String getDetails(){
        return "BookID: "+bookId+"\nBook Title: "+title+"\nBook Author: "+author+"\nBook Price: "+price+"\nCategory Belongs to: "+category;
    }

    public String toFileString(){
        // has to complete this , save to file
        return "";
    }
}
