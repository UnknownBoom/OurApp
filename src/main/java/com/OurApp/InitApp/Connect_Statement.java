package com.OurApp.InitApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

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
            db = defoultUrl+db+"?verifyServerCertificate=false"+
                    "&allowPublicKeyRetrieval=true"+
                    "&useSSL=false"+
                    "&requireSSL=false"+
                    "&useLegacyDatetimeCode=false"+
                    "&amp"+
                    "&serverTimezone=UTC";
            connection = DriverManager.getConnection(db, login, password);
            return true;
        } catch (Exception throwables) {
            System.out.println("\n" + Arrays.toString(throwables.getStackTrace()));
            System.out.println(throwables.getMessage());
            return false;
        }

    }

    @Override
    public Statement getStatement() {
        try {
            if(statement!= null) return statement;
            if (connection == null) throw new Exception("Connection is Null");
            statement = connection.createStatement();
            return statement;
        } catch (Exception throwables) {
            System.out.println("\n" + Arrays.toString(throwables.getStackTrace()));
            System.out.println(throwables.getMessage());
            return null;
        }
    }
}
