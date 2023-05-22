/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.ChiTietHoaDon;
import com.mycompany.model.HoaDonBan;
import com.mycompany.model.KhachHang;
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
public class ChiTietHoaDonImpl implements ChiTietHoaDonDAO{

    @Override
    public List<ChiTietHoaDon> getList() {
        String sql = "SELECT maHoaDon FROM dbo.ChiTietHoaDon";
        try (Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall(sql);){
            List<ChiTietHoaDon> list = new ArrayList<>();
            
            try(ResultSet rs = ps.executeQuery();)
            {
                while(rs.next())
                {
                    ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                    chiTietHoaDon.setMaHoaDonBan(rs.getString("maHoaDon"));
                    list.add(chiTietHoaDon);
                }
            }
            return list;
        } catch (Exception ex) {System.out.println(ex.getMessage());}
        return null;
    }
    
}
