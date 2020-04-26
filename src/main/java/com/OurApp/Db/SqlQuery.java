package com.OurApp.Db;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlQuery {
    private static SqlQuery instance;

    private Statement _statement = null;

    private SqlQuery(){ }

    public static SqlQuery getInstance(){
        if(instance == null){
            instance = new SqlQuery();
        }
        return instance;
    }

    public void  setStatement(Statement statement){
        this._statement = statement;
    }


    public ResultSet SqlSelectFromAuthors(String[] args) throws Exception {
        if(_statement ==null){
            throw new Exception("Not instance Statemen");
        }
        return null;

    }




}
