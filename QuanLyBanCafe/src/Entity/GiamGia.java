/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author congc
 */
public class GiamGia {
    private int id_GiamGia;
    private String tenSuKien;
    private String idNhanVien;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public GiamGia() {
    }

    public GiamGia(int id_GiamGia, String tenSuKien, String idNhanVien, Date ngayBatDau, Date ngayKetThuc) {
        this.id_GiamGia = id_GiamGia;
        this.tenSuKien = tenSuKien;
        this.idNhanVien = idNhanVien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getId_GiamGia() {
        return id_GiamGia;
    }

    public void setId_GiamGia(int id_GiamGia) {
        this.id_GiamGia = id_GiamGia;
    }

    public String getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(String tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    
    
}
