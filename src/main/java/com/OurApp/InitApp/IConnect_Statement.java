package com.OurApp.InitApp;

import java.sql.Connection;
import java.sql.Statement;

public interface IConnect_Statement {
     Boolean initConnect(String db,String login,String password);
     Statement getStatement();
     Connection getConnection();
}
