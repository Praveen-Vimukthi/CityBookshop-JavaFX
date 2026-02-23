package com.citybookshop.controller;

import com.citybookshop.service.CategoryService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCategoryController {
    @FXML private TextField nameField;
    @FXML private TextArea descriptionArea;
    @FXML private Button addButton;
    @FXML private Button backButton;
    @FXML private Label messageLabel;

    private CategoryService categoryService;

    @FXML
    public void initialize() {
        categoryService = new CategoryService();
        messageLabel.setText("");
    }

    @FXML
    private void handleAdd() {
        String name = nameField.getText().trim();
        String description = descriptionArea.getText().trim();

        if (name.isEmpty() || description.isEmpty()) {
            messageLabel.setText("Please fill all fields.");
            return;
        }

        boolean success = categoryService.addCategory(name, description);
        if (success) {
            messageLabel.setText("Category added successfully!");
            clearFields();
        } else {
            messageLabel.setText("Category with this name already exists.");
        }
    }

    private void clearFields() {
        nameField.clear();
        descriptionArea.clear();
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
