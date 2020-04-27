package com.OurApp.Db.DbContext;


public class Readers {

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_f_name() {
        return _f_name;
    }

    @Override
    public String toString() {
        return "Readers{" +
                "_id=" + _id +
                ", _f_name='" + _f_name + '\'' +
                ", _l_name='" + _l_name + '\'' +
                ", _email='" + _email + '\'' +
                '}';
    }

    public void set_f_name(String _f_name) {
        this._f_name = _f_name;
    }

    public String get_l_name() {
        return _l_name;
    }

    public void set_l_name(String _l_name) {
        this._l_name = _l_name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }


    private int _id;
    private String _f_name;
    private String _l_name;
    private String _email;

    public static Builder newBuilder(){
        return new Readers().new Builder();
    }

    public class Builder{
        private Builder(){}

        public Readers.Builder sethId(int id) {
            Readers.this._id = id;
            return this;
        }
        public Readers.Builder setF_Name(String f_name) {
            Readers.this._f_name = f_name;
            return this;
        }
        public Readers.Builder setL_Name(String l_name) {
            Readers.this._l_name = l_name;
            return this;
        }
        public Readers.Builder setEmail(String email) {
            Readers.this._email = email;
            return this;
        }

        public Readers Build(){
            return Readers.this;
        }


    }

}
