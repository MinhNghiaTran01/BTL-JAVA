/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.MayTinh;
import com.mycompany.model.NhanVien;
import com.mycompany.model.QuanLy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuanLyDAOImpl implements QuanLyDAO{

    @Override
    public List<QuanLy> getList() {
        String sql = "SELECT * FROM dbo.TaiKhoanDangNhap";
        try (Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall(sql);){
            List<QuanLy> list = new ArrayList<>();
            NhanVienDao nhanVienDAO = new NhanVienDAOImpl();
            List<NhanVien> listNhanVien = nhanVienDAO.getListNhanVien();
            try(ResultSet rs = ps.executeQuery();)
            {
                while(rs.next())
                {
                    QuanLy quanLy = new QuanLy();
                    NhanVien nhanVien = new NhanVien();
                    String maNhanVien = rs.getString("maNhanVien");
                    for(int i=0;i<listNhanVien.size();i++)
                    {
                        if(listNhanVien.get(i).getMa_nhan_vien().equals(maNhanVien))
                        {
                            nhanVien = listNhanVien.get(i);
                            break;
                        }
                    }
                    quanLy.setNhanVien(nhanVien);
                    quanLy.setTenDangNhap(rs.getString("taiKhoan"));
                    quanLy.setMatKhau(rs.getString("matKhau"));
                   
                    list.add(quanLy);
                }
            }
            return list;
        } catch (Exception ex) {}
        return null;
    }
    
}
