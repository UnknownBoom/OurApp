package com.OurApp.Controller;

import com.OurApp.Model.DbContext.Authors;
import com.OurApp.Model.DbContext.Books;
import com.OurApp.Model.DbContext.Readers;
import com.OurApp.Model.DbContext.Rents;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public  class Unity implements IUniti   {

    private ObservableList observableListForAuthors = FXCollections.observableArrayList();
    private ObservableList observableListForBooks = FXCollections.observableArrayList();
    private ObservableList observableListForReaders= FXCollections.observableArrayList();
    private ObservableList observableListForRents = FXCollections.observableArrayList();
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
    public ObservableList getObservableListForAuthors() {
        return observableListForAuthors;
    }

    @Override
    public void setObservableListForAuthors(ObservableList authors) {
        observableListForAuthors = authors;
    }

    @Override
    public void addObservableListForAuthors(Authors author) {
        observableListForAuthors.add(author);
    }

    @Override
    public ObservableList getObservableListForBooks() {
        return observableListForBooks;
    }

    @Override
    public void setObservableListForBook(ObservableList books) {
        observableListForBooks = books;
    }

    @Override
    public void addObservableListForBooks(Books book) {
        observableListForBooks.add(book);
    }

    @Override
    public ObservableList getObservableListForReaders() {
        return observableListForReaders;
    }

    @Override
    public void setObservableListForReaders(ObservableList readers) {
        observableListForReaders = readers;
    }

    @Override
    public void addObservableListForReaders(Readers reader) {
        observableListForReaders.add(reader);
    }

    @Override
    public ObservableList getObservableListForRents() {
        return observableListForRents;
    }

    @Override
    public void setObservableListForRents(ObservableList rents) {
        observableListForRents = rents;
    }

    @Override
    public void addObservableListForRents(Rents rent) {
        observableListForRents.add(rent);

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
    public void addObservableListForDynamic() {

    }
}
