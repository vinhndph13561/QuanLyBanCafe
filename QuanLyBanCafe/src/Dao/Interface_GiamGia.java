/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.GiamGia;
/**
 *
 * @author Admin
 */
public interface Interface_GiamGia {
    abstract public void insert(GiamGia gg);
    abstract public void update(GiamGia gg);
    abstract public void delete(String ID_GiamGia);
    abstract public List<GiamGia> selectAll();
    abstract public GiamGia selectByID(String ID_GiamGia);
    abstract public GiamGia selectByName(String tenSuKien);
    abstract public List<GiamGia> selectBySQL(String sql, Object... agrs);
}
