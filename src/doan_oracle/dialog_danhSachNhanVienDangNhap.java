/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan_oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class dialog_danhSachNhanVienDangNhap extends javax.swing.JDialog {
    PreparedStatement preparedStatement = null;
    ResultSet resultset = null;
    Connection connection = null;
    
    
    /**
     * Creates new form dialog_danhSachNhanVienDangNhap
     */
    public dialog_danhSachNhanVienDangNhap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        //setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        showData();
        tblList.setRowHeight(50);
    }
    public void showData() {
        String arr[] = {"USER_ID", "USERNAME", "ACCOUNT_STATUS", "EXPIRY_DATE", "DEFAULT_TABLESPACE", "CREATED", "LAST_LOGIN"};
        DefaultTableModel model = new DefaultTableModel(arr, 0);
        try {
            tblList.removeAll();
            
            connection = DBconnection.getConnection();
    //            String query = "SELECT * FROM DBA_USERS WHERE ACCOUNT_STATUS = 'OPEN'";
            String query = "select * from showUserOpen";
            preparedStatement = connection.prepareStatement(query);
            resultset = preparedStatement.executeQuery();
            
            while(resultset.next()) {
                Vector vector = new Vector();
                vector.add(resultset.getString("USER_ID"));
                vector.add(resultset.getString("USERNAME"));
                vector.add(resultset.getString("ACCOUNT_STATUS"));
                vector.add(resultset.getString("EXPIRY_DATE"));
                vector.add(resultset.getString("DEFAULT_TABLESPACE"));
                vector.add(resultset.getString("CREATED"));
                vector.add(resultset.getString("LAST_LOGIN"));
                
                model.addRow(vector);
                tblList.setModel(model);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối User");
        }
    }
    public String showRoleUser() {
   
            try {
            connection = DBconnection.getConnection();
            String query = "select * from DBA_ROLE_PRIVS where GRANTEE = '"+txtUserName.getText()+"'";
            preparedStatement = connection.prepareStatement(query);
            resultset = preparedStatement.executeQuery();
            while(resultset.next()) {
                //JOptionPane.showMessageDialog(this, resultset.getString("GRANTED_ROLE"));
                return resultset.getString("GRANTED_ROLE");          
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xem quyền của nhân viên");
        }
        return null;       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lbl_LanDangNhapCuoi = new javax.swing.JLabel();
        lbl_NgayTao = new javax.swing.JLabel();
        lbl_UserID = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lbl_UserID1 = new javax.swing.JLabel();
        lbl_TrangThai = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnKhoaTaiKhoan = new javax.swing.JButton();
        btnKhoaTaiKhoan1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboRole = new javax.swing.JComboBox<>();
        btnCapNhatQuyen = new javax.swing.JButton();
        btnThuHoiQuyen = new javax.swing.JButton();
        btnXemQuyenHienTai = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Thông tin các nhân viên đang làm việc");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("User ID: ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("User Name: ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Password: ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Ngày tạo: ");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Lần đăng nhập cuối cùng: ");

        txtUserName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lbl_LanDangNhapCuoi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_LanDangNhapCuoi.setText("Lần đăng nhập cuối");

        lbl_NgayTao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_NgayTao.setText("Ngày tạo ");

        lbl_UserID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_UserID.setText("ID");

        txtPassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtPassword.setText("jPasswordField1");
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });

        lbl_UserID1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_UserID1.setText("Trạng thái: ");

        lbl_TrangThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_TrangThai.setText("Trạng thái");

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Cập nhật");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnKhoaTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnKhoaTaiKhoan.setText("Khóa tài khoản");
        btnKhoaTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaTaiKhoanActionPerformed(evt);
            }
        });

        btnKhoaTaiKhoan1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnKhoaTaiKhoan1.setText("Mở khóa tài khoản");
        btnKhoaTaiKhoan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaTaiKhoan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_LanDangNhapCuoi))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_NgayTao)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(lbl_UserID)
                                        .addGap(50, 50, 50)
                                        .addComponent(lbl_UserID1)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_TrangThai))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton1)
                        .addGap(77, 77, 77)
                        .addComponent(btnKhoaTaiKhoan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 125, Short.MAX_VALUE)
                .addComponent(btnKhoaTaiKhoan1)
                .addGap(125, 125, 125))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_UserID)
                    .addComponent(lbl_UserID1)
                    .addComponent(lbl_TrangThai))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_NgayTao))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_LanDangNhapCuoi))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnKhoaTaiKhoan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKhoaTaiKhoan1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phân cấp quyền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Quyền hiện tại: ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Danh sách quyền:");

        cboRole.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "systemManager", "Cashier" }));

        btnCapNhatQuyen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCapNhatQuyen.setText("Cập nhật quyền");
        btnCapNhatQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatQuyenActionPerformed(evt);
            }
        });

        btnThuHoiQuyen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThuHoiQuyen.setText("Thu hồi quyền");
        btnThuHoiQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuHoiQuyenActionPerformed(evt);
            }
        });

        btnXemQuyenHienTai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXemQuyenHienTai.setText("Xem");
        btnXemQuyenHienTai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemQuyenHienTaiActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(63, 63, 63)
                                .addComponent(btnXemQuyenHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnCapNhatQuyen)
                        .addGap(43, 43, 43)
                        .addComponent(btnThuHoiQuyen)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnXemQuyenHienTai))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhatQuyen)
                    .addComponent(btnThuHoiQuyen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Trạng thái: ");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPEN", "ALL", "LOCK" }));
        cboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatusActionPerformed(evt);
            }
        });

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(371, 371, 371))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStatusActionPerformed
        // TODO add your handling code here:
        String arr[] = {"USER_ID", "USERNAME", "ACCOUNT_STATUS", "EXPIRY_DATE", "DEFAULT_TABLESPACE", "CREATED", "LAST_LOGIN"};
        DefaultTableModel model = new DefaultTableModel(arr, 0);
        String item = cboStatus.getSelectedItem().toString();
        if(item == "ALL") {            
            try {   
                connection = DBconnection.getConnection();
                String query = "SELECT * FROM DBA_USERS";
                preparedStatement = connection.prepareStatement(query);
                resultset = preparedStatement.executeQuery();
                while(resultset.next()) {
                    Vector vector = new Vector();
                    vector.add(resultset.getString("USER_ID"));
                    vector.add(resultset.getString("USERNAME"));
                    vector.add(resultset.getString("ACCOUNT_STATUS"));
                    vector.add(resultset.getString("EXPIRY_DATE"));
                    vector.add(resultset.getString("DEFAULT_TABLESPACE"));
                    vector.add(resultset.getString("CREATED"));
                    vector.add(resultset.getString("LAST_LOGIN"));

                    model.addRow(vector);
                    tblList.setModel(model);
                }
            } catch (Exception e) {
                //showData();
            }
        }
        else {
            showData();
        }
    }//GEN-LAST:event_cboStatusActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        // TODO add your handling code here:
        try {
            int i = tblList.getSelectedRow();
            
            TableModel model = tblList.getModel();
            
            lbl_UserID.setText(model.getValueAt(i, 0).toString());
            lbl_TrangThai.setText(model.getValueAt(i, 2).toString());
            txtUserName.setText(model.getValueAt(i, 1).toString());
            lbl_NgayTao.setText(model.getValueAt(i, 3).toString());
            lbl_LanDangNhapCuoi.setText(model.getValueAt(i, 6).toString());
 
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblListMouseClicked
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtUserName.getText() != "") {
        try {
            connection = DBconnection.getConnection();
          //  String query = "ALTER USER '"+txtUserName.getText()+"' identified by '"+txtPassword.getText()+"'";
            String query = "alter user "+txtUserName.getText()+" identified by "+txtPassword.getText()+"";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            updatePasswordUser();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi khi cập nhật mật khẩu");
        }
        }
        else JOptionPane.showMessageDialog(this, "Bạn chưa chọn User");
    }//GEN-LAST:event_jButton1ActionPerformed
    public void updatePasswordUser() {
        try {
            Encode encode = new Encode();
            connection = DBconnection.getConnection("VanHien", "VanHien");
            String query = "UPDATE TBL_tAIKHOAN SET sMatKhau = '"+encode.convertHashToString(txtPassword.getText())+"' WHERE sHoTen = '"+txtUserName.getText().toLowerCase()+"'";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật mật khẩu");
        }
    }
    private void btnKhoaTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaTaiKhoanActionPerformed
        // TODO add your handling code here:
        if(txtUserName.getText() != "") {
        try {
            connection = DBconnection.getConnection();          
            String query = "ALTER USER "+txtUserName.getText()+" ACCOUNT LOCK";          
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
           
           JOptionPane.showMessageDialog(this, "Khóa tài khoản thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi khóa tài khoản User");
        }
        }
        else JOptionPane.showMessageDialog(this, "Bạn chưa chọn User");
    }//GEN-LAST:event_btnKhoaTaiKhoanActionPerformed

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        // TODO add your handling code here:
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void btnKhoaTaiKhoan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaTaiKhoan1ActionPerformed
        // TODO add your handling code here:
        if(txtUserName.getText() != "") {
        try {
            connection = DBconnection.getConnection();          
            String query = "ALTER USER "+txtUserName.getText()+" ACCOUNT UNLOCK";          
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
           
           JOptionPane.showMessageDialog(this, "Mở khóa tài khoản thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi khóa tài khoản User");
        }
        }
        else JOptionPane.showMessageDialog(this, "Bạn chưa chọn User");
    }//GEN-LAST:event_btnKhoaTaiKhoan1ActionPerformed
    
    private void btnXemQuyenHienTaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemQuyenHienTaiActionPerformed
        // TODO add your handling code here:
//        try {
//            connection = DBconnection.getConnection();
//            String query = "select * from DBA_ROLE_PRIVS where GRANTEE = '"+txtUserName.getText()+"'";
//            preparedStatement = connection.prepareStatement(query);
//            resultset = preparedStatement.executeQuery();
//            while(resultset.next()) {
//                JOptionPane.showMessageDialog(this, resultset.getString("GRANTED_ROLE"));
//            }
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Lỗi khi xem quyền của nhân viên");
//        }
        if(showRoleUser() != null) {
            JOptionPane.showMessageDialog(this, showRoleUser().toString());
        }
        else {
            JOptionPane.showMessageDialog(this, "Không có quyền nào cả");
        }
    }//GEN-LAST:event_btnXemQuyenHienTaiActionPerformed

    private void btnThuHoiQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuHoiQuyenActionPerformed
        // TODO add your handling code here:
        if(showRoleUser() != null) {
            try {            
                int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc thu hồi quyền không", "Thu hồi", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                connection = DBconnection.getConnection();
                String query = "REVOKE "+cboRole.getSelectedItem().toString()+" FROM "+txtUserName.getText()+"";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Thu hồi thành công");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Có lỗi khi thu hồi quyền của user");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Không có quyền nào cả");
        }    
       
        
    }//GEN-LAST:event_btnThuHoiQuyenActionPerformed

    private void btnCapNhatQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatQuyenActionPerformed
        // TODO add your handling code here:
           try {
            connection = DBconnection.getConnection();
            String query = "GRANT "+cboRole.getSelectedItem().toString()+" to "+txtUserName.getText()+"";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Cấp quyền thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi khi cập nhật quyền");
        }
    }//GEN-LAST:event_btnCapNhatQuyenActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
            // TODO add your handling code here:
            int reply = JOptionPane.showConfirmDialog(null, "Có muốn thoát thật không", "Exit", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION){
            System.exit(0);
            }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        try {
            String arr[] = {"USER_ID", "USERNAME", "ACCOUNT_STATUS", "EXPIRY_DATE", "DEFAULT_TABLESPACE", "CREATED", "LAST_LOGIN"};
            DefaultTableModel model = new DefaultTableModel(arr, 0);
            connection = DBconnection.getConnection();
            String query = "SELECT * FROM DBA_USERS WHERE USERNAME LIKE '%"+txtSearch.getText().trim().toUpperCase()+"%'";
            preparedStatement= connection.prepareStatement(query);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {                
                Vector vector = new Vector();   
                vector.add(resultset.getString("USER_ID"));
                vector.add(resultset.getString("USERNAME"));
                vector.add(resultset.getString("ACCOUNT_STATUS"));
                vector.add(resultset.getString("EXPIRY_DATE"));
                vector.add(resultset.getString("DEFAULT_TABLESPACE"));
                vector.add(resultset.getString("CREATED"));
                vector.add(resultset.getString("LAST_LOGIN"));

                model.addRow(vector);              
            }
            tblList.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gặp lỗi khi tìm kiếm tên user");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dialog_danhSachNhanVienDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialog_danhSachNhanVienDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialog_danhSachNhanVienDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialog_danhSachNhanVienDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialog_danhSachNhanVienDangNhap dialog = new dialog_danhSachNhanVienDangNhap(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatQuyen;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnKhoaTaiKhoan;
    private javax.swing.JButton btnKhoaTaiKhoan1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThuHoiQuyen;
    private javax.swing.JButton btnXemQuyenHienTai;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_LanDangNhapCuoi;
    private javax.swing.JLabel lbl_NgayTao;
    private javax.swing.JLabel lbl_TrangThai;
    private javax.swing.JLabel lbl_UserID;
    private javax.swing.JLabel lbl_UserID1;
    private javax.swing.JTable tblList;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
