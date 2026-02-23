package com.citybookshop.controller;

import com.citybookshop.model.User;
import com.citybookshop.service.BookService;
import com.citybookshop.service.CategoryService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML private Button viewBooks;
    @FXML private Button searchBooks;
    @FXML private Button viewStocks;
    @FXML private Button addBook;
    @FXML private Button addCategory;
    @FXML private Button logout;

    @FXML private Label totalBooksLabel;
    @FXML private Label totalCategoriesLabel;
    @FXML private Label stocksLabel;
    @FXML private Label welcomeLabel;

    private User loggedInUser;

    public void setUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        if (loggedInUser != null) {
            welcomeLabel.setText("Welcome, " + loggedInUser.getUsername());
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BookService bookService = new BookService();
        CategoryService categoryService = new CategoryService();

        int totalBooks = bookService.getAllBooks().size();
        totalBooksLabel.setText(" "+totalBooks);

        int totalCategories = categoryService.getAllCategory().size();
        totalCategoriesLabel.setText(" "+totalCategories);

        int totalStocks = bookService.getAllBooks().stream().mapToInt(book -> book.getQuantity()).sum();
        stocksLabel.setText(" "+totalStocks);

        if (loggedInUser != null) {
            welcomeLabel.setText("Welcome, " + loggedInUser.getUsername());
        }
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
