module com.citybookshop {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.citybookshop;
    opens com.citybookshop to javafx.graphics;
}