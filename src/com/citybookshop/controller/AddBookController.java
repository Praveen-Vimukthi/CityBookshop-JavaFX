package com.citybookshop.controller;

import com.citybookshop.service.BookService;
import com.citybookshop.service.CategoryService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AddBookController {
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField priceField;
    @FXML private TextField quantityField;
    @FXML private ComboBox<String> categoryCombo;
    @FXML private Button addButton;
    @FXML private Button backButton;
    @FXML private Label messageLabel;

    private BookService bookService;
    private CategoryService categoryService;

    @FXML
    public void initialize() {
        bookService = new BookService();
        categoryService = new CategoryService();
        categoryCombo.setItems(FXCollections.observableArrayList(categoryService.getCategoryName()));
        messageLabel.setText("");
    }

    @FXML
    private void handleAdd() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String priceText = priceField.getText().trim();
        String quantityText = quantityField.getText().trim();
        String category = categoryCombo.getValue();

        if (title.isEmpty() || author.isEmpty() || priceText.isEmpty() || quantityText.isEmpty() || category == null) {
            messageLabel.setText("Please fill all fields.");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityText);
            if (price <= 0 || quantity <= 0) {
                messageLabel.setText("Price and quantity must be positive.");
                return;
            }
            boolean success = bookService.addBook(title, author, price, quantity, category);
            if (success) {
                messageLabel.setText("Book added successfully!");
                clearFields();
            } else {
                messageLabel.setText("Book with this title already exists.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid price or quantity.");
        }
    }

    private void clearFields() {
        titleField.clear();
        authorField.clear();
        priceField.clear();
        quantityField.clear();
        categoryCombo.setValue(null);
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
