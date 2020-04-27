package com.OurApp.Model.DbContext;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.sql.Date;

public class Rents {

    private final SimpleIntegerProperty _id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty _book_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty _reader_id = new SimpleIntegerProperty();
    private final SimpleObjectProperty<java.sql.Date> _getDate = new SimpleObjectProperty<>();
    private final SimpleObjectProperty<java.sql.Date> _returnDate = new SimpleObjectProperty<>();

    @Override
    public String toString() {
        return "Rents{" +
                "_id=" + _id.getValue() +
                ", _book_id=" + _book_id.getValue() +
                ", _reader_id=" + _reader_id.getValue() +
                ", _getDate=" + _getDate.getValue() +
                ", _returnDate=" + _returnDate.getValue() +
                '}';
    }

    public static Builder newBuilder(){
        return new Rents().new Builder();
    }

    public class Builder{
        private Builder(){}

        public Builder setId(int id){
            Rents.this._id.set(id);
            return this;
        }
        public Builder setBook_id(int book_id){
            Rents.this._book_id.set(book_id);
            return this;
        }
        public Builder setReader_id(int reader_id){
            Rents.this._reader_id.set(reader_id);
            return this;
        }
        public Builder setGet_date(Date get_date){
            Rents.this._getDate.set(get_date);
            return this;
        }
        public Builder setReturn_date(Date return_date){
            Rents.this._returnDate.set(return_date);
            return this;
        }

        public Rents Build(){
            return Rents.this;
        }

    }


}
