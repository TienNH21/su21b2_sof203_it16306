package services;

import java.util.ArrayList;
import java.util.List;
import models.MonHoc;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Date;

public class QLMonHocService {
    public List<MonHoc> getAll() {
        List<MonHoc> list = new ArrayList<>();

        try {
            // Bước 1: Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Bước 2: Tạo connection
            String dbUser = "sa", dbPassword = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=quan_ly_mon_hoc";
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Bước 3: PreparedStatement
            String query = "SELECT * FROM mon_hoc";
            PreparedStatement ps = conn.prepareStatement(query);

            // Bước 4: Thực thi truy vấn
            ResultSet rs = ps.executeQuery();
            
            // Bước 5: Bóc dữ liệu
            while ( rs.next() == true ) {
                int id = rs.getInt("id");
                String tenMH = rs.getString("ten_mon_hoc");
                String maMH = rs.getString("ma_mon_hoc");
                Date ngayTao = rs.getDate("ngay_tao");
                int chuyenNganhId = rs.getInt("chuyen_nganh_id");

                MonHoc mh = new MonHoc(id, maMH, tenMH, ngayTao, chuyenNganhId);
                list.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public MonHoc them(MonHoc mh) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String dbUser = "sa", dbPass = "Aa@123456",
                dbUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=quan_ly_mon_hoc";
            
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            
            String query = "INSERT INTO mon_hoc"
                + "(ten_mon_hoc, ma_mon_hoc, ngay_tao, chuyen_nganh_id) "
                + " OUTPUT Inserted.ID VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, mh.getTenMH());
            ps.setString(2, mh.getMaMH());
            
            /*
             * mh.getNgayTao() -> java.util.Date
             * setDate(int, java.sql.Date)
             */
            java.sql.Date ngayTaoSqlDate = new java.sql.Date( mh.getNgayTao().getTime() );
            ps.setDate(3, ngayTaoSqlDate);
            ps.setInt(4, mh.getChuyenNganhId());
            
            /*
             * result không phải là id của bản ghi mới thêm, mà là số bản ghi chịu tác động
             * Để lấy ra id sau khi thêm, dùng ResultSet
             */
            int result = ps.executeUpdate();
            ResultSet rs = ps.getResultSet();
            
            rs.next(); // Trỏ đến bản ghi đầu tiên trong ResultSet
            int id = rs.getInt(1);
            System.out.println("id: " + id);
            
            mh.setId(id);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mh;
    }
    
    public boolean capNhat(MonHoc mh) {
        return true;
    }
    
    public boolean xoa(int id) {
        return true;
    }
}
