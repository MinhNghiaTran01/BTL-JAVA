/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;


import com.mycompany.model.NhanVien;
import com.mycompany.service.NhanVienService;
import com.mycompany.service.NhanVienServiceImpl;
import com.mycompany.utility.ClassTableModel;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class QuanLyNhanVienController {
    private List<NhanVien> listItem;
    private JTable table;
    private static DefaultTableModel model;
    private JTextField txtMaNhanVien ,txtTenNhanVien,txtSoDienThoai,txtEmail,txtNgaySinh;
    private JComboBox<String> jcbChucVu;
    private JRadioButton[]  jrbGioiTinh;
    private JPanel jpnView;
    private ClassTableModel classTableModel = null;
    private NhanVienService NhanVienService = null;
    private final String[] COLUMNS = {"STT", "Mã nhân viên", "Tên nhân viên", "Năm sinh",
       "Giới Tính", "Số điện thoại", "Email","Chức vụ"};

    public QuanLyNhanVienController(JTextField txtMaNhanVien, JTextField txtTenNhanVien,JTextField txtNgaySinh ,JRadioButton[] jrbGioiTinh, JTextField txtSoDienThoai, JTextField txtEmail, JComboBox<String> jcbChucVu, JPanel jpnView) {
        this.txtMaNhanVien = txtMaNhanVien;
        this.txtTenNhanVien = txtTenNhanVien;
        this.txtNgaySinh = txtNgaySinh;
        this.jrbGioiTinh = jrbGioiTinh;
        this.txtSoDienThoai = txtSoDienThoai;
        this.txtEmail = txtEmail;
        this.jcbChucVu = jcbChucVu;
        this.jpnView = jpnView;
        this.NhanVienService = new NhanVienServiceImpl();
        this.classTableModel = new ClassTableModel();
    }

    
    public void setDataToTable() {
        listItem = NhanVienService.getListNhanVien();
        model = classTableModel.setTableNhanVien(listItem, COLUMNS);
        model.fireTableDataChanged();
        table = new JTable(model);

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        //table.getTableHeader().setPreferredSize(new Dimension(30, 30));
        table.setRowHeight(20);
        table.validate();
        table.repaint();
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(15);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        table.getColumnModel().getColumn(3).setPreferredWidth(15);
        table.getColumnModel().getColumn(4).setPreferredWidth(15);
        table.getColumnModel().getColumn(5).setPreferredWidth(20);
        table.getColumnModel().getColumn(6).setPreferredWidth(20);
        table.getColumnModel().getColumn(7).setPreferredWidth(20);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2&&table.getSelectedRow()!=-1)
                {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int SelectedRowIndex = table.getSelectedRow();
                    SelectedRowIndex = table.convertColumnIndexToModel(SelectedRowIndex);
                    
                    txtMaNhanVien.setText(model.getValueAt(SelectedRowIndex, 1).toString());
                    txtTenNhanVien.setText(model.getValueAt(SelectedRowIndex, 2).toString());
                    
                    String gioi_tinh = model.getValueAt(SelectedRowIndex, 4).toString() ; 
                    if(jrbGioiTinh[0].getText().equals(gioi_tinh))
                    {
                        jrbGioiTinh[0].setSelected(true);
                    }
                    else  jrbGioiTinh[1].setSelected(true);
                    
                    try {
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse( model.getValueAt(SelectedRowIndex, 3).toString() );
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        txtNgaySinh.setText(sdf.format(date));
                    } catch (ParseException ex) {}
                    
                    txtSoDienThoai.setText(model.getValueAt(SelectedRowIndex, 5).toString() );
                    txtEmail.setText( model.getValueAt(SelectedRowIndex, 6).toString() );
                    jcbChucVu.setSelectedItem(model.getValueAt(SelectedRowIndex, 7).toString() );
                    setRowSua(SelectedRowIndex);
                }
            }
        });
        DefaultTableCellRenderer centerrender = new DefaultTableCellRenderer();

        centerrender.setHorizontalAlignment( JLabel.CENTER );
        
        table.getColumnModel().getColumn(0).setCellRenderer( centerrender );
        
        DefaultTableCellRenderer rightrender = new DefaultTableCellRenderer();
        rightrender.setHorizontalAlignment( JLabel.LEFT );
        table.getColumnModel().getColumn(1).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(2).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(3).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(4).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(5).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(6).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(7).setCellRenderer( rightrender );  
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350,330));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public JTextField getTxtMaNhanVien() {
        return txtMaNhanVien;
    }

    public void setTxtMaNhanVien(JTextField txtMaNhanVien) {
        this.txtMaNhanVien = txtMaNhanVien;
    }

    public JTextField getTxtTenNhanVien() {
        return txtTenNhanVien;
    }

    public void setTxtTenNhanVien(JTextField txtTenNhanVien) {
        this.txtTenNhanVien = txtTenNhanVien;
    }

    public JTextField getTxtSoDienThoai() {
        return txtSoDienThoai;
    }

    public void setTxtSoDienThoai(JTextField txtSoDienThoai) {
        this.txtSoDienThoai = txtSoDienThoai;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    

    public JRadioButton[] getJrbGioiTinh() {
        return jrbGioiTinh;
    }

    public void setJrbGioiTinh(JRadioButton[] jrbGioiTinh) {
        this.jrbGioiTinh = jrbGioiTinh;
    }

    public JComboBox<String> getJcbChucVu() {
        return jcbChucVu;
    }

    public void setJcbChucVu(JComboBox<String> jcbChucVu) {
        this.jcbChucVu = jcbChucVu;
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
    
    public List<NhanVien> getListNhanVien(){
        return this.listItem;
    }
    
    public String[] getColumnName() {
        return COLUMNS;
    }
}
