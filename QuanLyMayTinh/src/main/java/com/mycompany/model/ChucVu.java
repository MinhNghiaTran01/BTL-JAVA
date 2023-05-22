/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Admin
 */
public class ChucVu {
    private String ma_chuc_vu,ten_chuc_vu,moTa;

    public ChucVu(String ma_chuc_vu, String ten_chuc_vu, String moTa) {
        this.ma_chuc_vu = ma_chuc_vu;
        this.ten_chuc_vu = ten_chuc_vu;
        this.moTa = moTa;
    }

    public ChucVu() {
    }

    public String getMa_chuc_vu() {
        return ma_chuc_vu;
    }

    public void setMa_chuc_vu(String ma_chuc_vu) {
        this.ma_chuc_vu = ma_chuc_vu;
    }

    public String getTen_chuc_vu() {
        return ten_chuc_vu;
    }

    public void setTen_chuc_vu(String ten_chuc_vu) {
        this.ten_chuc_vu = ten_chuc_vu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
}
