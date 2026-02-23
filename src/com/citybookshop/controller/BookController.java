package com.citybookshop.controller;

import com.citybookshop.model.Book;
import com.citybookshop.service.BookService;
import com.citybookshop.service.CategoryService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BookController {
    @FXML private TableView<Book> bookTable;
    @FXML private TableColumn<Book, String> idCol;
    @FXML private TableColumn<Book, String> titleCol;
    @FXML private TableColumn<Book, String> authorCol;
    @FXML private TableColumn<Book, Double> priceCol;
    @FXML private TableColumn<Book, Integer> quantityCol;
    @FXML private TableColumn<Book, String> categoryCol;
    @FXML private ComboBox<String> categoryCombo;
    @FXML private TextField titleField;
    @FXML private TextField minPriceField;
    @FXML private TextField maxPriceField;
    @FXML private Button searchButton;
    @FXML private Button clearButton;
    @FXML private Button backButton;
    @FXML private Button logout;
    @FXML private Button viewBooks;
    @FXML private Button searchBooks;
    @FXML private Button viewStocks;
    @FXML private Label resultLabel;

    private BookService bookService;
    private CategoryService categoryService;
    private ObservableList<Book> books;

    @FXML
    public void initialize() {
        bookService = new BookService();
        categoryService = new CategoryService();
        setUpTable();
        loadBooks();
        populateCategories();
    }

    private void setUpTable() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
    }

    private void loadBooks() {
        books = FXCollections.observableArrayList(bookService.getAllBooks());
        bookTable.setItems(books);
        resultLabel.setText("Total books: " + books.size());
    }

    private void populateCategories() {
        List<String> categories = categoryService.getCategoryName();
        categories.add(0, "All");
        categoryCombo.setItems(FXCollections.observableArrayList(categories));
        categoryCombo.setValue("All");
    }

    @FXML
    private void handleSearch() {
        String title = titleField.getText().trim();
        String category = categoryCombo.getValue();
        double minPrice = 0;
        double maxPrice = Double.MAX_VALUE;
        try {
            if (!minPriceField.getText().isEmpty()) {
                minPrice = Double.parseDouble(minPriceField.getText());
            }
            if (!maxPriceField.getText().isEmpty()) {
                maxPrice = Double.parseDouble(maxPriceField.getText());
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid price range");
            return;
        }
        double finalMinPrice = minPrice;
        double finalMaxPrice = maxPrice;
        List<Book> filtered = bookService.getAllBooks().stream()
                .filter(b -> title.isEmpty() || b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(b -> "All".equals(category) || b.getCategoryName().equals(category))
                .filter(b -> b.getPrice() >= finalMinPrice && b.getPrice() <= finalMaxPrice)
                .collect(Collectors.toList());
        books.setAll(filtered);
        resultLabel.setText("Found " + filtered.size() + " books");
    }

    @FXML
    private void handleClear() {
        titleField.clear();
        minPriceField.clear();
        maxPriceField.clear();
        categoryCombo.setValue("All");
        loadBooks();
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

    @FXML
    private void handleLogout() throws IOException {
        loadView("/com/citybookshop/view/Login.fxml");
    }

    @FXML
    private void handleViewBooks() throws IOException {
        // Already in Book view, perhaps reload
        loadBooks();
    }

    @FXML
    private void handleSearchBooks() throws IOException {
        // Same as viewBooks
        loadBooks();
    }

    @FXML
    private void handleViewStocks() throws IOException {
        loadView("/com/citybookshop/view/Stock.fxml");
    }

    private void loadView(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}