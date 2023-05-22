/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.HoaDonDAO;
import com.mycompany.dao.HoaDonDAOImpl;
import com.mycompany.model.HoaDonBan;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonBanServiceImpl implements HoaDonBanService{
    private HoaDonDAO hoaDonDAO = null;

    public HoaDonBanServiceImpl() {
       hoaDonDAO  = new HoaDonDAOImpl();
    }
    
    @Override
    public List<HoaDonBan> getList() {
        return hoaDonDAO.getList();
    }
    
}
