package com.OurApp.Controller.Coonect_And_Statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface IConnect_Statement {
     Boolean initConnect(String db,String login,String password) throws SQLException;
     Statement getStatement() throws Exception;
     Connection getConnection();
}
