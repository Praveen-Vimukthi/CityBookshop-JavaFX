package com.citybookshop.model;

public class Cashier extends User{
    public Cashier(String userId,String username,String password){
        super(userId,username,password,"Cashier");
    }
    public boolean login(){
        return true;
    }
    public String getDetails(){
        return "UserID: "+super.getUserId()+"\nUsername: "+super.getUsername()+"\nRole: "+super.getRole();
    }

}
