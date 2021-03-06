/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *

 */
public class NhanVien {
    private String id_Nhanvien; 
    private String TenNV;
    private boolean GIOITINH;
    private Date Ngaysinh;
    private String DiaChi;
    private String Email;
    private String SDT;
    private String userName;
    private String Pass;
    private boolean VaiTro;
    private boolean TrangThai;
    private String Hinh;

    public NhanVien() {
    }

    public NhanVien(String id_Nhanvien, String TenNV, boolean GIOITINH, Date Ngaysinh, String DiaChi, String Email, String SDT, String userName, String Pass, boolean VaiTro, boolean TrangThai, String Hinh) {
        this.id_Nhanvien = id_Nhanvien;
        this.TenNV = TenNV;
        this.GIOITINH = GIOITINH;
        this.Ngaysinh = Ngaysinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SDT = SDT;
        this.userName = userName;
        this.Pass = Pass;
        this.VaiTro = VaiTro;
        this.TrangThai = TrangThai;
        this.Hinh = Hinh;
    }

    public String getId_Nhanvien() {
        return id_Nhanvien;
    }

    public void setId_Nhanvien(String id_Nhanvien) {
        this.id_Nhanvien = id_Nhanvien;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public boolean isGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(boolean GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

  
}
