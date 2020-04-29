package com.OurApp.Controller.Sql;


import java.sql.ResultSet;
import java.sql.Statement;

public interface ISqlQuery {
    void setStatement(Statement statement);
    ResultSet ExecuteAllSelectAuthors();
    ResultSet ExecuteAllSelectReaders();
    ResultSet ExecuteAllSelectRents();
    ResultSet ExecuteAllSelectBooks();
    ResultSet ExecuteSelectAuthors();
    ResultSet ExecuteSelectReaders();
    ResultSet ExecuteSelectRents();
    ResultSet ExecuteSelectBooks();
    int ExecuteUpdate();
    Boolean ExecuteCommand();

}
