/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.HoaDonNhap;
import com.mycompany.model.MayTinh;
import com.mycompany.model.NhaCungCap;
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
public class HoaDonNhapDAOImpl implements HoaDonNhapDAO{

    @Override
    public List<HoaDonNhap> getList() {
        String sql = "SELECT * FROM dbo.DanhSachHoaDonNhap ";
               
        try (Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall(sql);){
            List<HoaDonNhap> list = new ArrayList<>();
            
            try(ResultSet rs = ps.executeQuery();)
            {
                
               
                NhanVienDao nhanVienDAO = new NhanVienDAOImpl();
                List<NhanVien> listNhanVien = nhanVienDAO.getListNhanVien();
                
                NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
                List<NhaCungCap> listNhaCungCap = nhaCungCapDAO.getList();
                
                while(rs.next())
                {
                    HoaDonNhap hoaDonNhap = new HoaDonNhap();
                    NhanVien nhan_vien = new NhanVien();
                    NhaCungCap nhaCungCap = new NhaCungCap();
                    
                    
                    String maNhanVien = rs.getString("maNhanVien");
                    String maNhaCungCap = rs.getString("maNhaCungCap");
                    
                    for(int i=0;i<listNhaCungCap.size();i++)
                    {
                        if(listNhaCungCap.get(i).getMaNhaCungCap().equals(maNhaCungCap)){
                            nhaCungCap = listNhaCungCap.get(i);
                            break;
                        }
                    }
                    
                    for(int i=0;i<listNhanVien.size();i++)
                    {
                        if(listNhanVien.get(i).getMa_nhan_vien().equals(maNhanVien)){
                            nhan_vien = listNhanVien.get(i);
                            break;
                        }
                    }
                    
                    String ngayNhap = rs.getString("ngayNhap").toString();
                    hoaDonNhap.setMaHoaDonNhap( rs.getString("maHoaDonNhap") );
                    hoaDonNhap.setNhanVien(nhan_vien);
                    hoaDonNhap.setNhaCungCap(nhaCungCap);
                    hoaDonNhap.setNgayNhap(ngayNhap);
                    list.add(hoaDonNhap);
                }
            }
            return list;
        } catch (Exception ex) {System.out.println(ex.getMessage() + "1232");}
        return null;
    }
    
}
