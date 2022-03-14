/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author vinhn
 */
public class Ban {
    private int ID_Ban, soLuongCho;
    private boolean trangThai,hoatDong;

    public Ban() {
    }

    public Ban(int ID_Ban, int soLuongCho, boolean trangThai, boolean hoatDong) {
        this.ID_Ban = ID_Ban;
        this.soLuongCho = soLuongCho;
        this.trangThai = trangThai;
        this.hoatDong = hoatDong;
    }

    public int getID_Ban() {
        return ID_Ban;
    }

    public void setID_Ban(int ID_Ban) {
        this.ID_Ban = ID_Ban;
    }

    public int getSoLuongCho() {
        return soLuongCho;
    }

    public void setSoLuongCho(int soLuongCho) {
        this.soLuongCho = soLuongCho;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(boolean hoatDong) {
        this.hoatDong = hoatDong;
    }
    
    
}
