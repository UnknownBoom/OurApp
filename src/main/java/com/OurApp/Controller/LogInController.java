package com.OurApp.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;


import com.OurApp.InitApp.Connect_Statement;
import com.OurApp.InitApp.IConnect_Statement;
import com.OurApp.InitApp.javaFxLaunch;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class LogInController {


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
    private ImageView UserIcon;

    @FXML
    private ImageView PasswordIcon;

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
    } catch (SQLException ignored) {

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
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("View\\LogIn.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ioException) {
            ErrorLabel.setText("---Error Open Db Form---");
        }

    }

    @FXML
    void initialize() {

        CloseLogIn.setOnMouseClicked(e-> closeApp());

        LoginButton.setOnMouseClicked(e->{

            if(!DbNameField.getText().trim().equals("") & !LoginField.getText().trim().equals("") & !PasswordField.getText().trim().equals("")){

                connect_Statement.initConnect(DbNameField.getText().trim(), LoginField.getText().trim(),PasswordField.getText().trim());
                ErrorLabel.setTextFill(Color.WHITE);
                ErrorLabel.setText("Sucsess rederection...");
                OpenDb(e);
            }
            else{
                ErrorLabel.setTextFill(Color.TOMATO);
                ErrorLabel.setText("Error");
            }
        });

    }


}
