/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAOImpl implements NhanVienDao{

    @Override
    public List<NhanVien> getListNhanVien() {
        String sql = "SELECT * FROM dbo.Nhan_vien";
        
        try (Connection c = DBConnect.getConnection();){
            
            PreparedStatement ps = c.prepareCall(sql);
            List<NhanVien> list = new ArrayList<>();
            try(ResultSet rs = ps.executeQuery();)
            {
                
                while(rs.next())
                {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("ngay_sinh"));
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    NhanVien nv = new NhanVien();
                    nv.setMa_nhan_vien(rs.getString("ma_nhan_vien"));
                    nv.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
                    nv.setNgaySinh(sdf.format(date));
                    nv.setGioi_tinh(rs.getString("gioi_tinh"));
                    nv.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                    nv.setEmail(rs.getString("email"));
                    nv.setChuc_vu(rs.getString("chuc_vu"));
                    list.add(nv);
                }
            }
            ps.close();
            return list;
        } catch (Exception ex) {System.out.println(ex.getMessage());}
        return null;
    }
    public static void main(String[] args) {
        NhanVienDao nhanVienDao = new NhanVienDAOImpl();
        System.out.println(nhanVienDao.getListNhanVien());
    }
}
