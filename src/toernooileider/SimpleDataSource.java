/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toernooileider;
import java.sql.*;



/**
 *
 * @author jannedevos
 */
public class SimpleDataSource {
    private static String url;
    private static String dbServer;
    private static String database;
    private static String user;
    private static String password;
    private static Connection activeConn;
    
    private static void init () throws ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        dbServer = "meru.hhs.nl";
        database = "13058932";
        user = "13058932";
        password = "uphaepeeZu";
        url = "jdbc:mysql://" + dbServer + "/" + database;
    }
    
    public static Connection getConnection () throws SQLException {
        if (activeConn == null) {
            activeConn = createConnection();
        }
        return activeConn;
    }
    
    public static void closeConnection () throws SQLException {
        activeConn.close();
        activeConn = null;
    }
    
    private static Connection createConnection () throws SQLException {
        Connection conn = null;
        try {
            init();
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conn;
    }
}
