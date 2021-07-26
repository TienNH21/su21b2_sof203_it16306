package sof203_it16306_jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import models.User;

public class DemoJDBC {
    public static void main(String[] args) {
        try {
            // B1: Load driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nối đến DB
            // <protocol>://<host>:<port>;databaseName=<db-name>
            String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic",
                dbUsername = "sa", dbPassword="Aa@123456";

            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);

            String query = "SELECT * FROM users";
            // B3: Tạo Statement để thực thi câu truy vấn
            Statement stm = conn.createStatement();
            
            // B4: Thực thi truy vấn
            ResultSet rs = stm.executeQuery(query);
            
            /*
             * B5: Bóc tách dữ liệu từ ResultSet
             * rs.next() -> boolean: true|false
             * còn dữ liệu có thể đọc từ ResultSet -> true
             * hết/không có dữ liệu có thể đọc     -> false
             */
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int role = rs.getInt("role");
                
                User u = new User(id, username, password, role);
                System.out.printf("%d - %s - %s - %d\n", id, username, password, role);
            }

            // B6: Đóng kết nối
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
