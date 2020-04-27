package com.OurApp.Main;

import com.OurApp.Db.DbContext.Authors;
import com.OurApp.Db.DbContext.Books;
import com.OurApp.Db.DbContext.Readers;
import com.OurApp.Db.DbContext.Rents;
import com.OurApp.Db.InitStatement;
import com.OurApp.Db.SqlQuery;

import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        InitStatement initStatement = new InitStatement();
        Statement statement = initStatement.GetStatement();
        SqlQuery sqlQueru = SqlQuery.getInstance();
        sqlQueru.setStatement(statement);
        ResultSet resultSet = sqlQueru.SqlSelectFromAuthors();
        Rents rents = Rents.newBuilder().setBook_id(12).Build();
        System.out.println(rents);

    }
}
