/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author congc
 */
public class SanPham {
    private String id_SP;
    private String ten_SP;
    private int gia_SP;
    private String id_DonViSanPham;
    private String id_LoaiSanPham;
    private boolean  trangThai;
    private String hinh;

    public SanPham() {
    }

    public SanPham(String id_SP, String ten_SP, int gia_SP, String id_DonViSanPham, String id_LoaiSanPham, boolean trangThai, String hinh) {
        this.id_SP = id_SP;
        this.ten_SP = ten_SP;
        this.gia_SP = gia_SP;
        this.id_DonViSanPham = id_DonViSanPham;
        this.id_LoaiSanPham = id_LoaiSanPham;
        this.trangThai = trangThai;
        this.hinh = hinh;
    }

    public String getId_SP() {
        return id_SP;
    }

    public void setId_SP(String id_SP) {
        this.id_SP = id_SP;
    }

    public String getTen_SP() {
        return ten_SP;
    }

    public void setTen_SP(String ten_SP) {
        this.ten_SP = ten_SP;
    }

    public int getGia_SP() {
        return gia_SP;
    }

    public void setGia_SP(int gia_SP) {
        this.gia_SP = gia_SP;
    }

    public String getId_DonViSanPham() {
        return id_DonViSanPham;
    }

    public void setId_DonViSanPham(String id_DonViSanPham) {
        this.id_DonViSanPham = id_DonViSanPham;
    }

    public String getId_LoaiSanPham() {
        return id_LoaiSanPham;
    }

    public void setId_LoaiSanPham(String id_LoaiSanPham) {
        this.id_LoaiSanPham = id_LoaiSanPham;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
    
}
