/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.LoaiSanPham;
/**
 *
 * @author Admin
 */
public interface Interface_LoaiSP {
    abstract public void insert(LoaiSanPham loaiSP);
    abstract public void update(LoaiSanPham loaiSP);
    abstract public void delete(String ID_loaiSP);
    abstract public List<LoaiSanPham> selectAll();
    abstract public LoaiSanPham selectByID(String ID_LoaiSP);
    abstract public List<LoaiSanPham> selectBySQL(String sql, Object... agrs);
}
