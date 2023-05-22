/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.view;

import com.mycompany.controller.QuanLyHoaDonBanController;
import com.mycompany.controller.QuanLyHoaDonNhapController;
import com.mycompany.dao.DBConnect;
import com.mycompany.dao.HoaDonDAO;
import com.mycompany.dao.HoaDonDAOImpl;
import com.mycompany.dao.HoaDonNhapDAO;
import com.mycompany.dao.HoaDonNhapDAOImpl;
import com.mycompany.dao.KhachHangDAO;
import com.mycompany.dao.KhachHangDAOImpl;
import com.mycompany.dao.NhaCungCapDAO;
import com.mycompany.dao.NhaCungCapDAOImpl;
import com.mycompany.dao.NhanVienDAOImpl;
import com.mycompany.dao.NhanVienDao;
import com.mycompany.model.HoaDonBan;
import com.mycompany.model.HoaDonNhap;
import com.mycompany.model.KhachHang;
import com.mycompany.model.MayTinh;
import com.mycompany.model.NhaCungCap;
import com.mycompany.model.NhanVien;
import com.mycompany.service.HoaDonBanService;
import com.mycompany.service.HoaDonBanServiceImpl;
import com.mycompany.utility.ClassTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class jpnHoaDonNhap extends javax.swing.JPanel {

    /**
     * Creates new form jpnHoaDonNhap
     */
    QuanLyHoaDonNhapController controller;
    
    public jpnHoaDonNhap(JTextField txtMaHoaDonNhap, JTextField txtMaNhanVienNhap,JTextField txtMaNhaCungCap, JTextField txtNgayNhap, JButton btnQuanLyHoaDonNhap,JPanel jpnTableHoaDonNhap) {
        initComponents();
        this.txtMaHoaDonNhap = txtMaHoaDonNhap;
        this.txtMaNhanVienNhap = txtMaNhanVienNhap;
        this.txtNgayNhap = txtNgayNhap;
        this.txtMaNhaCungCap = txtMaNhaCungCap;
        this.btnQuanLyNhaCungCap = btnQuanLyHoaDonNhap;
        this.jpnTableHoaDonNhap = jpnTableHoaDonNhap;
    }
    public jpnHoaDonNhap() {
        initComponents();
        controller = new QuanLyHoaDonNhapController(txtMaHoaDonNhap, txtMaNhanVienNhap, txtMaNhaCungCap, txtNgayNhap, jpnTableHoaDonNhap);
        controller.setDataToTable();
    }
    
    
    private int ThemHoaDonNhap(int joption ){
        try {
            String errors = "";
            if(txtMaHoaDonNhap.getText().equals(""))
            {
                errors += "Mã hoá đơn nhập chưa được nhập\n";
                txtMaHoaDonNhap.setBackground(Color.red);
            }
            else txtMaHoaDonNhap.setBackground(Color.WHITE);
           
            
            if(txtMaNhanVienNhap.getText().equals(""))
            {
                errors+= "Mã nhân viên nhập chưa được nhập\n";
                txtMaNhanVienNhap.setBackground(Color.red);
            }
            else txtMaNhanVienNhap.setBackground(Color.white);
            
            
            if(txtNgayNhap.getText().equals(""))
            {
                errors+= "Ngày nhập chưa được nhập\n";
                txtNgayNhap.setBackground(Color.red);
            }
            else txtNgayNhap.setBackground(Color.white);
            
            if(txtMaNhaCungCap.getText().equals(""))
            {
                errors+= "Mã nhà cung cấp chưa được nhập\n";
                txtMaNhaCungCap.setBackground(Color.red);
            }
            else txtMaNhaCungCap.setBackground(Color.white);
            
            
            if(!errors.isEmpty())
            {
                JOptionPane.showMessageDialog(this, errors);
            }
            else
            {
                
                String sql = "INSERT INTO dbo.DanhSachHoaDonNhap(maHoaDonNhap,maNhaCungCap,maNhanVien,ngayNhap)" + " VALUES(?,?,?,?)";
                try (Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareCall(sql);)
                {
                    HoaDonNhapDAO hoaDonNhapDAO = new HoaDonNhapDAOImpl();
                    List<HoaDonNhap> listHoaDonNhap = hoaDonNhapDAO.getList();
                    
                    NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
                    List<NhaCungCap> listNhaCungCap = nhaCungCapDAO.getList();
                    
                    NhanVienDao nhanVienDAO = new NhanVienDAOImpl();
                    List<NhanVien> listnhanVien = nhanVienDAO.getListNhanVien();
                    
                    String error = "";
                    
                    boolean checkHoaDonNhap= true,checkManhanVien = false,checkMaNhaCungCap = false;
                    for(int i=0;i<listHoaDonNhap.size();i++)
                    {
                        if(listHoaDonNhap.get(i).getMaHoaDonNhap().equals(txtMaHoaDonNhap.getText()))
                        {
                            error += "Mã hóa đơn đã có, hãy nhập mã khác\n";
                            checkHoaDonNhap = false;
                            break;
                        }
                    }
                    
                    for(int i=0;i<listnhanVien.size();i++)
                    {
                        if(listnhanVien.get(i).getMa_nhan_vien().equals(txtMaNhanVienNhap.getText()))
                        {
                            checkManhanVien = true;
                            break;
                        }
                    }
                    
                    if(checkManhanVien==false) error+= "Mã nhân viên nhập sai\n";
                    
                    for(int i=0;i<listNhaCungCap.size();i++)
                    {
                        if(listNhaCungCap.get(i).getMaNhaCungCap().equals(txtMaNhaCungCap.getText()))
                        {
                            checkMaNhaCungCap = true;
                            break;
                        }
                    }
                    
                    if(checkMaNhaCungCap==false)
                    {
                        JOptionPane.showMessageDialog(this,"Nhà cung cấp chưa có trong CSDL,cần được thêm");
                    }
                    else if(checkHoaDonNhap==true&&checkManhanVien==true&&checkMaNhaCungCap==true) 
                    {
                        
                        ps.setString(1, txtMaHoaDonNhap.getText());
                        ps.setString(2, txtMaNhaCungCap.getText());
                        ps.setString(3, txtMaNhanVienNhap.getText() );
                        ps.setString(4, txtNgayNhap.getText() );
                        ps.executeUpdate();
                        if(joption==0) 
                        {
                            JOptionPane.showMessageDialog(this,"Đã THÊM Hóa đơn thành công");
                            return 0;
                        }
                        else JOptionPane.showMessageDialog(this,"Đã SỬA thành công");
                        return 1;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, error);
                        return 1;
                    }
                    
                } catch (Exception ex) {System.out.println(ex.getMessage());}
            }
        } 
        catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Erorr " + e.getMessage());
        }
        return 0;
        
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
        jLabel1 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaNhaCungCap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaNhanVienNhap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDonNhap = new javax.swing.JTextField();
        btnQuanLyNhaCungCap = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTenNhaCungCap = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiemTenNhaCungCap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiemMaNhaCungCap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiemMaNhanVien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiemMaHDN = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiemDenNgay = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiemTuNgay = new javax.swing.JTextField();
        jpnTableHoaDonNhap = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnSuaHoaDonNhap = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThemHoaDonNhap = new javax.swing.JButton();
        btnXoaHoaDonNhap = new javax.swing.JButton();

        jpnRoot.setBackground(java.awt.Color.white);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif.bold", 1, 13), java.awt.Color.black)); // NOI18N

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Mã nhà cung cấp");

        txtNgayNhap.setBackground(java.awt.Color.white);
        txtNgayNhap.setForeground(java.awt.Color.black);

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Mã nhân viên");

        txtMaNhaCungCap.setBackground(java.awt.Color.white);
        txtMaNhaCungCap.setForeground(java.awt.Color.black);
        txtMaNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtMaNhaCungCapMouseExited(evt);
            }
        });

        jLabel3.setBackground(java.awt.Color.white);
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Ngày nhập");

        txtMaNhanVienNhap.setBackground(java.awt.Color.white);
        txtMaNhanVienNhap.setForeground(java.awt.Color.black);

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("Mã hóa đơn nhập");

        txtMaHoaDonNhap.setBackground(java.awt.Color.white);
        txtMaHoaDonNhap.setForeground(java.awt.Color.black);

        btnQuanLyNhaCungCap.setBackground(java.awt.Color.lightGray);
        btnQuanLyNhaCungCap.setForeground(java.awt.Color.black);
        btnQuanLyNhaCungCap.setText("Quản lý nhà cung cấp");
        btnQuanLyNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNhaCungCapActionPerformed(evt);
            }
        });

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("Tên Nhà Cung Cấp");

        txtTenNhaCungCap.setBackground(java.awt.Color.white);
        txtTenNhaCungCap.setForeground(java.awt.Color.black);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVienNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnQuanLyNhaCungCap, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanVienNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuanLyNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif.bold", 1, 13), java.awt.Color.black)); // NOI18N

        jLabel6.setBackground(java.awt.Color.white);
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Mã hóa đơn nhập");

        txtTimKiemTenNhaCungCap.setBackground(java.awt.Color.white);
        txtTimKiemTenNhaCungCap.setForeground(java.awt.Color.black);

        jLabel7.setBackground(java.awt.Color.white);
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Mã nhân viên");

        txtTimKiemMaNhaCungCap.setBackground(java.awt.Color.white);
        txtTimKiemMaNhaCungCap.setForeground(java.awt.Color.black);

        jLabel8.setBackground(java.awt.Color.white);
        jLabel8.setForeground(java.awt.Color.black);
        jLabel8.setText("Tên nhà cung cấp");

        txtTimKiemMaNhanVien.setBackground(java.awt.Color.white);
        txtTimKiemMaNhanVien.setForeground(java.awt.Color.black);

        jLabel9.setBackground(java.awt.Color.white);
        jLabel9.setForeground(java.awt.Color.black);
        jLabel9.setText("Mã nhà cung cấp");

        txtTimKiemMaHDN.setBackground(java.awt.Color.white);
        txtTimKiemMaHDN.setForeground(java.awt.Color.black);

        btnTimKiem.setBackground(java.awt.Color.lightGray);
        btnTimKiem.setForeground(java.awt.Color.black);
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel11.setBackground(java.awt.Color.white);
        jLabel11.setForeground(java.awt.Color.black);
        jLabel11.setText("Từ Ngày ");

        txtTimKiemDenNgay.setBackground(java.awt.Color.white);
        txtTimKiemDenNgay.setForeground(java.awt.Color.black);

        jLabel10.setBackground(java.awt.Color.white);
        jLabel10.setForeground(java.awt.Color.black);
        jLabel10.setText("Đến ngày");

        txtTimKiemTuNgay.setBackground(java.awt.Color.white);
        txtTimKiemTuNgay.setForeground(java.awt.Color.black);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemMaHDN, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(txtTimKiemMaNhanVien)
                    .addComponent(txtTimKiemTuNgay))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTimKiemDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTimKiemTenNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(txtTimKiemMaNhaCungCap)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemMaHDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemMaNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnTableHoaDonNhap.setBackground(java.awt.Color.white);
        jpnTableHoaDonNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif.bold", 1, 13), java.awt.Color.black)); // NOI18N

        javax.swing.GroupLayout jpnTableHoaDonNhapLayout = new javax.swing.GroupLayout(jpnTableHoaDonNhap);
        jpnTableHoaDonNhap.setLayout(jpnTableHoaDonNhapLayout);
        jpnTableHoaDonNhapLayout.setHorizontalGroup(
            jpnTableHoaDonNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnTableHoaDonNhapLayout.setVerticalGroup(
            jpnTableHoaDonNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        jPanel5.setBackground(java.awt.Color.white);

        btnSuaHoaDonNhap.setBackground(java.awt.Color.white);
        btnSuaHoaDonNhap.setForeground(java.awt.Color.black);
        btnSuaHoaDonNhap.setText("Sửa ");
        btnSuaHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHoaDonNhapActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(java.awt.Color.white);
        btnLamMoi.setForeground(java.awt.Color.black);
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThemHoaDonNhap.setBackground(java.awt.Color.white);
        btnThemHoaDonNhap.setForeground(java.awt.Color.black);
        btnThemHoaDonNhap.setText("Thêm");
        btnThemHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHoaDonNhapActionPerformed(evt);
            }
        });

        btnXoaHoaDonNhap.setBackground(java.awt.Color.white);
        btnXoaHoaDonNhap.setForeground(java.awt.Color.black);
        btnXoaHoaDonNhap.setText("Xóa");
        btnXoaHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHoaDonNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btnThemHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaHoaDonNhap)
                    .addComponent(btnSuaHoaDonNhap)
                    .addComponent(btnThemHoaDonNhap)
                    .addComponent(btnLamMoi))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnRootLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnRootLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpnTableHoaDonNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(94, 94, 94))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTableHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        controller.setDataToTable();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHoaDonNhapActionPerformed
        // TODO add your handling code here:
        jpnHoaDonNhap jpnhoaDonNhap = new jpnHoaDonNhap(txtMaHoaDonNhap, txtMaNhanVienNhap, txtMaNhaCungCap, txtNgayNhap, btnQuanLyNhaCungCap, jpnRoot);
        int Check = jpnhoaDonNhap.ThemHoaDonNhap(0);
        JPanel node = new QuanLyChiTietHoaDonNhap("",txtMaHoaDonNhap.getText(),txtMaNhaCungCap.getText(),txtMaNhanVienNhap.getText(),txtNgayNhap.getText());
        if(Check==0)
        {
            jpnRoot.removeAll();
            jpnRoot.setLayout(new BorderLayout());
            jpnRoot.add(node);
            jpnRoot.validate();
            jpnRoot.repaint();
        }
    }//GEN-LAST:event_btnThemHoaDonNhapActionPerformed

    private void btnQuanLyNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNhaCungCapActionPerformed
        // TODO add your handling code here:
        if(btnQuanLyNhaCungCap.getText().equals("Quản lý nhà cung cấp"))
        {

            JPanel node = new QuanLyNhaCungCap(txtMaNhaCungCap.getText(),"","","","");
            jpnRoot.removeAll();
            jpnRoot.setLayout(new BorderLayout());
            jpnRoot.add(node);
            jpnRoot.validate();
            jpnRoot.repaint();
        }
        else
        {
            JPanel node = new QuanLyNhaCungCap(txtMaNhaCungCap.getText(),"","","","");
            jpnRoot.removeAll();
            jpnRoot.setLayout(new BorderLayout());
            jpnRoot.add(node);
            jpnRoot.validate();
            jpnRoot.repaint();
        }
    }//GEN-LAST:event_btnQuanLyNhaCungCapActionPerformed
    
    private void btnXoaHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHoaDonNhapActionPerformed
        // TODO add your handling code here:
        jpnHoaDonNhap jpnHoaDonNhap = new jpnHoaDonNhap(txtMaHoaDonNhap, txtMaNhanVienNhap, txtMaNhaCungCap, txtNgayNhap, btnQuanLyNhaCungCap, jpnTableHoaDonNhap);
        jpnHoaDonNhap.XoaHoaDonNhap();
    }//GEN-LAST:event_btnXoaHoaDonNhapActionPerformed

    private void btnSuaHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHoaDonNhapActionPerformed
        // TODO add your handling code here:
        JTable table = controller.getTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int Row = controller.getRowSua();
        Row = table.convertColumnIndexToModel(Row);
        
        
        String maHoaDonNhap = model.getValueAt(Row, 1).toString();
        
        String sql_XoaDanhSachHoaDonNhap = "DELETE FROM dbo.DanhSachHoaDonNhap " + "WHERE maHoaDonNhap = ?";
        String sql_XoaChiTietHoaDonNhap = "DELETE FROM dbo.ChiTietHoaDonNhap " + " WHERE maHoaDonNhap = ?";
        String sql_Them = "INSERT INTO dbo.DanhSachHoaDonNhap(maHoaDonNhap,maNhaCungCap,maNhanVien,ngayNhap)  " + " VALUES(?,?,?,?) ";
        try (Connection c = DBConnect.getConnection();
        PreparedStatement ps_XoaDanhSachHoaDonNhap = c.prepareCall(sql_XoaDanhSachHoaDonNhap);
        PreparedStatement ps_XoaChiTietHoaDonNhap = c.prepareCall(sql_XoaChiTietHoaDonNhap);
        PreparedStatement ps_Them = c.prepareCall(sql_Them);)
        {
            if( ThemHoaDonNhap(1) == 1)
            {
                
                ps_XoaChiTietHoaDonNhap.setString(1,maHoaDonNhap);
                ps_XoaChiTietHoaDonNhap.executeUpdate();
                ps_XoaDanhSachHoaDonNhap.setString(1, maHoaDonNhap);
                ps_XoaDanhSachHoaDonNhap.executeUpdate();
                
                
                ps_Them.setString(1,txtMaHoaDonNhap.getText());
                ps_Them.setString(2,txtMaNhaCungCap.getText());
                ps_Them.setString(3, txtMaNhanVienNhap.getText());
                ps_Them.setString(4, txtNgayNhap.getText());
                ps_Them.executeUpdate();
            }
            
        } catch (Exception ex) {System.out.println(ex.getMessage());}
    }//GEN-LAST:event_btnSuaHoaDonNhapActionPerformed

    private void txtMaNhaCungCapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaNhaCungCapMouseExited
        // TODO add your handling code here:
        if(txtMaNhaCungCap.getText().equals("")==false)
        {
            NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAOImpl();
            List<NhaCungCap> listNhaCungCap = nhaCungCapDAO.getList();
            boolean check = false;
            for(int i=0;i<listNhaCungCap.size();i++)
            {
                if(listNhaCungCap.get(i).getMaNhaCungCap().equals(txtMaNhaCungCap.getText()))
                {
                    txtTenNhaCungCap.setText(listNhaCungCap.get(i).getTenNhaCungCap());
                    check = true;
                    break;
                }
            }
            
            if(check==true) 
            {
                btnQuanLyNhaCungCap.setText("Quản lý nhà cung cấp");
                txtTenNhaCungCap.setEnabled(false);
                
            }
            else 
            {
                btnQuanLyNhaCungCap.setText("Thêm nhà cung cấp");
                txtTenNhaCungCap.setEnabled(true);
            }
        }
    }//GEN-LAST:event_txtMaNhaCungCapMouseExited

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        List<HoaDonNhap> listItem = controller.getListHoaDonNhap();
        List<HoaDonNhap> SearchListItem = new ArrayList<>();
        JTable table = controller.getTable();
        
        for(int i=0;i<listItem.size();i++)
        {
            if(txtTimKiemMaHDN.getText().length()>0&&listItem.get(i).getMaHoaDonNhap().equalsIgnoreCase( txtTimKiemMaHDN.getText() )== false) continue;
            if(txtTimKiemMaNhanVien.getText().length()>0&&listItem.get(i).getNhanVien().getMa_nhan_vien().equalsIgnoreCase( txtTimKiemMaNhanVien.getText() )== false) continue;
            if(txtTimKiemMaNhaCungCap.getText().length()>0&&listItem.get(i).getNhaCungCap().getMaNhaCungCap().equalsIgnoreCase( txtTimKiemMaNhaCungCap.getText() )== false) continue;
            if(txtTimKiemTenNhaCungCap.getText().length()>0&&listItem.get(i).getNhaCungCap().getTenNhaCungCap().equalsIgnoreCase( txtTimKiemTenNhaCungCap.getText() )== false) continue;
            
            
            Date date = new Date();
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(listItem.get(i).getNgayNhap().toString());
            } catch (ParseException ex) {}
            
            if(txtTimKiemTuNgay.getText().length()>0)
            {
                Date dateTuNgay = new Date();
                try {
                    dateTuNgay = new SimpleDateFormat("dd/MM/yyyy").parse(txtTimKiemTuNgay.getText().toString());
                } catch (ParseException ex) {
                }
                if(date.getTime()<dateTuNgay.getTime())
                {
                    continue;
                }
            }
            
            if(txtTimKiemDenNgay.getText().length()>0)
            {
                Date dateDenNgay = new Date();
                try {
                    dateDenNgay = new SimpleDateFormat("dd/MM/yyyy").parse(txtTimKiemDenNgay.getText());
                } catch (ParseException ex) {
                }
                if(date.getTime()>dateDenNgay.getTime())
                {
                    continue;
                }
            }
            
            SearchListItem.add(listItem.get(i));
        }
        
        ClassTableModel ctm = new ClassTableModel();
        String [] CLOUMNS = controller.getColumnName();
        DefaultTableModel model = ctm.setTableHoaDonNhap(SearchListItem, CLOUMNS );
        table.setModel(model);
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
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1100,290));
        
        jpnTableHoaDonNhap.removeAll();
        jpnTableHoaDonNhap.setLayout(new BorderLayout());
        jpnTableHoaDonNhap.add(scroll);
        jpnTableHoaDonNhap.validate();
        jpnTableHoaDonNhap.repaint();
    }//GEN-LAST:event_btnTimKiemActionPerformed
    
    private void XoaHoaDonNhap(){
        try 
        {
            String errors = "";
            if(txtMaHoaDonNhap.getText().equals(""))
            {
                errors += "Mã hoá đơn chưa được nhập\n";
                txtMaHoaDonNhap.setBackground(Color.red);
            }
            else txtMaHoaDonNhap.setBackground(Color.WHITE);
           
            
            if(!errors.isEmpty())
            {
                JOptionPane.showMessageDialog(this, errors);
            }
            else
            {
                
                String sql = "DELETE FROM dbo.DanhSachHoaDonNhap  " + "WHERE maHoaDonNhap = ?";
                try (Connection c = DBConnect.getConnection();
                PreparedStatement ps = c.prepareCall(sql);)
                {
                    ps.setString(1, txtMaHoaDonNhap.getText());
                    
                    HoaDonNhapDAO hoaDonNhapDAO = new HoaDonNhapDAOImpl();
                    List<HoaDonNhap> listHoaDonNhap = hoaDonNhapDAO.getList();
                    boolean check = false;
                    for(int i=0;i<listHoaDonNhap.size();i++)
                    {
                        if(listHoaDonNhap.get(i).getMaHoaDonNhap().equals(txtMaHoaDonNhap.getText()))
                        {
                            check = true;
                            break;
                        }
                    }
                    
                    if(check==true)
                    {
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this,"Đã XÓA thành công");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Mã hóa đơn không có trong cơ sở dữ liệu");
                    }
                    
                } catch (Exception ex) {System.out.println(ex.getMessage());}
            }
        } 
        catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Erorr " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQuanLyNhaCungCap;
    private javax.swing.JButton btnSuaHoaDonNhap;
    private javax.swing.JButton btnThemHoaDonNhap;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaHoaDonNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTableHoaDonNhap;
    private javax.swing.JTextField txtMaHoaDonNhap;
    private javax.swing.JTextField txtMaNhaCungCap;
    private javax.swing.JTextField txtMaNhanVienNhap;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtTenNhaCungCap;
    private javax.swing.JTextField txtTimKiemDenNgay;
    private javax.swing.JTextField txtTimKiemMaHDN;
    private javax.swing.JTextField txtTimKiemMaNhaCungCap;
    private javax.swing.JTextField txtTimKiemMaNhanVien;
    private javax.swing.JTextField txtTimKiemTenNhaCungCap;
    private javax.swing.JTextField txtTimKiemTuNgay;
    // End of variables declaration//GEN-END:variables
}
