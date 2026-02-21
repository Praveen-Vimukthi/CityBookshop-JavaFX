package com.citybookshop.model;

public class Manager extends User{
    public Manager(){
        super.setRole("Manager");
    }
    public boolean login(){
        return true;
    }
    public String getDetails(){
        return "UserID: "+super.getUserId()+"\nUsername: "+super.getUsername()+"\nRole: "+super.getRole();
    }
}
