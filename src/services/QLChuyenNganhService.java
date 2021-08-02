package services;

import java.util.ArrayList;
import java.util.List;
import models.ChuyenNganh;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QLChuyenNganhService {
    public List<ChuyenNganh> getAll() {
        ArrayList<ChuyenNganh> list = new ArrayList<>();
        
        try {
            // B1: Load Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // B2: Tạo kết nối tới DB
            String dbUser = "sa", dbPass = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_mon_hoc";
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            // B3: Tạo PreparedStatement
            String query = "SELECT * FROM chuyen_nganh";
            PreparedStatement ps = conn.prepareStatement(query);
            
            // B4: Thực thi truy vấn
            ResultSet rs = ps.executeQuery();
            
            // B5: Bóc dữ liệu
            while ( rs.next() == true ) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten_chuyen_nganh");
                String ma = rs.getString("ma_chuyen_nganh");
                
                ChuyenNganh cn = new ChuyenNganh(id, ten, ma);
                
                list.add(cn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
