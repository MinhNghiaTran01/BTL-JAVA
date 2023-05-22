/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.KhachHang;
import com.mycompany.service.KhachHangService;
import com.mycompany.service.KhachHangServiceImpl;
import com.mycompany.utility.ClassTableModel;
import com.mycompany.view.QuanLyKhachHang;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class QuanLyKhachHangController {
    List<KhachHang> listItem;
    private JTable table;
    private static DefaultTableModel model;
    private JTextField txtTenKhachHang = new JTextField();
    private JTextField txtSoDienThoai = new JTextField();
    private JPanel jpnView;
    private ClassTableModel classTableModel = null;
    private KhachHangService khachHangSevice = null;
    private final String[] COLUMNS = {"STT","Tên khách hàng", "Số điện thoại"};
//    private int check_QLKH=0;
    public QuanLyKhachHangController(JTextField txtTenKhachHang,JTextField txtSoDienThoai, JPanel jpnView) {
        this.txtTenKhachHang = txtTenKhachHang;
        this.txtSoDienThoai = txtSoDienThoai;
        this.jpnView = jpnView;
        this.khachHangSevice = new KhachHangServiceImpl();
        this.classTableModel = new ClassTableModel();
    }

    public QuanLyKhachHangController(JPanel jpnView) {
        this.jpnView = jpnView;
        this.khachHangSevice = new KhachHangServiceImpl();
        this.classTableModel = new ClassTableModel();
//        check_QLKH = 1;
    }
    
    public void setDataToTable() {
        listItem = khachHangSevice.getList();
        model = classTableModel.setTableKhachHang(listItem, COLUMNS);
        model.fireTableDataChanged();
        table = new JTable(model);
        DefaultTableCellRenderer centerrender = new DefaultTableCellRenderer();

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        //table.getTableHeader().setPreferredSize(new Dimension(30, 30));
        table.setRowHeight(20);
        table.validate();
        table.repaint();
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2&&table.getSelectedRow()!=-1)
                {
//                    System.out.println("-1");
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int SelectedRowIndex = table.getSelectedRow();
                    SelectedRowIndex = table.convertColumnIndexToModel(SelectedRowIndex);
                    
                    txtTenKhachHang.setText(model.getValueAt(SelectedRowIndex, 1).toString());
                    txtSoDienThoai.setText(model.getValueAt(SelectedRowIndex, 2).toString());
                    setRowSua(SelectedRowIndex);
                }
            }
        });
        
          centerrender.setHorizontalAlignment( JLabel.CENTER );
        
        table.getColumnModel().getColumn(0).setCellRenderer( centerrender );
        
          DefaultTableCellRenderer rightrender = new DefaultTableCellRenderer();
          rightrender.setHorizontalAlignment( JLabel.LEFT );
        table.getColumnModel().getColumn(1).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(2).setCellRenderer( rightrender );
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1110,296));
//        scroll.validate();
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    
    private int Row;
    public void setRowSua(int Row){
        this.Row = Row;
    }
    public int getRowSua(){
        return this.Row;
    }
    
    
    public JTable getTable(){
        return table;
    }
    
    public List<KhachHang> getListKhachHang(){
        return this.listItem;
    }
    

    public String[] getColumnName() {
        return COLUMNS;
    }
}
