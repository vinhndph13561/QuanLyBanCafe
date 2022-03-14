/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.HoaDon;
import java.util.Date;
/**
 *
 * @author Admin
 */
public interface Interface_HoaDon {
    abstract public void insert(HoaDon hd);
    abstract public void updateThanhToan(HoaDon hd);
    abstract public void updateTrangThai(HoaDon hd);
    abstract public void updateThanhTien(HoaDon hd);
    abstract public void updateLyDoHuy(HoaDon hd);
    abstract public void updateSLHuy(HoaDon hd);
    abstract public void delete(HoaDon hd);
    abstract public List<HoaDon> selectByID(int ID);
    abstract public List<HoaDon> selectAll_TrangThai1();
    abstract public List<HoaDon> selectAll_TrangThai0();
    abstract public List<HoaDon> selectAll_HoatDong_Date(Date a, Date b);
    abstract public List<HoaDon> selectAll_HoatDong_Keyword(String key);
    abstract public List<HoaDon> selectAll_HoatDong_KeyID_maNV(String keyID_maNV);
    abstract public List<HoaDon> selectAll_KhongHoatDong_Date(Date a, Date b);
    abstract public List<HoaDon> selectAll_KhongHoatDong_Keyword(String key);
    abstract public List<HoaDon> selectAll_KhongHoatDong_KeyID_maNV(String keyID_maNV);
    abstract public List<HoaDon> selectAll_HoatDong_1Day(Date a);
    abstract public List<HoaDon> selectAll_KhongHoatDong_1Day(Date a);
    abstract public List<HoaDon> selectBySQL(String sql, Object... agrs);
}
