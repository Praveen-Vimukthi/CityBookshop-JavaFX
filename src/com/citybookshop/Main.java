package com.citybookshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception {

        // Step 1 — Load the Login screen
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("view/Login.fxml")
        );

        // Step 2 — Create the scene with size
        Scene scene = new Scene(loader.load(), 700, 560);

        // Step 3 — Set up the window
        stage.setTitle("City Bookshop");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}