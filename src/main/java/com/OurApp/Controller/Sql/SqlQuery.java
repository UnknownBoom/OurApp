package com.OurApp.Controller.Sql;

import com.OurApp.Controller.Coonect_And_Statement.Connect_Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlQuery  implements ISqlQuery {
    private static ISqlQuery instance;

    private Statement _statement;

    {
        try {
            _statement = Connect_Statement.getInstance().getStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("class SqlQuery _statement");
        }
    }

    private Connection _connection = Connect_Statement.getInstance().getConnection();

    private SqlQuery(){}

    public static ISqlQuery getInstance(){
        if(instance == null){
            instance = new SqlQuery();
        }
        return instance;
    }

    public List<String> GetColumnNamesForQuery(ResultSetMetaData resultSetMetaData) throws SQLException {
        int size = resultSetMetaData.getColumnCount();
        List<String> columnNames = new ArrayList<>();
        for(int i=1;i<=size;i++){
            columnNames.add(resultSetMetaData.getColumnName(i));
        }
        return columnNames;
    }

    @Override
    public Boolean ExecuteCommand(String sql) throws SQLException {
            return  _statement.execute(sql);
    }

}
