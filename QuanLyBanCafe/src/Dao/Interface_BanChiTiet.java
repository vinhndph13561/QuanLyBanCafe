/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.BanChiTiet;
/**
 *
 * @author Admin
 */
public interface Interface_BanChiTiet {
    abstract public void insert(BanChiTiet bct);
    abstract public void update(int ID_Ban, int ID_HoaDon);
    abstract public void insert(int ID_Ban);
    abstract public List<BanChiTiet> selectAll();
    abstract public BanChiTiet selectByID(int ID_Ban, int ID_HoaDon);
    abstract public List<BanChiTiet> selectByIDBan(int ID_Ban);
    abstract public List<BanChiTiet> selectByIDHoaDon(int ID_HoaDon);
    abstract public List<BanChiTiet> selectBySQL(String sql, Object... agrs);
}
