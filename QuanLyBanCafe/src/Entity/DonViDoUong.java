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
public class DonViDoUong {
    private String ID_DonviSP;
    private String tenDonVi;
    private int kichThuoc;

    public DonViDoUong() {
    }

    public DonViDoUong(String ID_DonviSP, String tenDonVi, int kichThuoc) {
        this.ID_DonviSP = ID_DonviSP;
        this.tenDonVi = tenDonVi;
        this.kichThuoc = kichThuoc;
    }

    public String getID_DonviSP() {
        return ID_DonviSP;
    }

    public void setID_DonviSP(String ID_DonviSP) {
        this.ID_DonviSP = ID_DonviSP;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public int getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(int kichThuoc) {
        this.kichThuoc = kichThuoc;
    }
    
}
