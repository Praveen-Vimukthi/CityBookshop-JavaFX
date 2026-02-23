package com.citybookshop.controller;

import com.citybookshop.model.Book;
import com.citybookshop.service.BookService;
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

public class StockController {
    @FXML private TableView<Book> stockTable;
    @FXML private TableColumn<Book, String> idCol;
    @FXML private TableColumn<Book, String> titleCol;
    @FXML private TableColumn<Book, String> authorCol;
    @FXML private TableColumn<Book, Double> priceCol;
    @FXML private TableColumn<Book, Integer> quantityCol;
    @FXML private TableColumn<Book, String> categoryCol;
    @FXML private Button backButton;
    @FXML private Label resultLabel;

    private BookService bookService;
    private ObservableList<Book> lowStockBooks;

    @FXML
    public void initialize() {
        bookService = new BookService();
        setUpTable();
        loadLowStockBooks();
    }

    private void setUpTable() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
    }

    private void loadLowStockBooks() {
        List<Book> lowStock = bookService.getLowStock();
        lowStockBooks = FXCollections.observableArrayList(lowStock);
        stockTable.setItems(lowStockBooks);
        resultLabel.setText("Low stock books: " + lowStock.size());
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
