/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.util.List;
import Entity.DonViDoUong;
/**
 *
 * @author Admin
 */
public interface Interface_DonViDoUong {
    abstract public void insert(DonViDoUong dvdu);
    abstract public void update(DonViDoUong dvdu);
    abstract public void delete(String ID_DonViSP);
    abstract public List<DonViDoUong> selectAll();
    abstract public DonViDoUong selectByID(String ID_DonViSP);
    abstract public List<DonViDoUong> selectBySQL(String sql, Object... agrs);
}
