/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.dao.NhaCungCapDAO;
import com.mycompany.dao.NhaCungCapDAOImpl;
import com.mycompany.model.NhaCungCap;
import com.mycompany.utility.ClassTableModel;
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

/**
 *
 * @author Admin
 */
public class QuanLyNhaCungCapController {
    List<NhaCungCap> listItem;
    private JTable table;
    private static DefaultTableModel model;
    private JTextField txtMaNhaCungCap = new JTextField();
    private JTextField txtTenNhaCungCap = new JTextField();
    private JTextField txtSDTnhaCungCap = new JTextField();
    private JTextField txtDiaChiNhaCungCap = new JTextField();
    private JTextField txtEmailNhaCungCap = new JTextField();
    private JPanel jpnView;
    private ClassTableModel classTableModel = null;
    private NhaCungCapDAO nhaCungCapDAO = null;
    private final String[] COLUMNS = {"STT","Mã nhà cung cấp", "Tên nhà cung cấp","Số điện thoại","Địa chỉ","Email"};
//    private int check_QLKH=0;
    public QuanLyNhaCungCapController(JTextField txtMaNhaCungCap,JTextField txtTenNhaCungCap,JTextField txtSDTnhaCungCap,JTextField txtDiaChiNhaCungCap,JTextField txtEmailNhaCungCap, JPanel jpnView) {
        this.txtMaNhaCungCap = txtMaNhaCungCap;
        this.txtTenNhaCungCap = txtTenNhaCungCap;
        this.txtSDTnhaCungCap = txtSDTnhaCungCap;
        this.txtDiaChiNhaCungCap = txtDiaChiNhaCungCap;
        this.txtEmailNhaCungCap = txtEmailNhaCungCap;
        this.jpnView = jpnView;
        this.nhaCungCapDAO = new NhaCungCapDAOImpl();
        this.classTableModel = new ClassTableModel();
    }

    public QuanLyNhaCungCapController(JPanel jpnView) {
        this.jpnView = jpnView;
        this.nhaCungCapDAO = new NhaCungCapDAOImpl();
        this.classTableModel = new ClassTableModel();
//        check_QLKH = 1;
    }
    
    public void setDataToTable() {
        listItem = nhaCungCapDAO.getList();
        model = classTableModel.setTableNhaCungCap(listItem, COLUMNS);
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
        table.getColumnModel().getColumn(2).setPreferredWidth(20);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(20);
        table.getColumnModel().getColumn(5).setPreferredWidth(20);
        
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
                    
                    txtMaNhaCungCap.setText(model.getValueAt(SelectedRowIndex, 1).toString());
                    txtTenNhaCungCap.setText(model.getValueAt(SelectedRowIndex, 2).toString());
                    txtSDTnhaCungCap.setText(model.getValueAt(SelectedRowIndex, 3).toString());
                    txtDiaChiNhaCungCap.setText(model.getValueAt(SelectedRowIndex, 4).toString());
                    txtEmailNhaCungCap.setText(model.getValueAt(SelectedRowIndex, 5).toString());
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
        table.getColumnModel().getColumn(3).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(4).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(5).setCellRenderer( rightrender );
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1039,296));
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
    
    public List<NhaCungCap> getListNhaCungCap(){
        return this.listItem;
    }
    

    public String[] getColumnName() {
        return COLUMNS;
    }
}
