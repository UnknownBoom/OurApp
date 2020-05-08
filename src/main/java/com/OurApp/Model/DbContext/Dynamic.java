package com.OurApp.Model.DbContext;

import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.List;

public class Dynamic {

    private List<SimpleObjectProperty> simpleObjectProperties = new ArrayList<>();
    public List<SimpleObjectProperty> getSimpleObjectProperties() {
        return simpleObjectProperties;
    }

    public void simpleObjectProperties(List<SimpleObjectProperty> simpleObjectProperties) {
        this.simpleObjectProperties = simpleObjectProperties;
    }
    public Dynamic(){ }
}
