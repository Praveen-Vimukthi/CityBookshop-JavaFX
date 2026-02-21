package com.citybookshop.model;

public class Manager extends User{
    public Manager(String userId,String username,String password){
        super(userId,username,password,"Manager");
    }
    public boolean login(){
        return true;
    }
    public String getDetails(){
        return "UserID: "+super.getUserId()+"\nUsername: "+super.getUsername()+"\nRole: "+super.getRole();
    }
}
