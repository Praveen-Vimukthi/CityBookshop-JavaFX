package com.citybookshop.model;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private String categoryName;
    public Book(String bookId,String title,String author,double price,int quantity,String categoryName){
        setBookId(bookId);
        setTitle(title);
        setAuthor(author);
        setPrice(price);
        setQuantity(quantity);
        setCategoryName(categoryName);

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
    public String getCategoryName(){
        return categoryName;
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
    public void setCategoryName(String categoryName){
        this.categoryName=categoryName;
    }

    public String getDetails(){
        return "BookID: "+bookId+"\nBook Title: "+title+"\nBook Author: "+author+"\nBook Price: "+price+"\nCategory Belongs to: "+categoryName;
    }

    public String toFileString(){
        return bookId+"|"+title+"|"+author+"|"+price+"|"+quantity+"|"+categoryName;
    }
}
