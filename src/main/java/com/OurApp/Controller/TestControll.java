package com.OurApp.Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.OurApp.InitApp.Connect_Statement;
import com.OurApp.InitApp.javaFxLaunch;
import com.OurApp.Model.DbContext.Authors;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class TestControll {
    private Connect_Statement connect_statement = Connect_Statement.getInstance();
    @FXML
    private ImageView Roll;

    @FXML
    private ImageView BClose;


    @FXML
    private TextField AIdFielText;

    @FXML
    private TextField AFNameFiledText;

    @FXML
    private TextField ALNameFieldText;

    @FXML
    private TextField ALanfFieldText;

    @FXML
    private Label AErrorLabel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Authors> ATable;

    @FXML
    private TableColumn<Authors, Integer> AId;

    @FXML
    private TableColumn<Authors, String> AFN;

    @FXML
    private TableColumn<Authors, String> ALN;

    @FXML
    private TableColumn<Authors, String> AL;

    @FXML
    private ImageView AEx;

    @FXML
    private TextArea ATA;
    public void closeApp(){
        try {
            if(connect_statement.getConnection()!=null){
                connect_statement.getConnection().close();
            }
        } catch (Exception throwables) {
            System.out.println("\n" + Arrays.toString(throwables.getStackTrace()));
            System.out.println(throwables.getMessage());

        }finally {
            javaFxLaunch.get_primaryStage().close();
        }
    }

    @FXML
    void initialize() {
        BClose.setOnMouseClicked(e-> closeApp());



        ATable.setItems(Unity.getInstance().getObservableListForAuthors());
        AId.setCellValueFactory(e-> e.getValue()._idProperty().asObject());
        AFN.setCellValueFactory(e-> e.getValue()._f_nameProperty());
        ALN.setCellValueFactory(e-> e.getValue()._l_nameProperty());
        AL.setCellValueFactory(e-> e.getValue()._langProperty());
        Statement statement = connect_statement.getStatement();
        try {

            ResultSet resultSet = statement.executeQuery("select * from authors");
            while(resultSet.next()){
                Authors authors = Authors.newBuilder().setId(resultSet.getInt(1)).setF_Name(resultSet.getString(2))
                        .setL_Name(resultSet.getString(3)).setLang(resultSet.getString(4)).Build();
                Unity.getInstance().addObservableListForAuthors(authors);
            }
        } catch (Exception throwables) {
            System.out.println("\n" + Arrays.toString(throwables.getStackTrace()));
            System.out.println(throwables.getMessage());
        }


    }
}
