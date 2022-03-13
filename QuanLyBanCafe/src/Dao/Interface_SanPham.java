/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.SanPham;
/**
 *
 * @author Admin
 */
public interface Interface_SanPham {
    abstract public void insert(SanPham sp);
    abstract public void update(SanPham sp);
    abstract public void delete(String ID_SP);
    abstract public List<SanPham> selectAll();
    abstract public SanPham selectByID(String ID_SP);
    abstract public List<SanPham> selectBySQL(String sql, Object... agrs);
}
