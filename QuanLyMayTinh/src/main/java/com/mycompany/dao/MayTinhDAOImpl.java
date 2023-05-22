/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.MayTinh;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class MayTinhDAOImpl implements MayTinhDAO{

    @Override
    public List<MayTinh> getList() {
        String sql = "SELECT * FROM dbo.SanPham";
        try (Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall(sql);){
            List<MayTinh> list = new ArrayList<>();
            
            try(ResultSet rs = ps.executeQuery();)
            {
                while(rs.next())
                {
                    MayTinh mt = new MayTinh();
                    mt.setMa_may_tinh(rs.getString("ma_may_tinh"));
                    mt.setTen_may_tinh(rs.getString("ten_may_tinh"));
                    mt.setXuat_xu(rs.getString("xuat_xu"));
                    mt.setThoi_gian_bao_hanh(rs.getString("thoi_gian_bao_hanh"));
                    mt.setSo_luong(rs.getInt("so_luong"));
                    mt.setGia_ban(rs.getInt("gia_ban"));
                    list.add(mt);
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
//        MayTinhDAO mayTinhDao = new MayTinhDAOImpl();
//        System.out.println(mayTinhDao.getList());
//    }
    
}
