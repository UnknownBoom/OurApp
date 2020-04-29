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


    public int get_id() {
        return _id.get();
    }

    public SimpleIntegerProperty _idProperty() {
        return _id;
    }

    public void set_id(int _id) {
        this._id.set(_id);
    }

    public String get_f_name() {
        return _f_name.get();
    }

    public SimpleStringProperty _f_nameProperty() {
        return _f_name;
    }

    public void set_f_name(String _f_name) {
        this._f_name.set(_f_name);
    }

    public String get_l_name() {
        return _l_name.get();
    }

    public SimpleStringProperty _l_nameProperty() {
        return _l_name;
    }

    public void set_l_name(String _l_name) {
        this._l_name.set(_l_name);
    }

    public String get_email() {
        return _email.get();
    }

    public SimpleStringProperty _emailProperty() {
        return _email;
    }

    public void set_email(String _email) {
        this._email.set(_email);
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

        public Readers.Builder setId(int id) {
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
