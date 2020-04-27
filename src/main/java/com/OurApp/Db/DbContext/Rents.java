package com.OurApp.Db.DbContext;

import java.util.Date;

public class Rents {
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_book_id() {
        return _book_id;
    }

    public void set_book_id(int _book_id) {
        this._book_id = _book_id;
    }

    public int get_reader_id() {
        return _reader_id;
    }

    public void set_reader_id(int _reader_id) {
        this._reader_id = _reader_id;
    }

    public Date get_getdate() {
        return _getdate;
    }

    public void set_getdate(Date _getdate) {
        this._getdate = _getdate;
    }

    public Date get_returndate() {
        return _returndate;
    }

    public void set_returndate(Date _returndate) {
        this._returndate = _returndate;
    }

    private int _id;
    private int _book_id;
    private int _reader_id;
    private Date _getdate;
    private Date _returndate;

    @Override
    public String toString() {
        return "Rents{" +
                "_id=" + _id +
                ", _book_id=" + _book_id +
                ", _reader_id=" + _reader_id +
                ", _getdate=" + _getdate +
                ", _returndate=" + _returndate +
                '}';
    }

    public static Builder newBuilder(){
        return new Rents().new Builder();
    }

    public class Builder{
        private Builder(){}

        public Builder setId(int id){
            Rents.this._id = id;
            return this;
        }
        public Builder setBook_id(int book_id){
            Rents.this._book_id = book_id;
            return this;
        }
        public Builder setReader_id(int reader_id){
            Rents.this._reader_id = reader_id;
            return this;
        }
        public Builder setGet_date(Date get_date){
            Rents.this._getdate = get_date;
            return this;
        }
        public Builder setReturn_date(Date return_date){
            Rents.this._returndate = return_date;
            return this;
        }

        public Rents Build(){
            return Rents.this;
        }

    }


}
