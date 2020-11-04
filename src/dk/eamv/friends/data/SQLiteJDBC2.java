package dk.eamv.friends.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteJDBC {
    Connection conn;

    public static void connect() {
        conn = null;
        try {
            String url = "jdbc:sqlite:friends.sqlite"
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void disconnect() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
