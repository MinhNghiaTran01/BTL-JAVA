/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.HoaDonBan;
import com.mycompany.service.HoaDonBanService;
import com.mycompany.service.HoaDonBanServiceImpl;
import com.mycompany.utility.ClassTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
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
public class QuanLyHoaDonBanController {
    List<HoaDonBan> listItem;
    private JTable table;
    private static DefaultTableModel model;
    private JTextField txtMaHoaDonBan,txtMaNhanVien,txtNgayBan,txtSoDienThoaiKhachHang,txtTenKhachHang;
    private JComboBox<String> jcbHinhThucThanhToan;
    private JPanel jpnView;
    private ClassTableModel classTableModel = null;
    private HoaDonBanService hoaDonService = null;
    private String[] COLUMNS = {"STT","Mã hóa đơn","Mã nhân viên","Nhân viên bán hàng","Tên khách hàng","Số điện thoại","Ngày bán","Hình thức thanh toán"};
    public QuanLyHoaDonBanController(JTextField txtMaHoaDonBan, JTextField txtMaNhanVien, JTextField txtNgayBan, JTextField txtSoDienThoaiKhachHang, JTextField txtTenKhachHang, JComboBox<String> jcbHinhThucThanhToan, JPanel jpnView) {
        this.txtMaHoaDonBan = txtMaHoaDonBan;
        this.txtMaNhanVien = txtMaNhanVien;
        this.txtNgayBan = txtNgayBan;
        this.txtSoDienThoaiKhachHang = txtSoDienThoaiKhachHang;
        this.txtTenKhachHang = txtTenKhachHang;
        this.jcbHinhThucThanhToan = jcbHinhThucThanhToan;
        this.jpnView = jpnView;
        this.hoaDonService = new HoaDonBanServiceImpl();
        this.classTableModel = new ClassTableModel();
    }
    

    public QuanLyHoaDonBanController(JPanel jpnView) {
        this.jpnView = jpnView;
        this.hoaDonService = new HoaDonBanServiceImpl();
        this.classTableModel = new ClassTableModel();
    }
    
    public void setDataToTable() {
        listItem = hoaDonService.getList();
        model = classTableModel.setTableHoaDonBan(listItem, COLUMNS);
        model.fireTableDataChanged();
        table = new JTable(model);
        DefaultTableCellRenderer centerrender = new DefaultTableCellRenderer();

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        //table.getTableHeader().setPreferredSize(new Dimension(30, 30));
        table.setRowHeight(20);
        table.validate();
        table.repaint();
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(15);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        table.getColumnModel().getColumn(3).setPreferredWidth(25);
        table.getColumnModel().getColumn(4).setPreferredWidth(25);
        table.getColumnModel().getColumn(5).setPreferredWidth(25);
        table.getColumnModel().getColumn(6).setPreferredWidth(15);
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
                    
                            
                    txtMaHoaDonBan.setText(model.getValueAt(SelectedRowIndex, 1).toString());
                    txtMaNhanVien.setText(model.getValueAt(SelectedRowIndex, 2).toString());
                    txtTenKhachHang.setText(model.getValueAt(SelectedRowIndex, 4).toString());
                    txtSoDienThoaiKhachHang.setText(model.getValueAt(SelectedRowIndex, 5).toString());
                    txtNgayBan.setText(model.getValueAt(SelectedRowIndex, 6).toString());
                    jcbHinhThucThanhToan.setSelectedItem(model.getValueAt(SelectedRowIndex, 7).toString());
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
        table.getColumnModel().getColumn(6).setCellRenderer( rightrender );
        table.getColumnModel().getColumn(7).setCellRenderer( rightrender );
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1150,310));
        
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
    
    public List<HoaDonBan> getListHoaDonBan(){
        return this.listItem;
    }
    

    public String[] getColumnName() {
        return COLUMNS;
    }
}
