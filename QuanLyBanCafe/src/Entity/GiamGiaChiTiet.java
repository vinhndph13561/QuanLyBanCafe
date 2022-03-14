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
public class GiamGiaChiTiet {
    private int idGiamGia;
    private String idSP;
    private int phanTramGiam;

    public GiamGiaChiTiet() {
    }

    public GiamGiaChiTiet(int idGiamGia, String idSP, int phanTramGiam) {
        this.idGiamGia = idGiamGia;
        this.idSP = idSP;
        this.phanTramGiam = phanTramGiam;
    }

    public int getIdGiamGia() {
        return idGiamGia;
    }

    public void setIdGiamGia(int idGiamGia) {
        this.idGiamGia = idGiamGia;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }
    
    
}
