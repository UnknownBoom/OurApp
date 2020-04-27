package com.OurApp.Controller;

import com.OurApp.Model.DbContext.Authors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public  class Unity {

    private static Unity instance = null;
    private Unity(){}
    public static Unity getInstance(){
        if(instance != null) return instance;
        else{
            instance = new Unity();
            return instance;
        }
    }

    public ObservableList getObservableList() {
        return observableList;
    }

    public void setObservableList(ObservableList observableList) {
        this.observableList = observableList;
    }
    public void addObservableList(Authors observableList) {
        this.observableList.add(observableList);
    }

    private ObservableList observableList = FXCollections.observableArrayList();

}
