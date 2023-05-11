package com.vutarem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    protected static final String DATABASE = "admin";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin1234";

    public Conexion(){
    }

    static public Connection conecta() throws SQLException{
        Connection conn = Conexion.connect(DATABASE, Conexion.USER, Conexion.PASSWORD);
        return conn;
    }
    
    static private Connection connect(String database, String user, String password) throws SQLException{
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/" + database;

        conn = DriverManager.getConnection(url, user, password);

        return conn;
    }
}