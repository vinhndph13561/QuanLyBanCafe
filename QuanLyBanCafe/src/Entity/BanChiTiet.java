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
public class BanChiTiet {
    private int ID_HoaDon;
    private int ID_Ban;
    private Date thoiDiemCoNguoi;
    private boolean  banChinh;

    public BanChiTiet() {
    }

    public BanChiTiet(int ID_HoaDon, int ID_Ban, Date thoiDiemCoNguoi, boolean banChinh) {
        this.ID_HoaDon = ID_HoaDon;
        this.ID_Ban = ID_Ban;
        this.thoiDiemCoNguoi = thoiDiemCoNguoi;
        this.banChinh = banChinh;
    }

    public int getID_HoaDon() {
        return ID_HoaDon;
    }

    public void setID_HoaDon(int ID_HoaDon) {
        this.ID_HoaDon = ID_HoaDon;
    }

    public int getID_Ban() {
        return ID_Ban;
    }

    public void setID_Ban(int ID_Ban) {
        this.ID_Ban = ID_Ban;
    }

    public Date getThoiDiemCoNguoi() {
        return thoiDiemCoNguoi;
    }

    public void setThoiDiemCoNguoi(Date thoiDiemCoNguoi) {
        this.thoiDiemCoNguoi = thoiDiemCoNguoi;
    }

    public boolean isBanChinh() {
        return banChinh;
    }

    public void setBanChinh(boolean banChinh) {
        this.banChinh = banChinh;
    }
    
    
}
