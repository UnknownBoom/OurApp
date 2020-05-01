package com.OurApp.Controller.ObservListAccess;

import com.OurApp.Model.DbContext.*;
import javafx.collections.ObservableList;


public interface IUniti {

    ObservableList getObservableListForDynamic();
    void setObservableListForDynamic(ObservableList list);
    void addObservableListForDynamic(Dynamic dynamic);





}
