/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.model.MayTinh;
import com.mycompany.dao.MayTinhDAO;
import com.mycompany.dao.MayTinhDAOImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MayTinhServiceImpl implements MayTinhService {
    private MayTinhDAO mayTinhDAO = null;

    public MayTinhServiceImpl() {
        mayTinhDAO = new MayTinhDAOImpl();
    }
    
    @Override
    public List<MayTinh> getList() {
        return mayTinhDAO.getList();
    }
    
}
