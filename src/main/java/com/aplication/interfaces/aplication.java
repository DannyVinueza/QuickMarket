package com.aplication.interfaces;

import com.aplication.interfaces.conexionBaseDatos.conexion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class aplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(aplication.class.getResource("pantallaLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 420);
        stage.setTitle("QuickMarket");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //Connection conBD = conexion.conecionBD();
        launch();
    }
}