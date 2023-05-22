/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;
import com.mycompany.service.MayTinhService;
import com.mycompany.model.MayTinh;
import com.mycompany.service.MayTinhServiceImpl;
import com.mycompany.utility.ClassTableModel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.table.TableCellRenderer;


public class QuanLyMayTinhController extends DefaultTableModel{
    List<MayTinh> listItem;
    private JTable table;
    private static DefaultTableModel model;
    private JTextField txtMaMayTinh,txtTenMayTinh,txtXuatXu,txtGiaBan,txtSoLuong;
    private JComboBox<String> jcbThoiGianBaoHanh;
    //JComboBox<String> 
    private JPanel jpnView;
    private ClassTableModel classTableModel = null;
    private MayTinhService maytinhService = null;
    private final String[] COLUMNS = {"STT", "Mã máy tính", "Tên máy tính", "Xuất xứ",
       "Thời gian bảo hành", "Số lượng", "Giá bán"};
//    public QuanLyMayTinhController(JPanel jpnView){
//        this.jpnView = jpnView;
//        this.maytinhService = new MayTinhServiceImpl();
//        this.classTableModel = new ClassTableModel();
//    };

    public QuanLyMayTinhController(JTextField txtMaMayTinh, JTextField txtTenMayTinh,JComboBox<String> jcbThoiGianBaoHanh, JTextField txtXuatXu, JTextField txtGiaBan, JTextField txtSoLuong, JPanel jpnView) {
        this.txtMaMayTinh = txtMaMayTinh;
        this.txtTenMayTinh = txtTenMayTinh;
        this.jcbThoiGianBaoHanh = jcbThoiGianBaoHanh;
        this.txtXuatXu = txtXuatXu;
        this.txtGiaBan = txtGiaBan;
        this.txtSoLuong = txtSoLuong;
        this.jpnView = jpnView;
        this.maytinhService = new MayTinhServiceImpl();
        this.classTableModel = new ClassTableModel();
    }
    
     
      public void setDataToTable() {
        listItem = maytinhService.getList();
        model = classTableModel.setTableMayTinh(listItem, COLUMNS);
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
        table.getColumnModel().getColumn(3).setPreferredWidth(15);
        table.getColumnModel().getColumn(4).setPreferredWidth(20);
        table.getColumnModel().getColumn(5).setPreferredWidth(10);
        table.getColumnModel().getColumn(6).setPreferredWidth(10);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2&&table.getSelectedRow()!=-1)
                {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int SelectedRowIndex = table.getSelectedRow();
                    SelectedRowIndex = table.convertColumnIndexToModel(SelectedRowIndex);
                    
                    txtMaMayTinh.setText(model.getValueAt(SelectedRowIndex, 1).toString());
                    txtTenMayTinh.setText(model.getValueAt(SelectedRowIndex, 2).toString());
                    txtXuatXu.setText(model.getValueAt(SelectedRowIndex, 3).toString());
                    jcbThoiGianBaoHanh.setSelectedItem( model.getValueAt(SelectedRowIndex, 4).toString() );
                    txtSoLuong.setText(model.getValueAt(SelectedRowIndex, 5).toString());
                    txtGiaBan.setText(model.getValueAt(SelectedRowIndex, 6).toString());
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
             
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350,330));
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
    
    public List<MayTinh> getListMayTinh(){
        return this.listItem;
    }
    

    public String[] getColumnName() {
        return COLUMNS;
    }
}

