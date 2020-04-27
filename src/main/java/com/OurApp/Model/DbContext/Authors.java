package com.OurApp.Model.DbContext;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Authors {
    private Authors(){}

    @Override
    public String toString() {
        return "Authors{" +
                "_id=" + _id.getValue() +
                ", _f_name=" + _f_name.getValue() +
                ", _l_name=" + _l_name.getValue() +
                ", _lang=" + _lang.getValue() +
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

    public String get_lang() {
        return _lang.get();
    }

    public SimpleStringProperty _langProperty() {
        return _lang;
    }

    public void set_lang(String _lang) {
        this._lang.set(_lang);
    }

    private final SimpleIntegerProperty _id = new SimpleIntegerProperty();
    private final SimpleStringProperty _f_name = new SimpleStringProperty();
    private final SimpleStringProperty _l_name = new SimpleStringProperty();
    private final SimpleStringProperty _lang= new SimpleStringProperty();

    public static Builder newBuilder() {
        return new Authors().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setId(int id) {
            Authors.this._id.set(id);
            return this;
        }
        public Builder setF_Name(String f_name) {
            Authors.this._f_name.set(f_name) ;
            return this;
        }
        public Builder setL_Name(String l_name) {
            Authors.this._l_name.set(l_name);
            return this;
        }
        public Builder setLang(String lang) {
            Authors.this._lang.setValue(lang);
            return this;
        }

        public Authors Build() {
            return Authors.this;
        }

    }

}
