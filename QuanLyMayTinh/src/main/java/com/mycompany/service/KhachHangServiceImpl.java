/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.KhachHangDAO;
import com.mycompany.dao.KhachHangDAOImpl;
import com.mycompany.dao.MayTinhDAOImpl;
import com.mycompany.model.KhachHang;
import com.mycompany.model.MayTinh;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangDAO khachHangDAO = null;

    public KhachHangServiceImpl() {
       khachHangDAO  = new KhachHangDAOImpl();
    }
    
    @Override
    public List<KhachHang> getList() {
        return khachHangDAO.getList();
    }
}
