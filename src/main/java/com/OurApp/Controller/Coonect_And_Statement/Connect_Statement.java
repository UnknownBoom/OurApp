package com.OurApp.Controller.Coonect_And_Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect_Statement implements IConnect_Statement {
    private static IConnect_Statement instance = null;
    private Connect_Statement(){}
    public static IConnect_Statement getInstance(){
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
    public Boolean initConnect( String db, String login, String password) throws SQLException {
        db = defoultUrl+db+"?verifyServerCertificate=false"+
                "&allowPublicKeyRetrieval=true"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        connection = DriverManager.getConnection(db, login, password);
        return true;
    }

    @Override
    public Statement getStatement() throws SQLException {
        if(statement!= null) return statement;
        statement = connection.createStatement();
        return statement;
    }
}
