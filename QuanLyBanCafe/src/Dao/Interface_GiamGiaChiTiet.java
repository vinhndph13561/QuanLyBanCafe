/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.GiamGiaChiTiet;
/**
 *
 * @author Admin
 */
public interface Interface_GiamGiaChiTiet {
    abstract public void insert(GiamGiaChiTiet ggct);
    abstract public void update(int phanTramGiamGia, String ID_SP);
    abstract public void delete(String ID);
    abstract public List<GiamGiaChiTiet> selectAll();
    abstract public GiamGiaChiTiet selectByID(int ID, String ID_SP);
    abstract public List<GiamGiaChiTiet> selectSQL(String sql, Object... agrs);
}
