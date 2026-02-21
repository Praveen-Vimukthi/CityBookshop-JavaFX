package com.citybookshop.service;
import com.citybookshop.model.Cashier;
import com.citybookshop.model.Manager;
import com.citybookshop.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String FILE_PATH="src/data/users.txt";
    private FileHandler fileHandler;
    public UserService(){
        fileHandler=new FileHandler();
    }
    public User login(String username,String password){
        List<String> lines=fileHandler.readline(FILE_PATH);
        for(String line : lines){
            String[] parts=line.split("\\|");
            if(parts.length==4){
                String fileUsername=parts[1];
                String filePassword=parts[2];
                String fileRole=parts[3];

                if(fileUsername.equals(username) && filePassword.equals(password)){
                    if(fileRole.equals("Manager")){
                        return new Manager(parts[0],parts[1],parts[2]);
                    }else{
                        return new Cashier(parts[0],parts[1],parts[2]);
                    }
                }
            }
        }
        return null;
    }
    public boolean createAccount(String username,String password,String role){
        if(userExists(username)){
            return false;
        }
        String newId=generateId();
        String newLine=newId+"|"+username+"|"+password+"|"+role;

        fileHandler.appendLine(FILE_PATH,newLine);

        return true;
    }

    private String generateId() {
        List<String> lines=fileHandler.readline(FILE_PATH);
        int count=lines.size()+1;
        return String.format("usr%03d",count);
    }

    private boolean userExists(String username) {
        List<String> lines=fileHandler.readline(FILE_PATH);
        for(String line:lines){
            String[] parts=line.split("\\|");
            if(parts.length==4 && parts[1].equals(username)){
                return true;
            }
        }
        return false;
    }
}
