/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhaCungCapDAOImpl implements NhaCungCapDAO{

    @Override
    public List<NhaCungCap> getList() {
        String sql = "SELECT * FROM dbo.nhaCungCap";
        try (Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall(sql);){
            List<NhaCungCap> list = new ArrayList<>();
            
            try(ResultSet rs = ps.executeQuery();)
            {
                while(rs.next())
                {
                    NhaCungCap nhaCungCap = new NhaCungCap();
                    nhaCungCap.setMaNhaCungCap(rs.getString("maNhaCungCap") );
                    nhaCungCap.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
                    nhaCungCap.setSdtNhaCungCap(rs.getString("sdtNhaCungCap"));
                    nhaCungCap.setDiaChi(rs.getString("diaChi"));
                    nhaCungCap.setEmail(rs.getString("email") );
                    list.add(nhaCungCap);
                }
            }
            return list;
        } catch (Exception ex) {System.out.println(ex.getMessage());}
        return null;
    }
    
}
