module com.citybookshop {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.citybookshop.controller to javafx.fxml;  // Controllers must be opened
}