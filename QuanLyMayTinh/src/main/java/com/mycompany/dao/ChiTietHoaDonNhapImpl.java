/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.ChiTietHoaDonNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonNhapImpl implements ChiTietHoaDonNhapDAO{

    @Override
    public List<ChiTietHoaDonNhap> getList() {
        String sql = "SELECT maHoaDonNhap FROM dbo.ChiTietHoaDonNhap";
        try (Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall(sql);){
            List<ChiTietHoaDonNhap> list = new ArrayList<>();
            
            try(ResultSet rs = ps.executeQuery();)
            {
                while(rs.next())
                {
                    ChiTietHoaDonNhap chiTietHoaDonNhap = new ChiTietHoaDonNhap();
                    chiTietHoaDonNhap.setMaHoaDonNhap(rs.getString("maHoaDonNhap"));
                    list.add(chiTietHoaDonNhap);
                }
            }
            return list;
        } catch (Exception ex) {System.out.println(ex.getMessage());}
        return null;
    }
    
}
