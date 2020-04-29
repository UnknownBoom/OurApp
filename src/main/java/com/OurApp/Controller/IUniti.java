package com.OurApp.Controller;

import com.OurApp.Model.DbContext.*;
import javafx.collections.ObservableList;

public interface IUniti {
    ObservableList getObservableListForAuthors();
    void setObservableListForAuthors(ObservableList authors);
    void addObservableListForAuthors(Authors author);

    ObservableList getObservableListForBooks();
    void setObservableListForBook(ObservableList books);
    void addObservableListForBooks(Books book);

    ObservableList getObservableListForReaders();
    void setObservableListForReaders(ObservableList readers);
    void addObservableListForReaders(Readers reader);

    ObservableList getObservableListForRents();
    void setObservableListForRents(ObservableList rents);
    void addObservableListForRents(Rents rent);

    ObservableList getObservableListForDynamic();
    void setObservableListForDynamic(ObservableList list);
    void addObservableListForDynamic();



}
