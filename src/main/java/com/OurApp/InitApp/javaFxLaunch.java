package com.OurApp.InitApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Objects;
public class javaFxLaunch  extends Application {


    private double xOffset,yOffset;
    private static  Stage _primaryStage;




    public static Stage get_primaryStage() {
        return _primaryStage;
    }

     public  void Launch(){
         Application.launch();
     }

    @Override
    public void start(Stage primaryStage) throws Exception {
         //PATH HERE!!
        _primaryStage = primaryStage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("View\\LogIn.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(event->{ xOffset = primaryStage.getX() - event.getScreenX();
            yOffset = primaryStage.getY() - event.getScreenY();
        });
        root.setOnMouseDragged(event->{
            primaryStage.setX(event.getScreenX() + xOffset);
            primaryStage.setY(event.getScreenY() + yOffset);
        });

        primaryStage.show();
    }

}
