package com.OurApp.Db.DbContext;

public class Authors {

    private int _id;
    private String _f_name;
    private String _l_name;
    private String _lang;

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

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }



    public Authors(int id){
        this._id = id;
    }
    public Authors(String f_name){
        this._f_name = f_name;
    }
    public Authors(int id,String f_name ){
        this._id = id;
        this._f_name = f_name;
    }
    public Authors(int id,String f_name,String l_name){
        this._id = id;
        this._f_name = f_name;
        this._l_name= l_name;
    }
    public Authors(int id,String f_name,String l_name,String lang ){
        this._id = id;
        this._f_name = f_name;
        this._l_name= l_name;
        this._lang = lang;
    }
    public Authors(){
    }

}
