/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.ChucVu;
import com.mycompany.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChucVuDAOImpl implements ChucVuDAO{

    @Override
    public List<ChucVu> getList() {
        String sql = "SELECT * FROM dbo.Chuc_vu";
        
        try (Connection c = DBConnect.getConnection();){
            
            PreparedStatement ps = c.prepareCall(sql);
            List<ChucVu> list = new ArrayList<>();
            try(ResultSet rs = ps.executeQuery();)
            {
                
                while(rs.next())
                {
                    ChucVu CV = new ChucVu();
                    CV.setTen_chuc_vu(rs.getString("ten_chuc_vu"));
                    list.add(CV);
                }
            }
            ps.close();
            return list;
        } catch (Exception ex) {System.out.println(ex.getMessage());}
        return null;
    }
//    public static void main(String[] args) {
//        ChucVuDAO CVD = new ChucVuDAOImpl();
//        System.out.println(CVD.getList());
//    }
    
}
