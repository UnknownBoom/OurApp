package com.OurApp.InitApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;
public class javaFxLaunch  extends Application {
     public  void Launch(){
         Application.launch();
     }

    @Override
    public void start(Stage stage) throws Exception {
         //PATH HERE!!
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("PutPathHere")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
