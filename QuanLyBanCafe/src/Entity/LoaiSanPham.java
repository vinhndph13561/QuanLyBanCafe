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
public class LoaiSanPham {
    private String ID_LoaiSP;
    private  String tenLoai;

    public LoaiSanPham() {
    }

    public LoaiSanPham(String ID_LoaiSP, String tenLoai) {
        this.ID_LoaiSP = ID_LoaiSP;
        this.tenLoai = tenLoai;
    }

    public String getID_LoaiSP() {
        return ID_LoaiSP;
    }

    public void setID_LoaiSP(String ID_LoaiSP) {
        this.ID_LoaiSP = ID_LoaiSP;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    
    
}
