package services;

import java.util.ArrayList;
import java.util.List;
import models.MonHoc;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QLMonHocService {
    // Thành Chung
    // Chí Thủy
    public List<MonHoc> getAll(int chuyenNganhId) {
        List<MonHoc> list = new ArrayList<>();

        try {
            String query = "SELECT * FROM mon_hoc "
                    + " WHERE chuyen_nganh_id = ?";
            PreparedStatement ps = JdbcUtil.prepare(query);
            
            ps.setInt(1, chuyenNganhId);

            ResultSet rs = ps.executeQuery();
            
            while ( rs.next() == true ) {
                int id = rs.getInt("id");
                String tenMH = rs.getString("ten_mon_hoc");
                String maMH = rs.getString("ma_mon_hoc");
                Date ngayTao = rs.getDate("ngay_tao");
                int cnId = rs.getInt("chuyen_nganh_id");

                MonHoc mh = new MonHoc(id, maMH, tenMH, ngayTao, cnId);
                list.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public MonHoc them(MonHoc mh) {
        try {
            String query = "INSERT INTO mon_hoc"
                + "(ten_mon_hoc, ma_mon_hoc, ngay_tao, chuyen_nganh_id) "
                + " OUTPUT Inserted.ID VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = JdbcUtil.prepare(query);
            
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mh;
    }
    
    public boolean capNhat(MonHoc mh) {
        try {
            java.sql.Date ngayTaoSql = new java.sql.Date( mh.getNgayTao().getTime() );
            String query = "UPDATE mon_hoc SET ten_mon_hoc = ?, ma_mon_hoc = ?, ngay_tao = ?, "
                + "chuyen_nganh_id = ? WHERE id = ?";

            PreparedStatement ps = JdbcUtil.prepare(query);            
            
            ps.setString(1, mh.getTenMH());
            ps.setString(2, mh.getMaMH());

            ps.setDate(3, ngayTaoSql);

            ps.setInt(4, mh.getChuyenNganhId());
            ps.setInt(5, mh.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean xoa(int id) {
        String query = "DELETE FROM mon_hoc WHERE id = ?";
        try {
            PreparedStatement ps = JdbcUtil.prepare(query);
            ps.setInt(1, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return true;
    }
}
