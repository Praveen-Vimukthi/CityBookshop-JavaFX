package com.citybookshop.model;

public class Cashier extends User{
    public Cashier(){
        super.setRole("Cashier");
    }
    public boolean login(){
        return true;
    }
    public String getDetails(){
        return "UserID: "+super.getUserId()+"\nUsername: "+super.getUsername()+"\nRole: "+super.getRole();
    }

}
