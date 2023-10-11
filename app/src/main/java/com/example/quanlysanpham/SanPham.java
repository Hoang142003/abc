package com.example.quanlysanpham;

public class SanPham {
    private String masp, tensp;
    private int slsp;

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSlsp() {
        return slsp;
    }

    public void setSlsp(int slsp) {
        this.slsp = slsp;
    }

    public SanPham(String masp, String tensp, int slsp) {
        this.masp = masp;
        this.tensp = tensp;
        this.slsp = slsp;
    }
}
