/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String tenKhachHang,soDienThoai;

    public KhachHang(String tenKhachHang, String soDienThoai) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
    }

    public KhachHang() {
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    
    
    
}
