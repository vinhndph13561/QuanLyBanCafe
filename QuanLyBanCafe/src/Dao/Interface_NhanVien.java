/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.NhanVien;
/**
 *
 * @author Admin
 */
public interface Interface_NhanVien {
    abstract public void insert(NhanVien nv);
    abstract public void update(NhanVien nv);
    abstract public void delete(String ID_NhanVien);
    abstract public List<NhanVien> selectAll();
    abstract public NhanVien selectByID(String ID_NhanVien);
    abstract public NhanVien selectByAccout(String accout);
    abstract public List<NhanhVien> selectBySQL(String sql, Object... agrs);
}
