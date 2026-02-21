package com.citybookshop.controller;

import com.citybookshop.model.User;
import com.citybookshop.service.UserService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private UserService userService;

    @FXML
    public void initialize(){
        userService = new UserService();
        errorLabel.setText("");
    }
    @FXML
    public void handleLogin(){
        String username=usernameField.getText();
        String password=passwordField.getText();

        if(username.isEmpty() || password.isEmpty()){
            errorLabel.setText("Please Enter Username or Password");
            return;
        }
        User loggedInUser=userService.login(username,password);
        if(loggedInUser!=null){
            loadDashboard(loggedInUser);
        }else{
            errorLabel.setText("Invalid username or password");
            passwordField.clear();
        }
    }

    private void loadDashboard(User loggedInUser) {

    }
}
