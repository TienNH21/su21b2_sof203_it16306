package models;

import java.util.Date;

public class MonHoc {
    private int id;
    private String maMH, tenMH;
    private Date ngayTao;
    private int chuyenNganhId;

    public MonHoc() {
    }

    public MonHoc(int id, String maMH, String tenMH, Date ngayTao, int chuyenNganhId) {
        this.id = id;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.ngayTao = ngayTao;
        this.chuyenNganhId = chuyenNganhId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public int getChuyenNganhId() {
        return chuyenNganhId;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setChuyenNganhId(int chuyenNganhId) {
        this.chuyenNganhId = chuyenNganhId;
    }
    
    
}
