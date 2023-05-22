/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Admin
 */
public class MayTinh {
    private String ma_may_tinh,ten_may_tinh,xuat_xu,thoi_gian_bao_hanh;
    private int so_luong,gia_ban;

    @Override
    public String toString() {
        return "MayTinh{" + "ma_may_tinh=" + ma_may_tinh + ", ten_may_tinh=" + ten_may_tinh + '}';
    }
    
    public String getMa_may_tinh() {
        return ma_may_tinh;
    }

    public void setMa_may_tinh(String ma_may_tinh) {
        this.ma_may_tinh = ma_may_tinh;
    }

    public String getTen_may_tinh() {
        return ten_may_tinh;
    }

    public void setTen_may_tinh(String ten_may_tinh) {
        this.ten_may_tinh = ten_may_tinh;
    }

    public String getXuat_xu() {
        return xuat_xu;
    }

    public void setXuat_xu(String xuat_xu) {
        this.xuat_xu = xuat_xu;
    }

    public String getThoi_gian_bao_hanh() {
        return thoi_gian_bao_hanh;
    }

    public void setThoi_gian_bao_hanh(String thoi_gian_bao_hanh) {
        this.thoi_gian_bao_hanh = thoi_gian_bao_hanh;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }
    
}
