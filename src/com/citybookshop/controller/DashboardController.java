package com.citybookshop.controller;

import com.citybookshop.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML private Button viewBooks;
    @FXML private Button searchBooks;
    @FXML private Button viewStocks;
    @FXML private Button addBook;
    @FXML private Button addCategory;
    @FXML private Button logout;

    private User loggedInUser;

    public void setUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    @FXML
    private void handleViewBooks() throws IOException {
        loadView("/com/citybookshop/view/Book.fxml");
    }

    @FXML
    private void handleSearchBooks() throws IOException {
        loadView("/com/citybookshop/view/Book.fxml");
    }

    @FXML
    private void handleViewStocks() throws IOException {
        loadView("/com/citybookshop/view/Stock.fxml");
    }

    @FXML
    private void handleAddBook() throws IOException {
        loadView("/com/citybookshop/view/AddBook.fxml");
    }

    @FXML
    private void handleAddCategory() throws IOException {
        loadView("/com/citybookshop/view/AddCategory.fxml");
    }

    @FXML
    private void handleCreateAccount() throws IOException {
        loadView("/com/citybookshop/view/CreateAccount.fxml");
    }

    @FXML
    private void handleLogout() throws IOException {
        loadView("/com/citybookshop/view/Login.fxml");
    }

    private void loadView(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = (Stage) viewBooks.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
