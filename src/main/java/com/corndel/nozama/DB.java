package com.corndel.nozama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
  /** TODO: Set the dbUrl */
  public static final String dbUrl = "jdbc:sqlite:nozama.db";

  public static Connection getConnection() throws SQLException {
    /** TODO: finish this method */
    return DriverManager.getConnection(dbUrl);
  }
}
