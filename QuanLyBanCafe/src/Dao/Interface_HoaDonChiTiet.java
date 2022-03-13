/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.HoaDonChiTiet;
/**
 *
 * @author Admin
 */
public interface Interface_HoaDonChiTiet {
    abstract public void insert(HoaDonChiTiet hdct);
    abstract public void update_TT(HoaDonChiTiet hdct);
    abstract public void update_SL(HoaDonChiTiet hdct);
    abstract public void update_LD(HoaDonChiTiet hdct);
    abstract public void delete(HoaDonChiTiet hdct);
    abstract public List<HoaDonChiTiet> selectAll();
    abstract public HoaDonChiTiet selectByID(int ID_HoaDon, String ID_SP);
    abstract public List<HoaDonChiTiet> selectByID_TT1(int ID_HoaDon, String ID_SP);
    abstract public List<HoaDonChiTiet> selectByID_TT0(int ID_HoaDon, String ID_SP);
    abstract public int selectCountHuyDon(int ID_HoaDon);
    abstract public int selectCount(String sql, Object... agrs);
    abstract public List<HoaDonChiTiet> selectBýQL(String sql, Object... agrs);
}
