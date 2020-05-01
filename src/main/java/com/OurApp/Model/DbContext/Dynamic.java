package com.OurApp.Model.DbContext;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class Dynamic {

    private List<SimpleStringProperty> simpleStringProperty = new ArrayList<>();
    public List<SimpleStringProperty> getSimpleStringProperty() {
        return simpleStringProperty;
    }

    public void setSimpleStringProperty(List<SimpleStringProperty> simpleStringProperty) {
        this.simpleStringProperty = simpleStringProperty;
    }
    public Dynamic(){ }
}
