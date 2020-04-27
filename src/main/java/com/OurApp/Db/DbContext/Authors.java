package com.OurApp.Db.DbContext;

public class Authors {
    private Authors(){}

    public int get_id() {
        return _id;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "_id=" + _id +
                ", _f_name='" + _f_name + '\'' +
                ", _l_name='" + _l_name + '\'' +
                ", _lang='" + _lang + '\'' +
                '}';
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_f_name() {
        return _f_name;
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

    public String get_lang() {
        return _lang;
    }

    public void set_lang(String _lang) {
        this._lang = _lang;
    }

    private int _id;
    private String _f_name;
    private String _l_name;
    private String _lang;

    public static Builder newBuilder() {
        return new Authors().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder sethId(int id) {
            Authors.this._id = id;
            return this;
        }
        public Builder setF_Name(String f_name) {
            Authors.this._f_name = f_name;
            return this;
        }
        public Builder setL_Name(String l_name) {
            Authors.this._l_name = l_name;
            return this;
        }
        public Builder setLang(String lang) {
            Authors.this._lang = lang;
            return this;
        }

        public Authors Build() {
            return Authors.this;
        }

    }

}
