package sof203_it16306_jdbc;

import models.User;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DemoDelete {
    public static void main(String[] args) {
        User user = new User(1004, "TienNH", "12345678", 1);

        try {
            // B1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nối
            String dbUsername = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc_generic";

            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // B3: Tạo PreparedStatement
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, user.getId());

            // B4 - B5: Thực thi truy vấn
            int kq = ps.executeUpdate();
            
            System.out.println("Kết quả: " + kq);

            // B6: Đóng kết nối
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
