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
public class HoaDonChiTiet {
    private int ID_HoaDon;
    private String ID_SanPham;
    private int soLuong;
    private int gia;
    private int tongGia;
    private boolean trangThai;
    private String lyDoHuy;
    private String ghiChu;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int ID_HoaDon, String ID_SanPham, int soLuong, int gia, int tongGia, boolean trangThai, String lyDoHuy, String ghiChu) {
        this.ID_HoaDon = ID_HoaDon;
        this.ID_SanPham = ID_SanPham;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tongGia = tongGia;
        this.trangThai = trangThai;
        this.lyDoHuy = lyDoHuy;
        this.ghiChu = ghiChu;
    }

    public int getID_HoaDon() {
        return ID_HoaDon;
    }

    public void setID_HoaDon(int ID_HoaDon) {
        this.ID_HoaDon = ID_HoaDon;
    }

    public String getID_SanPham() {
        return ID_SanPham;
    }

    public void setID_SanPham(String ID_SanPham) {
        this.ID_SanPham = ID_SanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getTongGia() {
        return tongGia;
    }

    public void setTongGia(int tongGia) {
        this.tongGia = tongGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getLyDoHuy() {
        return lyDoHuy;
    }

    public void setLyDoHuy(String lyDoHuy) {
        this.lyDoHuy = lyDoHuy;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
