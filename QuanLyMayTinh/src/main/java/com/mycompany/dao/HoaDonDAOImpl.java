/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.HoaDonBan;
import com.mycompany.model.KhachHang;
import com.mycompany.model.MayTinh;
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
public class HoaDonDAOImpl implements HoaDonDAO{

    @Override
    public List<HoaDonBan> getList() {
        String sql = "SELECT * FROM dbo.Danh_sach_hoa_don";
        try (Connection c = DBConnect.getConnection();
            PreparedStatement ps = c.prepareCall(sql);){
            List<HoaDonBan> list = new ArrayList<>();
            
            try(ResultSet rs = ps.executeQuery();)
            {
                KhachHangDAO khachHangDAO = new KhachHangDAOImpl();
                List<KhachHang> listKhachHang = khachHangDAO.getList();

                NhanVienDao nhanVienDAO = new NhanVienDAOImpl();
                List<NhanVien> listNhanVien = nhanVienDAO.getListNhanVien();
                while(rs.next())
                {
                    HoaDonBan hoa_Don_Ban = new HoaDonBan();
                    NhanVien nhan_vien = new NhanVien();
                    KhachHang khachHang = new KhachHang();
                    
                    String maNhanVien = rs.getString("ma_nhan_vien");
                    String SDTkhachHang = rs.getString("so_dien_thoai_khachHang");
                    
                    for(int i=0;i<listKhachHang.size();i++)
                    {
                        if(listKhachHang.get(i).getSoDienThoai().equals(SDTkhachHang)){
                            khachHang = listKhachHang.get(i);
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
                    
                    String ngayBan = rs.getString("ngay_ban").toString();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayBan);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    hoa_Don_Ban.setMaHoaDonBan( rs.getString("ma_hoa_don") );
                    hoa_Don_Ban.setNhan_vien_ban_hang(nhan_vien);
                    hoa_Don_Ban.setKhach_mua_hang(khachHang);
                    hoa_Don_Ban.setNgayBan(sdf.format(date));
                    hoa_Don_Ban.setHinh_thuc_thanh_toan( rs.getString("hinh_thuc_thanh_toan") );
                    list.add(hoa_Don_Ban);
                }
            }
            return list;
        } catch (Exception ex) {System.out.println(ex.getMessage());}
        return null;
    }
//    public static void main(String[] args) {
//        HoaDonDAO hdd = new HoaDonDAOImpl();
//        System.out.println(hdd.getList());
//    }
}
