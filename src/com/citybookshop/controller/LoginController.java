package com.citybookshop.controller;

import com.citybookshop.model.User;
import com.citybookshop.service.UserService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;
    @FXML private Button loginButton;
    private UserService userService;

    @FXML
    public void initialize(){
        userService = new UserService();
        errorLabel.setText("");
    }
    @FXML
    public void handleLogin() throws IOException {
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

    private void loadDashboard(User loggedInUser) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/citybookshop/view/Dashboard.fxml"));
        Parent root=loader.load();
        DashboardController dController=loader.getController();
        dController.setUser(loggedInUser);
        Stage stage=(Stage) loginButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
