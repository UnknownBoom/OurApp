package com.OurApp.Main;

import com.OurApp.Db.InitStatement;
import com.OurApp.Db.SqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        InitStatement initStatement = new InitStatement();
        Statement statement = initStatement.GetStatement();
        SqlQuery sqlQueru = SqlQuery.getInstance();
        sqlQueru.setStatement(statement);

    }
}
