/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.DanhMucBean.DanhMucBean;
import com.mycompany.view.QuanLyHoaDonBan;
import com.mycompany.view.QuanLyHoaDonNhap;
import com.mycompany.view.QuanLyNhanVien;
import com.mycompany.view.QuanLySanPham;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem;
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem,JLabel jlbItem){
        jpnItem.setBackground(Color.RED);
        jlbItem.setBackground(Color.WHITE);
        kindSelected = "QuanLySanPham";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new QuanLySanPham());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        listItem.forEach( (item) -> item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb() )));
    }
    
    class LabelEvent implements MouseListener{
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "QuanLySanPham":
                    node = new QuanLySanPham();
                    break;
                case "QuanLyNhanVien":
                    node = new QuanLyNhanVien();
                    break;
                case "QuanLyHoaDonBan":
                    node = new QuanLyHoaDonBan();
                    break;
                case "QuanLyHoaDonNhap":
                    node = new QuanLyHoaDonNhap();
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(Color.WHITE);
            jlbItem.setForeground(Color.RED);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(Color.WHITE);
            jlbItem.setForeground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(Color.RED);
                jlbItem.setForeground(Color.WHITE);
            }
        }
        public void setChangeBackgroud(String kind)
        {
            for(DanhMucBean item: listItem)
            {
                if(!item.getKind().equalsIgnoreCase(kind)){
                    item.getJpn().setBackground(Color.RED);
                    item.getJlb().setForeground(Color.WHITE);
                }
                else
                {
                    item.getJpn().setBackground(Color.WHITE);
                    item.getJlb().setForeground(Color.RED);
                }   
            }
                
        }
    }
}
