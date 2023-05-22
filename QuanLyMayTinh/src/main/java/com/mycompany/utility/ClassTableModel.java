/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utility;

import com.mycompany.model.HoaDonBan;
import com.mycompany.model.HoaDonNhap;
import com.mycompany.model.KhachHang;
import com.mycompany.model.MayTinh;
import com.mycompany.model.NhaCungCap;
import com.mycompany.model.NhanVien;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ClassTableModel {
    private int columns_may_tinh;
    private int columns_nhan_vien;
    private int columns_khach_hang;
    private int columns_hoaDonBan;
    private int columns_hoaDonNhap;
    private int columns_nhaCungCap;
    public DefaultTableModel setTableMayTinh(List<MayTinh> listItem,String[] listColumn){
        columns_may_tinh = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex==6||columnIndex==7) ? Integer.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        MayTinh mayTinh = null;
         for (int i = 0; i < num; i++) {
            mayTinh = listItem.get(i);
            obj = new Object[columns_may_tinh];
            obj[0] = (i + 1);
            obj[1] = mayTinh.getMa_may_tinh();
            obj[2] = mayTinh.getTen_may_tinh();
            obj[3] = mayTinh.getXuat_xu();
            obj[4] = mayTinh.getThoi_gian_bao_hanh();
            obj[5] = mayTinh.getSo_luong();
            obj[6] = mayTinh.getGia_ban();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    public DefaultTableModel setTableNhanVien(List<NhanVien> listItem,String[] listColumn){
        columns_nhan_vien = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex==6||columnIndex==7) ? Integer.class : String.class;
            }
        };
        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        NhanVien nhanVien = null;
         for (int i = 0; i < num; i++) {
            nhanVien = listItem.get(i);
            obj = new Object[columns_nhan_vien];
            obj[0] = (i + 1);
            obj[1] = nhanVien.getMa_nhan_vien();
            obj[2] = nhanVien.getTen_nhan_vien();
            obj[3] = nhanVien.getNgaySinh();
            obj[4] = nhanVien.getGioi_tinh();
            obj[5] = nhanVien.getSo_dien_thoai();
            obj[6] = nhanVien.getEmail();
            obj[7] = nhanVien.getChuc_vu();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    public DefaultTableModel setTableKhachHang(List<KhachHang> listItem,String[] listColumn){
        columns_khach_hang = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        KhachHang khachHang = null;
         for (int i = 0; i < num; i++) {
            khachHang = listItem.get(i);
            obj = new Object[columns_khach_hang];
            obj[0] = (i + 1);
            obj[1] = khachHang.getTenKhachHang();
            obj[2] = khachHang.getSoDienThoai();
            dtm.addRow(obj);
        }
        return dtm;
    }
    
     public DefaultTableModel setTableNhaCungCap(List<NhaCungCap> listItem,String[] listColumn){
        columns_nhaCungCap = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        NhaCungCap nhaCungCap = null;
         for (int i = 0; i < num; i++) {
            nhaCungCap = listItem.get(i);
            obj = new Object[columns_nhaCungCap];
            obj[0] = (i + 1);
            obj[1] = nhaCungCap.getMaNhaCungCap();
            obj[2] = nhaCungCap.getTenNhaCungCap();
            obj[3] = nhaCungCap.getSdtNhaCungCap();
            obj[4] = nhaCungCap.getDiaChi();
            obj[5] = nhaCungCap.getEmail();
            dtm.addRow(obj);
        }
        return dtm;
    }
     
    public DefaultTableModel setTableHoaDonBan(List<HoaDonBan> listItem,String[] listColumn){
        columns_hoaDonBan = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        
        int num = listItem.size();
        HoaDonBan hoaDonBan = null;
        
        for (int i = 0; i < num; i++) {
           hoaDonBan = listItem.get(i);
           obj = new Object[columns_hoaDonBan];
           obj[0] = (i + 1);
           obj[1] = hoaDonBan.getMaHoaDonBan();
           obj[2] = hoaDonBan.getNhan_vien_ban_hang().getMa_nhan_vien();
           obj[3] = hoaDonBan.getNhan_vien_ban_hang().getTen_nhan_vien();
           obj[4] = hoaDonBan.getKhach_mua_hang().getTenKhachHang();
           obj[5] = hoaDonBan.getKhach_mua_hang().getSoDienThoai();
           obj[6] = hoaDonBan.getNgayBan();
           obj[7] = hoaDonBan.getHinh_thuc_thanh_toan();
           dtm.addRow(obj);
       }
        return dtm;
    }
    
    public DefaultTableModel setTableHoaDonNhap(List<HoaDonNhap> listItem,String[] listColumn){
        columns_hoaDonNhap = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        
        int num = listItem.size();
        HoaDonNhap hoaDonNhap = null;
        
        for (int i = 0; i < num; i++) {
           hoaDonNhap =  listItem.get(i);
           obj = new Object[columns_hoaDonNhap];
           obj[0] = (i + 1);
           obj[1] = hoaDonNhap.getMaHoaDonNhap();
           obj[2] = hoaDonNhap.getNhanVien().getMa_nhan_vien();
           obj[3] = hoaDonNhap.getNhanVien().getTen_nhan_vien();
           obj[4] = hoaDonNhap.getNhaCungCap().getMaNhaCungCap();
           obj[5] = hoaDonNhap.getNhaCungCap().getTenNhaCungCap();
           obj[6] = hoaDonNhap.getNgayNhap();
           dtm.addRow(obj);
       }
        return dtm;
    }
    
    public int getColumnsMayTinh(){
        return columns_may_tinh;
    }
    
    public int getColumnsNhanVien(){
        return columns_nhan_vien;
    }
    
    public int getColumnsKhachHang(){
        return columns_khach_hang;
    }
    
    public int getColumnsHoaDonBan(){
        return columns_hoaDonBan;
    }
    
    public int getColumnsHoaDonNhap(){
        return columns_hoaDonNhap;
    }
}
