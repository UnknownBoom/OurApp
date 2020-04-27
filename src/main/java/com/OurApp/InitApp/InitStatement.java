package com.OurApp.InitApp;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InitStatement implements IinitStatement{
    private static Statement statement = null;

    public Statement GetStatement(){
        if (statement != null) return statement;
        Properties props = new Properties();
        try{
            InputStream inputStream = Files.newInputStream(Paths.get("src\\main\\resources\\database.properties"));
            props.load(inputStream);
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");
            Connection connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            return statement;
        } catch (IOException | SQLException e) {
            System.out.printf("-------------%s-------------\n",e.getMessage());
            return null;
        }
    }

}
