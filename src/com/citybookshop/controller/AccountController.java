package com.citybookshop.controller;

import com.citybookshop.service.UserService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private ComboBox<String> roleCombo;
    @FXML private Button createButton;
    @FXML private Button backButton;
    @FXML private Label messageLabel;

    private UserService userService;

    @FXML
    public void initialize() {
        userService = new UserService();
        roleCombo.setItems(FXCollections.observableArrayList("Cashier", "Manager"));
        roleCombo.setValue("Cashier"); // default
        messageLabel.setText("");
    }

    @FXML
    private void handleCreate() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String role = roleCombo.getValue();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || role == null) {
            messageLabel.setText("Please fill all fields.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            messageLabel.setText("Passwords do not match.");
            return;
        }

        if (password.length() < 6) {
            messageLabel.setText("Password must be at least 6 characters.");
            return;
        }

        boolean success = userService.createAccount(username, password, role);
        if (success) {
            messageLabel.setText("Account created successfully!");
            clearFields();
        } else {
            messageLabel.setText("Username already exists.");
        }
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
        roleCombo.setValue("Cashier");
    }

    @FXML
    private void handleBack() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/citybookshop/view/Dashboard.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
