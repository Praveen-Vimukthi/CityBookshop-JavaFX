package com.citybookshop.model;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private Category category;
    public Book(String bookId,String title,String author,double price,int quantity,String categoryName){
        setBookId(bookId);
        setTitle(title);
        setAuthor(author);
        setPrice(price);
        setQuantity(quantity);
        setCategory(categoryName);

    }
    // getters
    public String getBookId(){
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
    public String getCategoryName(){
        return category.getCategoryName();
    }
    // setters
    public void setBookId(String bookId){
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
    public void setCategory(String categoryName){
        this.category.setCategoryName(categoryName);
    }

    public String getDetails(){
        return "BookID: "+bookId+"\nBook Title: "+title+"\nBook Author: "+author+"\nBook Price: "+price+"\nCategory Belongs to: "+category;
    }

    public String toFileString(){
        // has to complete this , save to file
        return "";
    }
}
