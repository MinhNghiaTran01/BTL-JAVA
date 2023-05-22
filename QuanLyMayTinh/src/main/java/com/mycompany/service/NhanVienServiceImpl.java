/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.NhanVienDAOImpl;
import com.mycompany.dao.NhanVienDao;
import com.mycompany.model.NhanVien;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienServiceImpl implements NhanVienService{
    private NhanVienDao nhanVienDAO = null;

    public NhanVienServiceImpl() {
        nhanVienDAO = new NhanVienDAOImpl();
    }
            
    @Override
    public List<NhanVien> getListNhanVien() {
        return nhanVienDAO.getListNhanVien();
    }
    
}
