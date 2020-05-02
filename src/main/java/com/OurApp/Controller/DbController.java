package com.OurApp.Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.*;
import com.OurApp.Controller.Coonect_And_Statement.IConnect_Statement;
import com.OurApp.Controller.ObservListAccess.Unity;
import com.OurApp.Controller.Sql.ISqlQuery;
import com.OurApp.Controller.Sql.SqlQuery;
import com.OurApp.Controller.Coonect_And_Statement.Connect_Statement;
import com.OurApp.Controller.JavaFxInit.javaFxLaunch;
import com.OurApp.Model.DbContext.Dynamic;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DbController {
    Unity unity = Unity.getInstance();
    IConnect_Statement connect_statement = Connect_Statement.getInstance();
    ISqlQuery sqlQuery = SqlQuery.getInstance();
    private int rows_returned;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView notes;

    @FXML
    private ImageView Roll;

    @FXML
    private ImageView BClose;

    @FXML
    private TableView<Dynamic> DynamicTable;

    @FXML
    private ImageView DynamicExecute;

    @FXML
    private TextArea Dynamic_Field;

    @FXML
    private Label DynamicErrorLabel;

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
    
    private void Binding(){
        //Dynnamic
        DynamicTable.setItems(unity.getObservableListForDynamic());
    }

    private void CreatePropertyForQuery(int size) throws Exception {
        unity.clearObservableListForDynamic();
        DynamicTable.getColumns().clear();
        ResultSet resultSet = connect_statement.getStatement().getResultSet();
        List<Dynamic> dynamics = new ArrayList<>();
        int z=0;
        while(resultSet.next()){
            rows_returned++;
            Dynamic dynamic = new Dynamic();
            dynamics.add(dynamic);
            for(int i=1;i<=size;i++) {
                dynamics.get(z).getSimpleStringProperty().add(new SimpleStringProperty(resultSet.getObject(i)==null?"null":resultSet.getObject(i).toString()));
            }
            unity.addObservableListForDynamic(dynamics.get(z));
            z++;
        }
    }
    private void CreateTableForQuery( List<String> columnNames){
        for(int i=0;i<columnNames.size();i++){
            TableColumn<Dynamic, String> tableColumn = new TableColumn<>(columnNames.get(i));
            int finalI = i;
            tableColumn.setCellValueFactory(v-> v.getValue().getSimpleStringProperty().get(finalI));
            DynamicTable.getColumns().add(tableColumn);
        }

    }

    void DynamicHandler(String sql){

       try{
           Boolean aBoolean = sqlQuery.ExecuteCommand(sql);
           if(aBoolean==null) throw new Exception("Null Answer");
           if(aBoolean){
               rows_returned=0;
               List<String> columnNames = sqlQuery.GetColumnNamesForQuery(connect_statement.getStatement().getResultSet().getMetaData());
               CreatePropertyForQuery(columnNames.size());
               CreateTableForQuery(columnNames);
               DynamicErrorLabel.setTextFill(Color.BLUE);
               DynamicErrorLabel.setText(rows_returned + " row(s) affected | " + connect_statement.getStatement().getQueryTimeout() + " sec");
               }
           else{
               DynamicErrorLabel.setTextFill(Color.BLUE);
               DynamicErrorLabel.setText(connect_statement.getStatement().getUpdateCount() + " row(s) affected | " + connect_statement.getStatement().getQueryTimeout() + " sec");
           }
       } catch (Exception throwables) {
           System.out.println(throwables.getMessage());
           System.out.println("DbController DynamicHandler");
           DynamicErrorLabel.setTextFill(Color.TOMATO);
           DynamicErrorLabel.setText(throwables.getMessage());
       }
    }
    private void rollApp(MouseEvent e){
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);
    }


    @FXML
    void initialize() {
        Roll.setOnMouseClicked(this:: rollApp);
        Binding();
        BClose.setOnMouseClicked(e-> closeApp());
        DynamicExecute.setOnMouseClicked(e-> DynamicHandler(Dynamic_Field.getText().trim().toLowerCase()));


    }

}

