/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;

import ConnectDatabase.DBConnect;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class QL_Nhan_vien extends javax.swing.JPanel implements java.beans.Customizer {

    private Object bean;

    /**
     * Creates new customizer QL_Nhan_vien
     */
    public QL_Nhan_vien() {
        initComponents();
        loadData_NHAN_VIEN();
        
    }

    @Override
    public void setObject(Object bean) {
        this.bean = bean;
    }

    private DefaultTableModel dtm_NHAN_VIEN = new DefaultTableModel();

    private void loadData_NHAN_VIEN() {
        dtm_NHAN_VIEN = new DefaultTableModel();
        try {
            String sql = "select * from NHAN_VIEN";
            DBConnect conn = new DBConnect();
            
            ResultSet Viet = conn.Query_Db(sql);
            //Create colum for table
            dtm_NHAN_VIEN.addColumn("MA_NHAN_VIEN");
            dtm_NHAN_VIEN.addColumn("TEN_NHAN_VIEN");
            dtm_NHAN_VIEN.addColumn("DIEN_THOAI");
            dtm_NHAN_VIEN.addColumn("TEN_DANG_NHAP");
            dtm_NHAN_VIEN.addColumn("MAT_KHAU");
            dtm_NHAN_VIEN.addColumn("GIOI_TINH");

            while (Viet.next()) {
                String str_MA_NHAN_VIEN = Viet.getString(1);
                String str_TEN_NHAN_VIEN = Viet.getString(2);
                String str_DIEN_THOAI = Viet.getString(3);
                String str_TEN_DANG_NHAP = Viet.getString(4);
                String str_MAT_KHAU = Viet.getString(5);
                String str_gt = Viet.getString(6);

                Vector row = new Vector();
                row.addElement(str_MA_NHAN_VIEN);
                row.addElement(str_TEN_NHAN_VIEN);
                row.addElement(str_DIEN_THOAI);
                row.addElement(str_TEN_DANG_NHAP);
                row.addElement(str_MAT_KHAU);
                row.addElement(str_gt);

                dtm_NHAN_VIEN.addRow(row);
            }
            tbl_NHAN_VIEN.setModel(dtm_NHAN_VIEN);
            conn.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void InsertData_NHAN_VIEN() {
        String sql = null;
        DBConnect conn = new DBConnect();
        String var_MA_NHAN_VIEN = txt_MA_NHAN_VIEN.getText();
        String var_TEN_NHAN_VIEN = txt_TEN_NHAN_VIEN.getText();
        String var_DIEN_THOAI = txt_DIEN_THOAI.getText();
        String var_TEN_DANG_NHAP = txt_TEN_DANG_NHAP.getText();
        String var_MAT_KHAU = txt_MAT_KHAU.getText();
        String var_gt = gt.getText();

        sql = "INSERT INTO NHAN_VIEN(MA_NHAN_VIEN,TEN_NHAN_VIEN,DIEN_THOAI,TEN_DANG_NHAP,MAT_KHAU) VALUES (N'" + var_MA_NHAN_VIEN + "',N'" + var_TEN_NHAN_VIEN + "',N'" + var_DIEN_THOAI + "',N'" + var_TEN_DANG_NHAP + "',N'" + var_MAT_KHAU + "')";

        try {
            conn.ExecuteQuery(sql);
            JOptionPane.showMessageDialog(this, "Them thanh cong!");
            ResetControl();
            conn.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ResetControl() {
        txt_MA_NHAN_VIEN.setText("");
        txt_TEN_NHAN_VIEN.setText("");
        txt_DIEN_THOAI.setText("");
        txt_TEN_DANG_NHAP.setText("");
        txt_MAT_KHAU.setText("");
        gt.setText("");

    }

    private void UpdateData_NHAN_VIEN() {
        String sql = null;
        DBConnect conn = new DBConnect();
        String var_MA_NHAN_VIEN = txt_MA_NHAN_VIEN.getText();
        String var_TEN_NHAN_VIEN = txt_TEN_NHAN_VIEN.getText();
        String var_DIEN_THOAI = txt_DIEN_THOAI.getText();
        String var_TEN_DANG_NHAP = txt_TEN_DANG_NHAP.getText();
        String var_MAT_KHAU = txt_MAT_KHAU.getText();
        String var_gt = gt.getText();

        sql = "UPDATE NHAN_VIEN SET MA_NHAN_VIEN=N'" + var_MA_NHAN_VIEN + "',TEN_NHAN_VIEN=N'" + var_TEN_NHAN_VIEN + "',DIEN_THOAI=N'" + var_DIEN_THOAI + "',TEN_DANG_NHAP=N'" + var_TEN_DANG_NHAP + "',MAT_KHAU=N'" + var_MAT_KHAU + "',gt=N'" + var_gt + "' WHERE MA_NHAN_VIEN=N'" + var_MA_NHAN_VIEN + "'";

        try {
            conn.ExecuteQuery(sql);
            JOptionPane.showMessageDialog(this, "Cap nhat thanh cong!");
            ResetControl();
            conn.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadDataFromTable2Control() {
        DefaultTableModel model = (DefaultTableModel) tbl_NHAN_VIEN.getModel();
        txt_MA_NHAN_VIEN.setText(model.getValueAt(tbl_NHAN_VIEN.getSelectedRow(), 0).toString());
        txt_TEN_NHAN_VIEN.setText(model.getValueAt(tbl_NHAN_VIEN.getSelectedRow(), 1).toString());
        txt_DIEN_THOAI.setText(model.getValueAt(tbl_NHAN_VIEN.getSelectedRow(), 2).toString());
        txt_TEN_DANG_NHAP.setText(model.getValueAt(tbl_NHAN_VIEN.getSelectedRow(), 3).toString());
        txt_MAT_KHAU.setText(model.getValueAt(tbl_NHAN_VIEN.getSelectedRow(), 4).toString());
        gt.setText(model.getValueAt(tbl_NHAN_VIEN.getSelectedRow(), 5).toString());

    }

    private void DeleteData_NHAN_VIEN() {
        String sql = null;
        DBConnect conn = new DBConnect();
        String var_MA_NHAN_VIEN = txt_MA_NHAN_VIEN.getText();
        sql = "DELETE FROM  NHAN_VIEN WHERE MA_NHAN_VIEN=N'" + var_MA_NHAN_VIEN + "'";

        try {
            conn.ExecuteQuery(sql);
            JOptionPane.showMessageDialog(this, "Xoa thanh cong!");
            ResetControl();
            conn.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NHAN_VIEN = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblSP = new javax.swing.JLabel();
        txt_MA_NHAN_VIEN = new javax.swing.JTextField();
        lblSP1 = new javax.swing.JLabel();
        txt_TEN_NHAN_VIEN = new javax.swing.JTextField();
        txt_DIEN_THOAI = new javax.swing.JTextField();
        lblSP2 = new javax.swing.JLabel();
        lblSP3 = new javax.swing.JLabel();
        txt_TEN_DANG_NHAP = new javax.swing.JTextField();
        lblSP4 = new javax.swing.JLabel();
        txt_MAT_KHAU = new javax.swing.JTextField();
        jbExit1 = new javax.swing.JButton();
        jbExit2 = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jbExit3 = new javax.swing.JButton();
        mk = new javax.swing.JLabel();
        gt = new javax.swing.JTextField();
        lblSP5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1800, 1000));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_NHAN_VIEN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbl_NHAN_VIEN.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_NHAN_VIEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NHAN_VIENMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NHAN_VIEN);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, 1290, 210));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP.setForeground(new java.awt.Color(0, 153, 153));
        lblSP.setText("Mã nhân viên");

        txt_MA_NHAN_VIEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MA_NHAN_VIENActionPerformed(evt);
            }
        });

        lblSP1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP1.setForeground(new java.awt.Color(0, 153, 153));
        lblSP1.setText("Tên nhân viên");

        lblSP2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP2.setForeground(new java.awt.Color(0, 153, 153));
        lblSP2.setText("Điện thoại");

        lblSP3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP3.setForeground(new java.awt.Color(0, 153, 153));
        lblSP3.setText("Tên đăng nhập");

        lblSP4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP4.setForeground(new java.awt.Color(0, 153, 153));
        lblSP4.setText("Mật khẩu");

        jbExit1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExit1.setForeground(new java.awt.Color(0, 153, 153));
        jbExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        jbExit1.setText("Add");
        jbExit1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExit1ActionPerformed(evt);
            }
        });

        jbExit2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExit2.setForeground(new java.awt.Color(0, 153, 153));
        jbExit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/software_update.png"))); // NOI18N
        jbExit2.setText("Update");
        jbExit2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbExit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExit2ActionPerformed(evt);
            }
        });

        jbExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExit.setForeground(new java.awt.Color(0, 153, 153));
        jbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gnome_edit_undo.png"))); // NOI18N
        jbExit.setText("Reset");
        jbExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        jbExit3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExit3.setForeground(new java.awt.Color(0, 153, 153));
        jbExit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deletered.png"))); // NOI18N
        jbExit3.setText("Delete");
        jbExit3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbExit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExit3ActionPerformed(evt);
            }
        });

        mk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mk.setForeground(new java.awt.Color(0, 135, 135));
        mk.setText("Giới Tính");

        gt.setToolTipText("");
        gt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(txt_MA_NHAN_VIEN, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSP3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_TEN_DANG_NHAP, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblSP2)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSP)
                                    .addComponent(lblSP1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_TEN_NHAN_VIEN, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSP4)
                                .addGap(47, 47, 47))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_DIEN_THOAI, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mk, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MAT_KHAU, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExit3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbExit2)
                    .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSP)
                    .addComponent(txt_MA_NHAN_VIEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSP3)
                    .addComponent(txt_TEN_DANG_NHAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_TEN_NHAN_VIEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_MAT_KHAU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSP4))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSP2)
                            .addComponent(txt_DIEN_THOAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mk, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblSP1))
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExit2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExit3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 1290, 270));

        lblSP5.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        lblSP5.setText("QUẢN LÝ NHÂN VIÊN");
        add(lblSP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 390, 50));

        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1800, 50, 60, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tổng-hợp-hình-nền-full-HD-1920-x-1080-đẹp-nhất-6.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2120, 1080));
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_NHAN_VIENMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NHAN_VIENMouseClicked
        // TODO add your handling code here:
        LoadDataFromTable2Control();
    }//GEN-LAST:event_tbl_NHAN_VIENMouseClicked

    private void jbExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExit1ActionPerformed
        // TODO add your handling code here:
        InsertData_NHAN_VIEN();
        loadData_NHAN_VIEN();
    }//GEN-LAST:event_jbExit1ActionPerformed

    private void jbExit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExit2ActionPerformed
        // TODO add your handling code here:
        UpdateData_NHAN_VIEN();
        loadData_NHAN_VIEN();
    }//GEN-LAST:event_jbExit2ActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        ResetControl();
    }//GEN-LAST:event_jbExitActionPerformed

    private void jbExit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExit3ActionPerformed
        // TODO add your handling code here:
        DeleteData_NHAN_VIEN();
        loadData_NHAN_VIEN();
    }//GEN-LAST:event_jbExit3ActionPerformed

    private void txt_MA_NHAN_VIENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MA_NHAN_VIENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MA_NHAN_VIENActionPerformed

    private void gtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField gt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbExit1;
    private javax.swing.JButton jbExit2;
    private javax.swing.JButton jbExit3;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblSP1;
    private javax.swing.JLabel lblSP2;
    private javax.swing.JLabel lblSP3;
    private javax.swing.JLabel lblSP4;
    private javax.swing.JLabel lblSP5;
    private javax.swing.JLabel mk;
    private javax.swing.JTable tbl_NHAN_VIEN;
    private javax.swing.JTextField txt_DIEN_THOAI;
    private javax.swing.JTextField txt_MAT_KHAU;
    private javax.swing.JTextField txt_MA_NHAN_VIEN;
    private javax.swing.JTextField txt_TEN_DANG_NHAP;
    private javax.swing.JTextField txt_TEN_NHAN_VIEN;
    // End of variables declaration//GEN-END:variables
}
