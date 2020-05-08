package com.OurApp.Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

import com.OurApp.Controller.CellFactories.EditingCell;

import com.OurApp.Controller.Coonect_And_Statement.IConnect_Statement;
import com.OurApp.Controller.Unity.Unity;
import com.OurApp.Controller.Sql.ISqlQuery;
import com.OurApp.Controller.Sql.SqlQuery;
import com.OurApp.Controller.Coonect_And_Statement.Connect_Statement;
import com.OurApp.Controller.JavaFxInit.javaFxLaunch;
import com.OurApp.Model.DbContext.Dynamic;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;

public class DbController {
    Unity unity = Unity.getInstance();
    IConnect_Statement connect_statement = Connect_Statement.getInstance();
    ISqlQuery sqlQuery = SqlQuery.getInstance();
    ResultSetMetaData lastResult;
    Object oldValue;
    private int rows_returned;


    private double xOffset,yOffset;
    private static  Stage _primaryStage;

    @FXML
    private Label Title;

    @FXML
    private TabPane tabPanel;

    @FXML
    private Tab MainTab;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab testTab;

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

    private void rollApp(MouseEvent e){
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);
    }

    public void closeApp(){
        try {
            if(connect_statement.getConnection()!=null){
                connect_statement.getConnection().close();
            }
        } catch (Exception throwable) {
            System.out.println("\n" + Arrays.toString(throwable.getStackTrace()));
            System.out.println(throwable.getMessage());

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
        List<Dynamic> dynamicList = new ArrayList<>();
        int z=0;
        while(resultSet.next()){
            rows_returned++;
            Dynamic dynamic = new Dynamic();
            dynamicList.add(dynamic);
            for(int i=1;i<=size;i++) {
                dynamicList.get(z).getSimpleObjectProperties().add(new SimpleObjectProperty<>(resultSet.getObject(i)));
            }
            unity.addObservableListForDynamic(dynamicList.get(z));
            z++;
        }
    }

    private final Callback<TableColumn<Dynamic,Object>, TableCell<Dynamic,Object>> cellFactory =
            new Callback<TableColumn<Dynamic,Object>, TableCell<Dynamic,Object>>() {
                public TableCell call(TableColumn p) {
                    return new EditingCell();
                }
            };

    private void CreateColumnForQuery( List<String> columnNames){
        if(unity.getObservableListForDynamic().isEmpty()){
            for(int i=0;i<columnNames.size();i++){
                DynamicTable.getColumns().add(new TableColumn<>(columnNames.get(i)));
            }
        }
        else{
            Dynamic dynamic = (Dynamic)unity.getObservableListForDynamic().get(0);
            for(int i=0;i<columnNames.size();i++){
                int finalI = i;
                TableColumn<Dynamic,Object> tableColumn = new TableColumn(columnNames.get(i));;
                tableColumn.setCellValueFactory(v-> v.getValue().getSimpleObjectProperties().get(finalI));
                tableColumn.setOnEditCommit(e->sqlEditedHandler(e.getTablePosition().getColumn(),e.getTablePosition().getRow(),e.getRowValue(),e.getNewValue()));
                tableColumn.setCellFactory(cellFactory);
                tableColumn.setEditable(false);

                if(dynamic.getSimpleObjectProperties().get(i).getValue() instanceof Integer) tableColumn.setEditable(true);
                else if (dynamic.getSimpleObjectProperties().get(i).getValue() instanceof String) tableColumn.setEditable(true);
                else if (dynamic.getSimpleObjectProperties().get(i).getValue() instanceof Float) tableColumn.setEditable(true);
                else if (dynamic.getSimpleObjectProperties().get(i).getValue() instanceof Double) tableColumn.setEditable(true);
                else if (dynamic.getSimpleObjectProperties().get(i).getValue() instanceof Byte) tableColumn.setEditable(true);
                else if (dynamic.getSimpleObjectProperties().get(i).getValue() instanceof Long) tableColumn.setEditable(true);
                else if (dynamic.getSimpleObjectProperties().get(i).getValue() instanceof Short) tableColumn.setEditable(true);
                else if (dynamic.getSimpleObjectProperties().get(i).getValue() instanceof java.math.BigDecimal) tableColumn.setEditable(true);
                else if (dynamic.getSimpleObjectProperties().get(i).getValue() instanceof Boolean) tableColumn.setEditable(true);

                DynamicTable.getColumns().add(tableColumn);
            }

        }
    }

    void DynamicHandler(String sql){

       try{
           Boolean aBoolean = sqlQuery.ExecuteCommand(sql);
           if(aBoolean==null) throw new Exception("Null Answer");
           if(aBoolean){
               lastResult = connect_statement.getStatement().getResultSet().getMetaData();
               rows_returned=0;
               unity.setColumnNames(sqlQuery.GetColumnNamesForQuery(connect_statement.getStatement().getResultSet().getMetaData()));
               CreatePropertyForQuery(unity.getColumnNames().size());
               CreateColumnForQuery(unity.getColumnNames());
               DynamicErrorLabel.setTextFill(Color.BLUE);
               DynamicErrorLabel.setText(rows_returned + " row(s) affected | " + connect_statement.getStatement().getQueryTimeout() + " sec");
           }
           else{
               DynamicErrorLabel.setTextFill(Color.BLUE);
               DynamicErrorLabel.setText(connect_statement.getStatement().getUpdateCount() + " row(s) affected | " + connect_statement.getStatement().getQueryTimeout() + " sec");
           }
           LabelToolTip.setText(DynamicErrorLabel.getText().trim());
       } catch (Exception throwable) {
           System.out.println(throwable.getMessage());
           System.out.println("DbController DynamicHandler");
           DynamicErrorLabel.setTextFill(Color.TOMATO);
           DynamicErrorLabel.setText(throwable.getMessage());
           LabelToolTip.setText(DynamicErrorLabel.getText().trim());
       }
    }

    private StringBuilder CreateQueryForEdited(int column, Dynamic rowValues, Object newValue)  {
        System.out.println(newValue.getClass()+" under "+newValue.toString().toLowerCase());
        if(!(newValue == null)) newValue = "\""+ newValue.toString().trim()+"\"";
        if (newValue.toString().toLowerCase().equals("\"true\"")) newValue=true;
        if (newValue.toString().toLowerCase().equals("\"false\"")) newValue=false;
        try {StringBuilder sqlQuery = new StringBuilder("UPDATE ");
            sqlQuery.append(lastResult.getTableName(column+1));
            sqlQuery.append(" SET ");
            sqlQuery.append(unity.getColumnNames().get(column));
            sqlQuery.append(" = ");
            sqlQuery.append(newValue);
            sqlQuery.append(" WHERE ");
            for(int i=0;i<unity.getColumnNames().size();i++){
                sqlQuery.append(unity.getColumnNames().get(i));
                Object o =rowValues.getSimpleObjectProperties().get(i).getValue();
                sqlQuery.append(o==null?" is null ":o instanceof Boolean?" is "+o+" ":o instanceof Float?" > "+((float)o-0.1)+" And  "+unity.getColumnNames().get(i)+" < "+((float)o+0.1)
                        :" = \""+o+"\"");
                if(i!=unity.getColumnNames().size()-1){
                    sqlQuery.append(" AND ");
                }
            }
            System.out.println(sqlQuery.toString());
            return sqlQuery;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("CreateQueryForEdited");
            return null;
        }
   }

   private void sqlEditedHandler(int column,int row,Dynamic rowValues,Object newValue){
       StringBuilder sql = CreateQueryForEdited(column, rowValues,newValue);
       try {
           if(sql==null) throw new Exception("Null");
           sqlQuery.ExecuteCommand(sql.toString());
           Dynamic dynamic= (Dynamic)unity.getObservableListForDynamic().get(row);
           dynamic.getSimpleObjectProperties().get(column).setValue(newValue);
           DynamicErrorLabel.setTextFill(Color.BLUE);
           DynamicErrorLabel.setText(connect_statement.getStatement().getUpdateCount()+" row(s) updated");
       } catch (Exception throwable) {
           DynamicErrorLabel.setTextFill(Color.TOMATO);
           DynamicErrorLabel.setText("Error update");
           System.out.println("sqlEditedHandler");

       }


   }

    @FXML
    void initialize() {
        DynamicTable.setEditable(true);
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

