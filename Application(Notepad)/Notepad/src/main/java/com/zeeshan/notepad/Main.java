package com.zeeshan.notepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Main extends Application {

    public void start1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("theme.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Notepad");

        FileInputStream i=new FileInputStream("Data\\file.view.logo");
        stage.getIcons().add(new Image(i));

        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("theme.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Notepad");

        FileInputStream i=new FileInputStream("Data\\file.view.logo");
        stage.getIcons().add(new Image(i));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}