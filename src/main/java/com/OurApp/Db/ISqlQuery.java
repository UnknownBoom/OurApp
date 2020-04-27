package com.OurApp.Db;


import java.sql.ResultSet;
import java.sql.Statement;

public interface ISqlQuery {
    void setStatement(Statement statement);
    ResultSet ExecuteSelectAuthors();
    ResultSet ExecuteSelectReaders();
    ResultSet ExecuteSelectRents();
    ResultSet ExecuteSelectBooks();
    int ExecuteUpdate();
    Boolean ExecuteCommand();

}
