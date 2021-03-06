package com.OurApp.Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;


import com.OurApp.Controller.Coonect_And_Statement.Connect_Statement;
import com.OurApp.Controller.Coonect_And_Statement.IConnect_Statement;
import com.OurApp.Controller.JavaFxInit.javaFxLaunch;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class LogInController {
    private double xOffset,yOffset;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane MainPane;

    @FXML
    private Label LoginLabel;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button LoginButton;
    @FXML
    private Label ErrorLabel;
    @FXML
    private ImageView CloseLogIn;
    @FXML
    private TextField DbNameField;

    private IConnect_Statement connect_Statement = Connect_Statement.getInstance();

    public void closeApp(){
        try {
        if(connect_Statement.getConnection()!=null){
            connect_Statement.getConnection().close();
        }
    } catch (Exception throwables) {
            System.out.println("\n" + Arrays.toString(throwables.getStackTrace()));
            System.out.println(throwables.getMessage());

    }finally {
            javaFxLaunch.get_primaryStage().close();
        }
    }

    private void OpenDb(Event e){
        try {

            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Parent root;
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("View\\Db.fxml")));
            root.setOnMousePressed(event->{ xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            });
            root.setOnMouseDragged(event->{
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            });

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception throwables) {
            System.out.println(throwables.getMessage());
            System.out.println("LogInController OpenDb");
        }

    }

    private void chekLogin(Event e){

            if(!DbNameField.getText().trim().equals("") & !LoginField.getText().trim().equals("")
                    & !PasswordField.getText().trim().equals("")){
                try{
                    connect_Statement.initConnect(DbNameField.getText().trim(), LoginField.getText().trim(),PasswordField.getText().trim());
                        ErrorLabel.setTextFill(Color.WHITE);
                        ErrorLabel.setText("Sucsess, rederection...");
                        OpenDb(e);
                    } catch (SQLException throwables) {
                    ErrorLabel.setTextFill(Color.TOMATO);
                    ErrorLabel.setText("Access denied");
                    System.out.println(throwables.getMessage());
                    System.out.println("LogInController Checklogin");
                }
            }
            else{
                ErrorLabel.setTextFill(Color.TOMATO);
                ErrorLabel.setText("Fill all field");
            }
    }

    @FXML
    void initialize() {
        CloseLogIn.setOnMouseClicked(e-> closeApp());
        MainPane.setOnKeyPressed(keyEvent -> {
           if(keyEvent.getCode() == KeyCode.ENTER) chekLogin(keyEvent); });
        LoginButton.setOnMouseClicked(this::chekLogin);

    }
}
