package com.escolamusica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle("Escola de Música");
        mostrarLogin();
    }

    public static void mostrarLogin() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getResource("/com/escolamusica/fxml/Login.fxml")
        );
        Scene scene = new Scene(loader.load(), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void mostrarTela(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getResource("/com/escolamusica/fxml/" + fxml)
        );
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}