package com.OurApp.Controller.ObservListAccess;

import com.OurApp.Model.DbContext.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public  class Unity implements IUniti {

    private ObservableList observableListForDynamic = FXCollections.observableArrayList();

    private static Unity instance = null;
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
