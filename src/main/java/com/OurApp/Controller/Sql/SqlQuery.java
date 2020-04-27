package com.OurApp.Controller.Sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlQuery  implements ISqlQuery {
    private static SqlQuery instance;

    private Statement _statement = null;

    private SqlQuery(){}

    public static SqlQuery getInstance(){
        if(instance == null){
            instance = new SqlQuery();
        }
        return instance;
    }


    @Override
    public void setStatement(Statement statement) {
        this._statement = statement;
        if(this._statement==null){
            System.out.println("Error Statement!!!!");}
    }

    @Override
    public ResultSet ExecuteSelectAuthors() {
        return null;
    }

    @Override
    public ResultSet ExecuteSelectReaders() {
        return null;
    }

    @Override
    public ResultSet ExecuteSelectRents() {
        return null;
    }

    @Override
    public ResultSet ExecuteSelectBooks() {
        return null;
    }


    @Override
    public int ExecuteUpdate() {
        return 0;
    }

    @Override
    public Boolean ExecuteCommand() {
        return null;
    }


    public ResultSet SqlSelectFromAuthors()  {
        if(_statement ==null){
            return null;
        }
        try{
            return _statement.executeQuery("select id from authors");
        }catch (SQLException throwable) {
            return null;
        }
    }

}
