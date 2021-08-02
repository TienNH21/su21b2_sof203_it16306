package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                String dbUser = "sa", dbPassword = "Aa@123456",
                    dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_mon_hoc";
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return conn;
    }
    
    public static PreparedStatement prepare(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}
