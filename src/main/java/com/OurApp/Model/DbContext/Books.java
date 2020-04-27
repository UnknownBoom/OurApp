package com.OurApp.Model.DbContext;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Books {

    public int get_id() {
        return _id.get();
    }

    public SimpleIntegerProperty _idProperty() {
        return _id;
    }

    public void set_id(int _id) {
        this._id.set(_id);
    }

    public String get_title() {
        return _title.get();
    }

    public SimpleStringProperty _titleProperty() {
        return _title;
    }

    public void set_title(String _title) {
        this._title.set(_title);
    }

    public int get_author_id() {
        return _author_id.get();
    }

    public SimpleIntegerProperty _author_idProperty() {
        return _author_id;
    }

    public void set_author_id(int _author_id) {
        this._author_id.set(_author_id);
    }

    public int get_rent_price() {
        return _rent_price.get();
    }

    public SimpleIntegerProperty _rent_priceProperty() {
        return _rent_price;
    }

    public void set_rent_price(int _rent_price) {
        this._rent_price.set(_rent_price);
    }

    private final SimpleIntegerProperty _id = new SimpleIntegerProperty();
    private final SimpleStringProperty _title = new SimpleStringProperty();
    private final SimpleIntegerProperty _author_id =  new SimpleIntegerProperty();
    private final SimpleIntegerProperty _rent_price =  new SimpleIntegerProperty() ;


    @Override
    public String toString() {
        return "Books{" +
                "_id=" + _id.getValue() +
                ", title='" + _title.getValue() + '\'' +
                ", author_id=" + _author_id.getValue() +
                ", rent_price=" + _rent_price.getValue() +
                '}';
    }

    public static Builder newBuilder(){
        return new Books().new Builder();
    }
    public  class Builder{
        private Builder(){}
        public Builder setid(int id){
            Books.this._id.set(id);
            return this;
        }
        public Builder setTitle(String title){
            Books.this._title.set(title) ;
            return this;
        }
        public Builder setAuthor_id(int author_id){
            Books.this._author_id.set(author_id);
            return this;
        }
        public Builder setRent_Price(int rent_price){
            Books.this._rent_price.set(rent_price) ;
            return this;
        }
        public Books Build(){
            return Books.this;
        }
    }






}
