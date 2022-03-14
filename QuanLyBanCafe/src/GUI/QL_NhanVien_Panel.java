/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Dao.NhanVienDAO;
import Entity.NhanVien;
import Helper.Auth;
import Helper.MsgBox;
import Helper.XDate;
import Helper.XLAnh;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QL_NhanVien_Panel extends javax.swing.JPanel {
    NhanVienDAO dao = new NhanVienDAO();
    int row = -1;
    JFileChooser fileChooser = new JFileChooser();
    NhanVien nv = Auth.user;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Creates new form QL_NhanVien_Panel
     */
    public QL_NhanVien_Panel() {
        initComponents();
        this.setSize(1200, 831);
        init();
    }
    
    void init(){
        this.FillTableNV_HD();
        this.fillTableNV_KHD();
        row = 0 ;
        this.updateStatus();
        clearForm();
    }
    
    private void FillTableNV_HD(){
        List<NhanVien> list = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tblNV_HD.getModel();
        model.setRowCount(0);
        try {
            list = dao. select_TrangThai2();
            for (NhanVien nv : list) {
                model.addRow(new Object[]{
                    nv.getId_Nhanvien(), nv.getTenNV(),nv.isGIOITINH()?"Nam":"Nữ",
                    nv.getNgaysinh(),nv.getDiaChi(),nv.getSDT(),nv.getEmail(),
                    nv.isVaiTro()?"Quản lý":"Nhân viên",nv.getHinh()
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    private void fillTableNV_KHD(){
        List<NhanVien> list = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tblNV_KHD.getModel();
        model.setRowCount(0);
        try {
            list = dao. select_TrangThai1();
            for (NhanVien nv : list) {
                model.addRow(new Object[]{
                    nv.getId_Nhanvien(), nv.getTenNV(),nv.isGIOITINH()?"Nam":"Nữ",
                    nv.getNgaysinh(),nv.getDiaChi(),nv.getSDT(),nv.getEmail(),
                    nv.isVaiTro()?"Quản lý":"Nhân viên",nv.getHinh()
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void chonAnh(){
        if (fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XLAnh.save(file);
            ImageIcon ii=XLAnh.read(file.getName());
            lblHinh.setIcon(ii);
            lblHinh.setToolTipText(file.getName());
        }
    }
    public void fillTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblNV_HD.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = dao.selectAll();
            for (NhanVien nv : list) {
                model.addRow(new Object[]{
                    nv.getId_Nhanvien(), nv.getTenNV(),nv.isGIOITINH()?"Nam":"Nữ",
                    nv.getNgaysinh(),nv.getDiaChi(),nv.getSDT(),nv.getEmail(),
                    nv.isVaiTro()?"Quản lý":"Nhân viên",nv.getHinh()
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    void setFrom(NhanVien nv){
        txtMaNV.setText(nv.getId_Nhanvien());
        txtHoTen.setText(nv.getTenNV());
        rdoNam.setSelected(nv.isGIOITINH());
        rdoNu.setSelected(!nv.isGIOITINH());
        txtNgaySinh.setText(nv.getNgaysinh()+"");
        txtEmail.setText(nv.getEmail());
        txtSDT.setText(nv.getSDT());
        txtDiaChi.setText(nv.getDiaChi());
        txtTaiKhoan.setText(nv.getUserName());
        txtPass.setText(nv.getPass());
        rdoQuanLy.setSelected(nv.isVaiTro());
        rdoNhanVien.setSelected(!nv.isVaiTro());
        rdoLamViec.setSelected(nv.isTrangThai());
        rdoNghiViec.setSelected(!nv.isTrangThai());
        if (nv.getHinh() != null) {
            lblHinh.setToolTipText(nv.getHinh());
            lblHinh.setIcon(XLAnh.read(nv.getHinh()));
        }
    }
    public NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setId_Nhanvien(txtMaNV.getText());
        nv.setTenNV(txtHoTen.getText());
        nv.setGIOITINH(rdoNam.isSelected());
        //String ngaySinh = format.format(jDateNgaysinh.getDate());
        nv.setNgaysinh(XDate.toDate(txtNgaySinh.getText(), "yyyy-MM-dd"));
        nv.setEmail(txtEmail.getText());
        nv.setSDT(txtSDT.getText());
        nv.setDiaChi(txtDiaChi.getText());
        nv.setUserName(txtTaiKhoan.getText());
        nv.setPass(new String(txtPass.getPassword()));//xong
        nv.setVaiTro(rdoQuanLy.isSelected());
        nv.setTrangThai(rdoLamViec.isSelected());
        nv.setHinh(lblHinh.getToolTipText());
        return nv;
    }
    void clearForm() {
        NhanVien nv = new NhanVien();
        this.setFrom(nv);
        lblHinh.setIcon(null);
        this.row = -1;
        this.updateStatus();
    }
    void updateStatus() {
        boolean edit = this.row >= 0;
        boolean first = this.row == 0;
        boolean last = (this.row == tblNV_HD.getRowCount() - 1);
        txtMaNV.setEditable(false);
        txtHoTen.setEditable(true);
        txtEmail.setEditable(true);
        txtTaiKhoan.setEditable(!edit);
        txtPass.setEditable(!edit);
        txtSDT.setEditable(true);
        txtDiaChi.setEditable(true);

        txtNgaySinh.setEnabled(true);
        rdoQuanLy.setEnabled(true);
        rdoNhanVien.setEnabled(true);
        rdoNam.setEnabled(true);
        rdoNu.setEnabled(true);
        btnAdd.setEnabled(!edit);
        btnEdit.setEnabled(edit);
        btnDelete.setEnabled(edit);
        btnClear.setEnabled(true);
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnLast.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }
    void updateStatus2() {
        boolean edit = this.row >= 0;
        boolean first = this.row == 0;
        boolean last = (this.row == tblNV_KHD.getRowCount() - 1);
        txtMaNV.setEditable(!edit);
        txtHoTen.setEditable(!edit);
        txtEmail.setEditable(!edit);
        txtSDT.setEditable(!edit);
        txtDiaChi.setEditable(!edit);
        txtTaiKhoan.setEditable(!edit);
        txtPass.setEditable(!edit);
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(true);
        btnEdit.setEnabled(false);
        btnClear.setEnabled(false);
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }
    void edit() {
        String manv = (String) tblNV_HD.getValueAt(this.row, 0);
        NhanVien nv = dao.selectById(manv);
        this.setFrom(nv);
        Tab.setSelectedIndex(0);
        this.updateStatus();
        tblNV_HD.setRowSelectionInterval(row, row);
    }

    void edit2() {

        String manv = (String) tblNV_KHD.getValueAt(this.row, 0);
        NhanVien nv = dao.selectById(manv);
        this.setFrom(nv);
        Tab.setSelectedIndex(1);
        this.updateStatus2();
        tblNV_KHD.setRowSelectionInterval(row, row);
    }
    void insert(){
        try {
            dao.insert(getForm());
            this.FillTableNV_HD();
            this.clearForm();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            
            MsgBox.alert(this, "Thêm mới thất bại!");
            throw new RuntimeException(e);
        }
    }
    void update(){
        try {
            dao.update(getForm());
            this.FillTableNV_HD();
            this.fillTableNV_KHD();
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
            throw new RuntimeException(e);
        }
    }
    void update2(){
        try {
            dao.update(getForm());
            this.fillTableNV_KHD();
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
            throw new RuntimeException(e);
        }
    }
    void delete(){
        boolean chon = MsgBox.confirm(this, "Bạn muốn xóa nhân viên này?");
        if(!Auth.isManager()){
            MsgBox.alert(this, "Bạn không có quyền xóa!");
        }else if (chon==true) {
            try {
                String manv = txtMaNV.getText();
                dao.delete(manv);
                this.FillTableNV_HD();
                this.fillTableNV_KHD();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
                throw new RuntimeException(e);
            }
        }
    }
    void first(){
        if (Tab.getSelectedIndex()==0) {
            this.row=0;
            this.edit();
        }else{
            this.row=0;
            this.edit2();
        }
    }
    void next(){
        if (Tab.getSelectedIndex()==0) {
            if (this.row<tblNV_HD.getRowCount()-1) {
                this.row++;
                this.edit();
            }
            
        }else{
            if (this.row<tblNV_KHD.getRowCount()-1) {
                this.row++;
                this.edit2();
            }
        }
    }
    void prev(){
        if (Tab.getSelectedIndex()==0) {
            if (this.row>0) {
                this.row--;
                this.edit();
            }
            
        }else{
            if (this.row>0) {
                this.row--;
                this.edit2();
            }
        }
    }
    void last(){
        if (Tab.getSelectedIndex()==0) {
            this.row=tblNV_HD.getRowCount()-1;
            this.edit();           
        }else{
            this.row=tblNV_KHD.getRowCount()-1;
            this.edit2();            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        pnlTong = new javax.swing.JPanel();
        pnlTable = new javax.swing.JPanel();
        Tab = new javax.swing.JTabbedPane();
        pnlTab1 = new javax.swing.JPanel();
        tab1 = new javax.swing.JScrollPane();
        tblNV_HD = new javax.swing.JTable();
        pnlTab2 = new javax.swing.JPanel();
        tab2 = new javax.swing.JScrollPane();
        tblNV_KHD = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtMaNV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        lblTrangThai = new javax.swing.JLabel();
        lblVaiTro = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        txtPass = new javax.swing.JPasswordField();
        txtTaiKhoan = new javax.swing.JTextField();
        rdoQuanLy = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoLamViec = new javax.swing.JRadioButton();
        rdoNghiViec = new javax.swing.JRadioButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        KeNgang = new javax.swing.JSeparator();
        txtNgaySinh = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(1200, 831));
        setPreferredSize(new java.awt.Dimension(1200, 831));

        pnlTong.setBackground(new java.awt.Color(219, 147, 7));
        pnlTong.setMinimumSize(new java.awt.Dimension(1200, 831));
        pnlTong.setPreferredSize(new java.awt.Dimension(1200, 831));

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(140, 88, 0), null, null));

        Tab.setBackground(new java.awt.Color(255, 255, 255));
        Tab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabMouseClicked(evt);
            }
        });

        pnlTab1.setBackground(new java.awt.Color(255, 255, 255));

        tblNV_HD.setForeground(new java.awt.Color(219, 147, 7));
        tblNV_HD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ và tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Email", "Vai trò"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNV_HD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNV_HDMouseClicked(evt);
            }
        });
        tab1.setViewportView(tblNV_HD);

        javax.swing.GroupLayout pnlTab1Layout = new javax.swing.GroupLayout(pnlTab1);
        pnlTab1.setLayout(pnlTab1Layout);
        pnlTab1Layout.setHorizontalGroup(
            pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
        );
        pnlTab1Layout.setVerticalGroup(
            pnlTab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );

        Tab.addTab("Nhân viên hoạt động", pnlTab1);

        pnlTab2.setBackground(new java.awt.Color(255, 255, 255));

        tab2.setBackground(new java.awt.Color(255, 255, 255));

        tblNV_KHD.setForeground(new java.awt.Color(219, 147, 7));
        tblNV_KHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ và tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Email", "Vai trò"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNV_KHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNV_KHDMouseClicked(evt);
            }
        });
        tab2.setViewportView(tblNV_KHD);

        javax.swing.GroupLayout pnlTab2Layout = new javax.swing.GroupLayout(pnlTab2);
        pnlTab2.setLayout(pnlTab2Layout);
        pnlTab2Layout.setHorizontalGroup(
            pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, 1157, Short.MAX_VALUE)
        );
        pnlTab2Layout.setVerticalGroup(
            pnlTab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );

        Tab.addTab("Nhân viên không hoạt động", pnlTab2);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Tab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1164, Short.MAX_VALUE))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
            .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTableLayout.createSequentialGroup()
                    .addComponent(Tab, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblHinh.setBackground(new java.awt.Color(255, 255, 255));
        lblHinh.setForeground(new java.awt.Color(255, 255, 255));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
        );

        lblMaNV.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(255, 255, 255));
        lblMaNV.setText("Mã NV:");

        lblHoTen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoTen.setText("Họ và tên:");

        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(255, 255, 255));
        lblGioiTinh.setText("Giới tính:");

        lblNgaySinh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNgaySinh.setForeground(new java.awt.Color(255, 255, 255));
        lblNgaySinh.setText("Ngày sinh:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        lblSDT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSDT.setForeground(new java.awt.Color(255, 255, 255));
        lblSDT.setText("SDT:");

        btnFirst.setBackground(new java.awt.Color(102, 82, 2));
        btnFirst.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(102, 82, 2));
        btnPrev.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(102, 82, 2));
        btnNext.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(102, 82, 2));
        btnLast.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaNV.setPreferredSize(new java.awt.Dimension(311, 26));
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHoTen.setPreferredSize(new java.awt.Dimension(311, 26));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(311, 26));

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSDT.setPreferredSize(new java.awt.Dimension(311, 26));

        rdoNam.setBackground(new java.awt.Color(219, 147, 7));
        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(255, 255, 255));
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        rdoNu.setBackground(new java.awt.Color(219, 147, 7));
        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(255, 255, 255));
        rdoNu.setText("Nữ");

        lblTrangThai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        lblTrangThai.setText("Trạng thái:");

        lblVaiTro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblVaiTro.setForeground(new java.awt.Color(255, 255, 255));
        lblVaiTro.setText("Vai trò:");

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblMatKhau.setText("Mật khẩu:");

        lblTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lblTaiKhoan.setText("Tài khoản:");

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(255, 255, 255));
        lblDiaChi.setText("Địa chỉ:");

        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPass.setMaximumSize(new java.awt.Dimension(306, 26));
        txtPass.setPreferredSize(new java.awt.Dimension(311, 26));
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        txtTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTaiKhoan.setPreferredSize(new java.awt.Dimension(311, 26));

        rdoQuanLy.setBackground(new java.awt.Color(219, 147, 7));
        buttonGroup2.add(rdoQuanLy);
        rdoQuanLy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rdoQuanLy.setForeground(new java.awt.Color(255, 255, 255));
        rdoQuanLy.setText("Quản lý");
        rdoQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoQuanLyActionPerformed(evt);
            }
        });

        rdoNhanVien.setBackground(new java.awt.Color(219, 147, 7));
        buttonGroup2.add(rdoNhanVien);
        rdoNhanVien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rdoNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        rdoNhanVien.setSelected(true);
        rdoNhanVien.setText("Nhân viên");

        rdoLamViec.setBackground(new java.awt.Color(219, 147, 7));
        buttonGroup3.add(rdoLamViec);
        rdoLamViec.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rdoLamViec.setForeground(new java.awt.Color(255, 255, 255));
        rdoLamViec.setSelected(true);
        rdoLamViec.setText("Làm việc");
        rdoLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLamViecActionPerformed(evt);
            }
        });

        rdoNghiViec.setBackground(new java.awt.Color(219, 147, 7));
        buttonGroup3.add(rdoNghiViec);
        rdoNghiViec.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rdoNghiViec.setForeground(new java.awt.Color(255, 255, 255));
        rdoNghiViec.setText("Nghỉ việc");

        btnClear.setBackground(new java.awt.Color(102, 82, 2));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(102, 82, 2));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(102, 82, 2));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(102, 82, 2));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlTongLayout = new javax.swing.GroupLayout(pnlTong);
        pnlTong.setLayout(pnlTongLayout);
        pnlTongLayout.setHorizontalGroup(
            pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTongLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTongLayout.createSequentialGroup()
                                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlTongLayout.createSequentialGroup()
                                        .addComponent(btnFirst)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPrev)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNext)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLast))
                                    .addGroup(pnlTongLayout.createSequentialGroup()
                                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMaNV)
                                            .addComponent(lblHoTen)
                                            .addComponent(lblEmail)
                                            .addComponent(lblSDT)
                                            .addComponent(lblGioiTinh)
                                            .addComponent(lblNgaySinh))
                                        .addGap(21, 21, 21)
                                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(pnlTongLayout.createSequentialGroup()
                                                .addComponent(rdoNam)
                                                .addGap(46, 46, 46)
                                                .addComponent(rdoNu)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtNgaySinh))))
                                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlTongLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDiaChi)
                                            .addComponent(lblTaiKhoan)
                                            .addComponent(lblMatKhau)
                                            .addComponent(lblVaiTro)
                                            .addComponent(lblTrangThai))
                                        .addGap(25, 25, 25)
                                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTongLayout.createSequentialGroup()
                                                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rdoNhanVien)
                                                    .addComponent(rdoLamViec))
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rdoNghiViec)
                                                    .addComponent(rdoQuanLy))))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnlTongLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEdit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDelete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnClear))))
                            .addComponent(KeNgang))))
                .addContainerGap())
        );
        pnlTongLayout.setVerticalGroup(
            pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTongLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTongLayout.createSequentialGroup()
                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTongLayout.createSequentialGroup()
                                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMaNV)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDiaChi))
                                .addGap(24, 24, 24)
                                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblHoTen)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGioiTinh)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)
                            .addComponent(lblTaiKhoan)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNgaySinh)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMatKhau)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaiTro)
                            .addComponent(rdoNhanVien)
                            .addComponent(rdoQuanLy))
                        .addGap(19, 19, 19)
                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSDT)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrangThai)
                            .addComponent(rdoLamViec)
                            .addComponent(rdoNghiViec))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KeNgang, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst)
                            .addComponent(btnPrev)
                            .addComponent(btnNext)
                            .addComponent(btnLast)
                            .addComponent(btnClear)
                            .addComponent(btnDelete)
                            .addComponent(btnEdit)
                            .addComponent(btnAdd)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        this.first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clearForm();
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            if (true) {
                this.update();
            } else {
                MsgBox.alert(this, "Bạn không có quyền sử dụng chức năng này!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void rdoQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoQuanLyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoQuanLyActionPerformed

    private void rdoLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLamViecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoLamViecActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if (true) {
                this.insert();
            } else {
                MsgBox.alert(this, "Bạn không có quyền sử dụng chức năng này!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (true) {
                this.delete();
            } else {
                MsgBox.alert(this, "Bạn không có quyền sử dụng chức năng này!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        this.prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this.last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblNV_HDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNV_HDMouseClicked
        if (evt.getClickCount()==1) {
            this.row=tblNV_HD.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblNV_HDMouseClicked

    private void tblNV_KHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNV_KHDMouseClicked
        if (evt.getClickCount()==1) {
            this.row=tblNV_KHD.getSelectedRow();
            this.edit2();
        }
    }//GEN-LAST:event_tblNV_KHDMouseClicked

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        chonAnh();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void TabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabMouseClicked
        if(Tab.getSelectedIndex()==0){
            clearForm();
            updateStatus();
        }else{
            clearForm();
            updateStatus2();
        }
    }//GEN-LAST:event_TabMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator KeNgang;
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JPanel pnlTab1;
    private javax.swing.JPanel pnlTab2;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTong;
    private javax.swing.JRadioButton rdoLamViec;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNghiViec;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JScrollPane tab1;
    private javax.swing.JScrollPane tab2;
    private javax.swing.JTable tblNV_HD;
    private javax.swing.JTable tblNV_KHD;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
