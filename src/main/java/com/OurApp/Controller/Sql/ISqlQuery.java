package com.OurApp.Controller.Sql;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public interface ISqlQuery {
    List<String> GetColumnNamesForQuery(ResultSetMetaData resultSetMetaData) throws SQLException;
    Boolean ExecuteCommand(String sql) throws SQLException;

}
