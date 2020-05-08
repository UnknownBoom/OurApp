package com.OurApp.Controller.Unity;

import com.OurApp.Model.DbContext.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.util.List;


public  class Unity implements IUniti {
    private List<String> columnNames = new ArrayList();
    private List<TableColumn> Columns = new ArrayList();
    private List<String> rows;
    private static Unity instance = null;

    private ObservableList observableListForDynamic = FXCollections.observableArrayList();

    public List<String> getColumnNames() {
        return columnNames;
    }
    public void clearColumnNames() {
        columnNames.clear();
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<TableColumn> getColumns() {
        return Columns;
    }

    public void setColumns(List<TableColumn> columns) {
        Columns = columns;
    }
    public void clearColumns() {
        Columns.clear();
    }

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }



    private Unity(){}
    public static Unity getInstance(){
        if(instance != null) return instance;
        else{
            instance = new Unity();
            return instance;
        }
    }

    @Override
    public ObservableList getObservableListForDynamic() {
        return observableListForDynamic;
    }

    @Override
    public void setObservableListForDynamic(ObservableList list) {
        observableListForDynamic  = list;
    }

    @Override
    public void addObservableListForDynamic(Dynamic dynamic) {
        observableListForDynamic.add(dynamic);

    }
    public void clearObservableListForDynamic() {
        observableListForDynamic.clear();

    }
}
