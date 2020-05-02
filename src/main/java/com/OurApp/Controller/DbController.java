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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class DbController {
    Unity unity = Unity.getInstance();
    IConnect_Statement connect_statement = Connect_Statement.getInstance();
    ISqlQuery sqlQuery = SqlQuery.getInstance();
    private int rows_returned;

    private double xOffset,yOffset;
    private static  Stage _primaryStage;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tooltip LabelToolTip;

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
               LabelToolTip.setText(DynamicErrorLabel.getText().trim());
               }
           else{
               DynamicErrorLabel.setTextFill(Color.BLUE);
               DynamicErrorLabel.setText(connect_statement.getStatement().getUpdateCount() + " row(s) affected | " + connect_statement.getStatement().getQueryTimeout() + " sec");
               LabelToolTip.setText(DynamicErrorLabel.getText().trim());
           }
       } catch (Exception throwables) {

           System.out.println(throwables.getMessage());
           System.out.println("DbController DynamicHandler");
           DynamicErrorLabel.setTextFill(Color.TOMATO);
           DynamicErrorLabel.setText(throwables.getMessage());
           LabelToolTip.setText(DynamicErrorLabel.getText().trim());
       }
    }
    private void rollApp(MouseEvent e){
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);
    }


    @FXML
    void initialize() {

        LabelToolTip.setShowDelay(Duration.seconds(1));

        Alert infoAlert = new Alert(Alert.AlertType.NONE);
        DialogPane dialogPane = infoAlert.getDialogPane();
        dialogPane.getStylesheets().add("style.css");
        dialogPane.getStyleClass().add("alertMessage");
        Stage stage = (Stage) infoAlert.getDialogPane().getScene().getWindow();
        ButtonType closeAlert =  new ButtonType("Close");
        infoAlert.setGraphic(new ImageView("Image\\info.png"));
        infoAlert.getButtonTypes().add(closeAlert);
        //Moving ALERT
        dialogPane.setOnMousePressed(event->{ xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });
        dialogPane.setOnMouseDragged(event->{
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });
        infoAlert.initStyle(StageStyle.UNDECORATED);


        //info Alert
        infoAlert.setHeaderText("App information"); // THIS IS TITLE
        infoAlert.setContentText("PUT YOUT TEXT HERE"); // THIS IS BODY


        notes.setOnMouseClicked(e->infoAlert.showAndWait());

        Roll.setOnMouseClicked(this:: rollApp);
        Binding();
        BClose.setOnMouseClicked(e-> closeApp());
        DynamicExecute.setOnMouseClicked(e-> DynamicHandler(Dynamic_Field.getText().trim().toLowerCase()));


    }

}

