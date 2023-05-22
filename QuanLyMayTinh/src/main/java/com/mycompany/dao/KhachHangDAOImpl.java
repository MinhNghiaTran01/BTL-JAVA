/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.KhachHang;
import com.mycompany.model.MayTinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangDAOImpl implements KhachHangDAO{
    @Override
    public List<KhachHang> getList() {
        String sql = "SELECT * FROM dbo.KhachHang";
        try (Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall(sql);){
            List<KhachHang> list = new ArrayList<>();
            
            try(ResultSet rs = ps.executeQuery();)
            {
                while(rs.next())
                {
                    KhachHang KH = new KhachHang();
                    KH.setTenKhachHang(rs.getString("ten_khach_hang"));
                    KH.setSoDienThoai(rs.getString("so_dien_thoai"));
                    list.add(KH);
                }
                rs.close();
            }
            c.close();
            ps.close();
            return list;
        } catch (Exception ex) {}
        return null;
    }
        
//    public static void main(String[] args) {
//        KhachHangDAO KHDao = new KhachHangDAOImpl();
//        System.out.println(KHDao.getList());
//    }
}
