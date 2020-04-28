package com.OurApp.InitApp;

import com.OurApp.Controller.Unity;
import com.sun.javafx.scene.control.Properties;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect_Statement implements IConnect_Statement {
    private static Connect_Statement instance = null;
    private Connect_Statement(){}
    public static Connect_Statement getInstance(){
        if(instance != null) return instance;
        else{
            instance = new Connect_Statement();
            return instance;
        }
    }

    private String defoultUrl =  "jdbc:mysql://localhost/";
    private static Statement statement = null;
    private   Connection connection;

    public  Connection getConnection() {
        return connection;
    }



    @Override
    public Boolean initConnect( String db, String login, String password) {
        try{
            db = defoultUrl+db;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(db, login, password);
            return true;
        } catch (Exception throwables) {
            return false;
        }

    }

    @Override
    public Statement getStatement() {
        if (statement != null) return statement;
        try {
            statement = connection.createStatement();
            return statement;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
