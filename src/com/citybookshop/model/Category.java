package com.citybookshop.model;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;

    // getters
    public int getCategoryId(){
        return categoryId;
    }
    public String getCategoryName(){
        return categoryName;
    }
    public String getDescription(){
        return description;
    }

    // setters
    public void setCategoryId(int categoryId){
        this.categoryId=categoryId;
    }
    public void setCategoryName(String categoryName){
        this.categoryName=categoryName;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getDetails(){
        return "Category ID: "+categoryId+"\nCategory Name: "+categoryName+"\nDescription: "+description;
    }

}
