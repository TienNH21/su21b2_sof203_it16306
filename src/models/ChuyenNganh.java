package models;

public class ChuyenNganh {
    private int id;
    private String tenChuyenNganh;
    private String maChuyenNganh;

    public ChuyenNganh() {
    }

    public ChuyenNganh(int id, String tenChuyenNganh, String maChuyenNganh) {
        this.id = id;
        this.tenChuyenNganh = tenChuyenNganh;
        this.maChuyenNganh = maChuyenNganh;
    }

    public void setMaChuyenNganh(String maChuyenNganh) {
        this.maChuyenNganh = maChuyenNganh;
    }

    public String getMaChuyenNganh() {
        return maChuyenNganh;
    }

    public int getId() {
        return id;
    }

    public String getTenChuyenNganh() {
        return tenChuyenNganh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenChuyenNganh(String tenChuyenNganh) {
        this.tenChuyenNganh = tenChuyenNganh;
    }
    
    
}
