/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.dao.DBConnect;
import com.mycompany.dao.MayTinhDAO;
import com.mycompany.dao.MayTinhDAOImpl;
import com.mycompany.model.MayTinh;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyChiTietHoaDonNhap extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyChiTietHoaDonNhap
     */
    private int Row = 0;
    private Map<String, Integer> map = new HashMap<>();
    private static JTable table = new JTable();
    private final String [] COLUMNS = {"STT","Sản phẩm","Giá nhập","Số lượng","Thành tiền"};
    private DefaultTableModel dtmHoaDon;
    private long tongTien = 0;
    public QuanLyChiTietHoaDonNhap(String txtSoLuong, String txtMaHoaDonNhap, String txtMaNhaCungCap,String txtMaNhanVienNhap,String txtNgayNhap) {
        initComponents();
        this.txtSoLuong.setText(txtSoLuong);
        this.txtMaHoaDonNhap.setText(txtMaHoaDonNhap);
        this.txtNgayNhap.setText(txtNgayNhap);
        this.txtMaNhaCungCap.setText(txtMaNhaCungCap);
        this.txtMaNhanVienNhap.setText(txtMaNhanVienNhap);
        MayTinhDAO mtd = new MayTinhDAOImpl();
        List<MayTinh> listMayTinh = mtd.getList();
        for(int i=0;i<listMayTinh.size();i++)
        {
            if(map.containsKey(listMayTinh.get(i).getTen_may_tinh())==false)
            {
                map.put(listMayTinh.get(i).getTen_may_tinh(),listMayTinh.get(i).getGia_ban());
                jcbTenMayTinh.addItem(listMayTinh.get(i).getTen_may_tinh());
            }
        }
        this.txtMaHoaDonNhap.setEnabled(false);
        this.txtMaNhaCungCap.setEnabled(false);
        this.txtMaNhanVienNhap.setEnabled(false);
        this.txtNgayNhap.setEnabled(false);
        
        dtmHoaDon = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtmHoaDon.setColumnIdentifiers(COLUMNS);
        dtmHoaDon.fireTableDataChanged();
    }
    
    
    public QuanLyChiTietHoaDonNhap() {
        initComponents();
        MayTinhDAO mtd = new MayTinhDAOImpl();
        List<MayTinh> listMayTinh = mtd.getList();
        List<String> tenMayTinh = new ArrayList<>();
        jcbTenMayTinh.addItem("");
        for(int i=0;i<listMayTinh.size();i++)
        {
            if(tenMayTinh.contains(listMayTinh.get(i).getTen_may_tinh())==false)
            {
                tenMayTinh.add(listMayTinh.get(i).getTen_may_tinh());
                jcbTenMayTinh.addItem(listMayTinh.get(i).getTen_may_tinh());
            }
        }
        txtMaHoaDonNhap.setEnabled(false);
        txtMaNhaCungCap.setEnabled(false);
        txtMaNhanVienNhap.setEnabled(false);
        txtNgayNhap.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNhaCungCap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDonNhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaNhanVienNhap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbTenMayTinh = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jpnTableHoaDonNhap = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnThemHoaDon = new javax.swing.JButton();
        btnXoaHoaDon = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        jpnRoot.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif.bold", 1, 13), java.awt.Color.black)); // NOI18N
        jPanel2.setForeground(java.awt.Color.black);

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Mã nhà cung cấp");

        txtMaNhaCungCap.setBackground(java.awt.Color.white);
        txtMaNhaCungCap.setForeground(java.awt.Color.black);

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("Mã hóa đơn nhập");

        txtMaHoaDonNhap.setBackground(java.awt.Color.white);
        txtMaHoaDonNhap.setForeground(java.awt.Color.black);
        txtMaHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonNhapActionPerformed(evt);
            }
        });

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("Mã nhân viên nhập");

        txtMaNhanVienNhap.setBackground(java.awt.Color.white);
        txtMaNhanVienNhap.setForeground(java.awt.Color.black);

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Ngày nhập");

        txtNgayNhap.setBackground(java.awt.Color.white);
        txtNgayNhap.setForeground(java.awt.Color.black);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayNhap)
                    .addComponent(txtMaNhanVienNhap)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVienNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết hóa đơn nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif.bold", 1, 13), java.awt.Color.black)); // NOI18N
        jPanel3.setForeground(java.awt.Color.black);

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Tên Máy Tính");

        jcbTenMayTinh.setBackground(java.awt.Color.white);
        jcbTenMayTinh.setForeground(java.awt.Color.black);

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Số lượng");

        txtSoLuong.setBackground(java.awt.Color.white);
        txtSoLuong.setForeground(java.awt.Color.black);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbTenMayTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbTenMayTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jpnTableHoaDonNhap.setBackground(java.awt.Color.white);
        jpnTableHoaDonNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif.bold", 1, 13), java.awt.Color.black)); // NOI18N
        jpnTableHoaDonNhap.setForeground(java.awt.Color.black);

        javax.swing.GroupLayout jpnTableHoaDonNhapLayout = new javax.swing.GroupLayout(jpnTableHoaDonNhap);
        jpnTableHoaDonNhap.setLayout(jpnTableHoaDonNhapLayout);
        jpnTableHoaDonNhapLayout.setHorizontalGroup(
            jpnTableHoaDonNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnTableHoaDonNhapLayout.setVerticalGroup(
            jpnTableHoaDonNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setForeground(java.awt.Color.black);

        btnThemHoaDon.setBackground(java.awt.Color.white);
        btnThemHoaDon.setForeground(java.awt.Color.black);
        btnThemHoaDon.setText("Thêm");
        btnThemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHoaDonActionPerformed(evt);
            }
        });

        btnXoaHoaDon.setBackground(java.awt.Color.white);
        btnXoaHoaDon.setForeground(java.awt.Color.black);
        btnXoaHoaDon.setText("Xóa");
        btnXoaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHoaDonActionPerformed(evt);
            }
        });

        btnThoat.setBackground(java.awt.Color.white);
        btnThoat.setForeground(java.awt.Color.black);
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnThemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaHoaDon)
                    .addComponent(btnThemHoaDon))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnThoat)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setForeground(java.awt.Color.red);
        jLabel6.setText("Tổng tiền");

        txtTongTien.setBackground(java.awt.Color.white);
        txtTongTien.setForeground(java.awt.Color.black);

        jPanel1.setBackground(java.awt.Color.orange);

        jLabel8.setBackground(java.awt.Color.white);
        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.black);
        jLabel8.setText("Quản Lý Chi Tiết Hóa Đơn Nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnTableHoaDonNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTableHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        JPanel node = new jpnHoaDonNhap();
        jpnRoot.removeAll();
        jpnRoot.setLayout(new BorderLayout());
        jpnRoot.add(node);
        jpnRoot.validate();
        jpnRoot.repaint();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHoaDonActionPerformed
        // TODO add your handling code here:
        String errors = "";
        if(txtSoLuong.getText().equals("0"))
        {
            errors+= "Số lượng sản phẩm phải lớn hơn 0 \n";
            txtSoLuong.setBackground(Color.red);
        }
        else txtSoLuong.setBackground(Color.white);
        
        if(jcbTenMayTinh.getSelectedItem().toString().length()==0)
        {
            errors+= "Vui lòng chọn sản phẩm \n";
            jcbTenMayTinh.setBackground(Color.red);
        }
        else jcbTenMayTinh.setBackground(Color.white);
        
        if(errors.length()==0)
        {
            String sql = "INSERT INTO dbo.ChiTietHoaDonNhap(maHoaDonNhap,tenMayTinh,giaNhap,soLuong) " + " VALUES(?, ?, ?, ?) ";
            try (Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareCall(sql);){
                
                ps.setString(1, txtMaHoaDonNhap.getText() );
                ps.setString(2, jcbTenMayTinh.getSelectedItem().toString());
                ps.setInt(3,map.get(jcbTenMayTinh.getSelectedItem().toString()));
                ps.setInt(4, Integer.valueOf(txtSoLuong.getText()));
                ps.executeUpdate();
                
                Object[] obj;
                obj = new Object[COLUMNS.length];
                long thanhTien = Long.valueOf(txtSoLuong.getText())*Long.valueOf(map.get(jcbTenMayTinh.getSelectedItem().toString()));
                int SoHang = dtmHoaDon.getRowCount();
                obj[0] = String.valueOf(SoHang + 1);
                obj[1] = jcbTenMayTinh.getSelectedItem().toString();
                obj[2] = map.get(jcbTenMayTinh.getSelectedItem().toString());
                obj[3] = txtSoLuong.getText();
                obj[4] = String.valueOf(thanhTien);
                dtmHoaDon.addRow(obj);
                
                tongTien+= thanhTien;
                txtTongTien.setText(String.valueOf(tongTien));
                
                    JOptionPane.showMessageDialog(this,"Đã THÊM thành công");
                    JTable table = new JTable(dtmHoaDon);
                    table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
                    //table.getTableHeader().setPreferredSize(new Dimension(30, 30));
                    table.setRowHeight(20);
                    table.validate();
                    table.repaint();

                    table.getColumnModel().getColumn(0).setPreferredWidth(10);
                    table.getColumnModel().getColumn(1).setPreferredWidth(15);
                    table.getColumnModel().getColumn(2).setPreferredWidth(15);
                    table.getColumnModel().getColumn(3).setPreferredWidth(15);
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                        DefaultTableCellRenderer centerrender = new DefaultTableCellRenderer();
                        centerrender.setHorizontalAlignment(JLabel.CENTER);
                    table.getColumnModel().getColumn(0).setCellRenderer( centerrender );

                      DefaultTableCellRenderer rightrender = new DefaultTableCellRenderer();
                      rightrender.setHorizontalAlignment( JLabel.LEFT );
                    table.getColumnModel().getColumn(1).setCellRenderer( rightrender );
                    table.getColumnModel().getColumn(2).setCellRenderer( rightrender );
                    table.getColumnModel().getColumn(3).setCellRenderer( rightrender );
                    JScrollPane scroll = new JScrollPane();
                    scroll.getViewport().add(table);
                    scroll.setPreferredSize(new Dimension(1110,296));
                    jpnTableHoaDonNhap.removeAll();
                    jpnTableHoaDonNhap.setLayout(new BorderLayout());
                    jpnTableHoaDonNhap.add(scroll);
                    jpnTableHoaDonNhap.validate();
                    jpnTableHoaDonNhap.repaint();
        } catch (Exception ex) {System.out.println(ex.getMessage() + "  hello");}
    }                                             
    }//GEN-LAST:event_btnThemHoaDonActionPerformed

    private void btnXoaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHoaDonActionPerformed
        // TODO add your handling code here:
        String errors = "";
        if(txtSoLuong.getText().equals("0"))
        {
            errors+= "Số lượng sản phẩm phải lớn hơn 0 \n";
            txtSoLuong.setBackground(Color.red);
        }
        else txtSoLuong.setBackground(Color.white);
        
        if(jcbTenMayTinh.getSelectedItem().toString().length()==0)
        {
            errors+= "Vui lòng chọn sản phẩm \n";
            jcbTenMayTinh.setBackground(Color.red);
        }
        else jcbTenMayTinh.setBackground(Color.white);
        
        if(!errors.isEmpty())
        {
            JOptionPane.showMessageDialog(this, errors);
        }
        else
        {
                JTable table = new JTable(dtmHoaDon);
                table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
                //table.getTableHeader().setPreferredSize(new Dimension(30, 30));
                table.setRowHeight(20);
                table.validate();
                table.repaint();
                table.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(e.getClickCount()==1&&table.getSelectedRow()!=-1)
                        {
                            dtmHoaDon = (DefaultTableModel) table.getModel();
                            int SelectedRowIndex = table.getSelectedRow();
                            SelectedRowIndex = table.convertColumnIndexToModel(SelectedRowIndex);
                            setRow(SelectedRowIndex);
                        }
                    }
                });
                
                String tenSanPham = dtmHoaDon.getValueAt(this.Row,1 ).toString();
                long giaBan = Long.valueOf(dtmHoaDon.getValueAt(this.Row,2 ).toString());
                long soLuong = Long.valueOf(dtmHoaDon.getValueAt(this.Row,3 ).toString());
                
                long ThanhTien = giaBan * soLuong;        
                table.getColumnModel().getColumn(0).setPreferredWidth(10);
                table.getColumnModel().getColumn(1).setPreferredWidth(15);
                table.getColumnModel().getColumn(2).setPreferredWidth(15);
                table.getColumnModel().getColumn(3).setPreferredWidth(15);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                    DefaultTableCellRenderer centerrender = new DefaultTableCellRenderer();
                    centerrender.setHorizontalAlignment(JLabel.CENTER);
                table.getColumnModel().getColumn(0).setCellRenderer( centerrender );

                  DefaultTableCellRenderer rightrender = new DefaultTableCellRenderer();
                  rightrender.setHorizontalAlignment( JLabel.LEFT );
                table.getColumnModel().getColumn(1).setCellRenderer( rightrender );
                table.getColumnModel().getColumn(2).setCellRenderer( rightrender );
                table.getColumnModel().getColumn(3).setCellRenderer( rightrender );
                JScrollPane scroll = new JScrollPane();
                scroll.getViewport().add(table);
                scroll.setPreferredSize(new Dimension(1110,296));
                
                String sql = "DELETE FROM dbo.ChiTietHoaDon  " + "WHERE tenMayTinh = ? ";
                try (Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareCall(sql);)
                {
                    tongTien = Long.valueOf(txtTongTien.getText()) - ThanhTien;
                    txtTongTien.setText(String.valueOf(tongTien));
                    dtmHoaDon.removeRow(this.Row);
                    ps.setString(1,tenSanPham);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Đã XÓA thành công");
                    jpnTableHoaDonNhap.removeAll();
                    jpnTableHoaDonNhap.setLayout(new BorderLayout());
                    jpnTableHoaDonNhap.add(scroll);
                    jpnTableHoaDonNhap.validate();
                    jpnTableHoaDonNhap.repaint();
                } catch (Exception ex) {System.out.println(ex.getMessage());}
        }
        
    }//GEN-LAST:event_btnXoaHoaDonActionPerformed

    private void txtMaHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonNhapActionPerformed
    public void setRow(int Row){
        this.Row = Row;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemHoaDon;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoaHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> jcbTenMayTinh;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTableHoaDonNhap;
    private javax.swing.JTextField txtMaHoaDonNhap;
    private javax.swing.JTextField txtMaNhaCungCap;
    private javax.swing.JTextField txtMaNhanVienNhap;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
