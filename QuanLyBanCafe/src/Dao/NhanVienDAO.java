/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.NhanVien;
import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pham Quoc Huy
 */
public class NhanVienDAO implements InterfaceNhanVien {

    String INSERT_SQL = "INSERT dbo.NhanVien VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien set TenNV = ?,Gender = ?,Ngaysinh = ?,Diachi = ?,Email = ?,SDT=?, Username = ?,Pass=?,Vaitro = ?,Trangthai = ?,Hinh = ? where ID_Nhanvien = ?";
    String DELETE_SQL = "UPDATE NhanVien set Trangthai = 0 WHERE ID_Nhanvien=?";
    String SELECT_ALL_SQL = "select * from NhanVien ";
    String SELECT_BY_ID_SQL = "select * from NhanVien where ID_Nhanvien = ?";
    String SELECT_BY_ACCOUNT_SQL = "select * from NhanVien where Username = ?";
    String SELECT_TrangThai1 = "select * from NhanVien where Trangthai = 0";
    String SELECT_TrangThai2 = "select * from NhanVien where Trangthai = 1";

    public List<NhanVien> selectAll;

    @Override
    public void insert(NhanVien Entity) {
       JDBCHelper.update(INSERT_SQL, Entity.getId_Nhanvien(), Entity.getTenNV(), Entity.isGender(), Entity.getNgaysinh(),
                Entity.getDiaChi(), Entity.getEmail(), Entity.getSDT(), Entity.getUserName(), Entity.getPass(), Entity.isVaiTro(), Entity.isTrangThai(), Entity.getHinh());
    }

    @Override
    public void update(NhanVien Entity) {
        JDBCHelper.update(UPDATE_SQL, Entity.getTenNV(), Entity.isGender(), Entity.getNgaysinh(), Entity.getDiaChi(), Entity.getEmail(),
                Entity.getSDT(), Entity.getUserName(),Entity.getPass(), Entity.isVaiTro(), Entity.isTrangThai(), Entity.getHinh(), Entity.getId_Nhanvien());
    }

    @Override
    public void delete(String id) {
       JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    @Override
    public NhanVien selectByAccount(String account) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ACCOUNT_SQL, account);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                NhanVien Entity = new NhanVien();
                Entity.setId_Nhanvien(rs.getString("ID_Nhanvien"));
                Entity.setTenNV(rs.getString("TenNV"));
                Entity.setGender(rs.getBoolean("Gender"));
                Entity.setNgaysinh(rs.getDate("Ngaysinh"));
                Entity.setDiaChi(rs.getString("Diachi"));
                Entity.setEmail(rs.getString("Email"));
                Entity.setSDT(rs.getString("SDT"));
                Entity.setUserName(rs.getString("Username"));
                Entity.setPass(rs.getString("Pass"));
                Entity.setVaiTro(rs.getBoolean("Vaitro"));
                Entity.setTrangThai(rs.getBoolean("Trangthai"));
                Entity.setHinh(rs.getString("Hinh"));
                list.add(Entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<NhanVien> select_TrangThai1(){
        return selectBySql(SELECT_TrangThai1);
    }
    public List<NhanVien> select_TrangThai2(){
        return selectBySql(SELECT_TrangThai2);
    }
    public List<NhanVien> selectByKeyword(String keyword){
        String sql = "SELECT * FROM NhanVien WHERE TenNV LIKE ? and Trangthai = 1 ";
        return selectBySql(sql, "%"+keyword+"%");
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(ID_Nhanvien,3,LEN(ID_Nhanvien))as int)) from  NhanVien ";
            ResultSet rs = JDBCHelper.query(sql);
            while (rs.next()) {
             return rs.getInt(1);                              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0 ;
    }
    public List<NhanVien> selectALLL(){
        return selectBySql(SELECT_ALL_SQL) ;
    }
    /// 
    public String  selectNameStaff(){
        String sql = "select  *  from nhanvien";
        return selectBySql(sql).get(0).getId_Nhanvien();
    }
     public String selectByEmail(String maill) {

        try {
            String sql_email = "select Email from nhanvien where Email = '" + maill + "'";
            ResultSet rs = JDBCHelper.query(sql_email);
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //
       public void  updatePass(String pass, String idnv){
         String sql  = "update NHANVIEN SET Pass = ? where ID_NHANVIEN = ?";
         JDBCHelper.update(sql,pass,idnv);
     }
}
