package com.OurApp.Model.DbContext;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Readers {


    @Override
    public String toString() {
        return "Readers{" +
                "_id=" + _id.getValue() +
                ", _f_name='" + _f_name.getValue() + '\'' +
                ", _l_name='" + _l_name.getValue() + '\'' +
                ", _email='" + _email.getValue() + '\'' +
                '}';
    }


    private final SimpleIntegerProperty _id = new SimpleIntegerProperty();
    private final SimpleStringProperty _f_name = new SimpleStringProperty();
    private final SimpleStringProperty _l_name = new SimpleStringProperty();
    private final SimpleStringProperty _email = new SimpleStringProperty();

    public static Builder newBuilder(){
        return new Readers().new Builder();
    }

    public class Builder{
        private Builder(){}

        public Readers.Builder sethId(int id) {
            Readers.this._id.set(id);
            return this;
        }
        public Readers.Builder setF_Name(String f_name) {
            Readers.this._f_name.set(f_name);
            return this;
        }
        public Readers.Builder setL_Name(String l_name) {
            Readers.this._l_name.set(l_name);
            return this;
        }
        public Readers.Builder setEmail(String email) {
            Readers.this._email.set(email);
            return this;
        }

        public Readers Build(){
            return Readers.this;
        }


    }

}
