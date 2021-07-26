package sof203_it16306_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import models.User;

public class DemoInsert {
    public static void main(String args[]) {
        // Dùng executeUpdate để thêm dữ liệu vào DB
        User u = new User(0, "TienNH22", "123456", 2);
        
        try {
            // B1: Load driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nối đến DB
            String url = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic",
                dbUsername = "sa", dbPassword="Aa@123456";

            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            
            // B3: Tạo Statement
            String query = "INSERT INTO users(username, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getRole());

            // B4 + B5: Thực thi truy vấn & Bóc dữ liệu
            int result = ps.executeUpdate();
            System.out.println("Result: " + result);
            
            // B6: Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
