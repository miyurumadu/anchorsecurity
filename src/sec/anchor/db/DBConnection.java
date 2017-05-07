/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.anchor.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cmjd
 */
public class DBConnection {

    private Connection conn;
    private static DBConnection dBConnection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/anchor", "root", "mysql");
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dBConnection == null) {
            dBConnection = new DBConnection();

        }
        return dBConnection;
    }

    public Connection getConnection() {
        return conn;
    }

}
