package com.citybookshop.model;

public class Category {
    private String categoryId;
    private String categoryName;
    private String description;

    public Category(String categoryId,String categoryName,String description){
        setCategoryId(categoryId);
        setCategoryName(categoryName);
        setDescription(description);
    }
    // getters
    public String getCategoryId(){
        return categoryId;
    }
    public String getCategoryName(){
        return categoryName;
    }
    public String getDescription(){
        return description;
    }

    // setters
    public void setCategoryId(String categoryId){
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
