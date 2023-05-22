/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String  ma_nhan_vien,ten_nhan_vien,gioi_tinh,so_dien_thoai,email,chuc_vu;
    private String ngaySinh;
    public NhanVien(String ma_nhan_vien, String ten_nhan_vien, String ngaySinh, String gioi_tinh, String so_dien_thoai, String email, String chuc_vu) {
        this.ma_nhan_vien = ma_nhan_vien;
        this.ten_nhan_vien = ten_nhan_vien;
        this.ngaySinh = ngaySinh;
        this.gioi_tinh = gioi_tinh;
        this.so_dien_thoai = so_dien_thoai;
        this.email = email;
        this.chuc_vu = chuc_vu;
    }

    public String getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(String chuc_vu) {
        this.chuc_vu = chuc_vu;
    }
    
    public NhanVien() {}


    public String getMa_nhan_vien() {
        return ma_nhan_vien;
    }

    public void setMa_nhan_vien(String ma_nhan_vien) {
        this.ma_nhan_vien = ma_nhan_vien;
    }

    public String getTen_nhan_vien() {
        return ten_nhan_vien;
    }

    public void setTen_nhan_vien(String ten_nhan_vien) {
        this.ten_nhan_vien = ten_nhan_vien;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
