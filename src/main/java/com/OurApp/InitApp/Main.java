package com.OurApp.InitApp;


import com.OurApp.Controller.Unity;
import com.OurApp.Model.DbContext.*;
import com.OurApp.Controller.Sql.SqlQuery;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Unity unity = Unity.getInstance();

        InitStatement initStatement = new InitStatement();
        Statement statement = initStatement.GetStatement();
        ResultSet resultSet = statement.executeQuery("Select * from rents");
        SqlQuery sqlQueru = SqlQuery.getInstance();
        sqlQueru.setStatement(statement);
/*        while(resultSet.next()){
            Authors authors = Authors.newBuilder().setId(resultSet.getInt(1)).setF_Name(resultSet.getString(2)).setF_Name(resultSet.getString(3)).Build();
            unity.addObservableList(authors);
        }
       javaFxLaunch javaFxLaunch = new javaFxLaunch();
        javaFxLaunch.Launch();*/




    }

}

