package com.OurApp.Db.DbContext;

public class Books {

    private int _id;
    private String _title;
    private int _author_id;
    private int _rent_price;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public int getAuthor_id() {
        return _author_id;
    }

    public void setAuthor_id(int author_id) {
        this._author_id = author_id;
    }

    public int getRent_price() {
        return _rent_price;
    }

    public void setRent_price(int rent_price) {
        this._rent_price = rent_price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "_id=" + _id +
                ", title='" + _title + '\'' +
                ", author_id=" + _author_id +
                ", rent_price=" + _rent_price +
                '}';
    }

    public static Builder newBuilder(){
        return new Books().new Builder();
    }
    public  class Builder{
        private Builder(){}
        public Builder setid(int id){
            Books.this._id =id;
            return this;
        }
        public Builder setTitle(String title){
            Books.this._title =title;
            return this;
        }
        public Builder setAuthor_id(int author_id){
            Books.this._author_id =author_id;
            return this;
        }
        public Builder setRent_Price(int rent_price){
            Books.this._rent_price =rent_price;
            return this;
        }
        public Books Build(){
            return Books.this;
        }
    }






}
