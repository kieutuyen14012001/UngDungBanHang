/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanPham;

import ConnectDatabase.DBConnect;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QL_San_Pham extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer QL_San_Pham
     */
    public QL_San_Pham() {
        initComponents();
        loadData_SAN_PHAM();
        
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }
    
private DefaultTableModel dtm_SAN_PHAM = new DefaultTableModel();
private void loadData_SAN_PHAM() {
	dtm_SAN_PHAM = new DefaultTableModel();
	try {
		String sql = "select * from SAN_PHAM";
		DBConnect conn = new DBConnect();
		ResultSet rs = conn.Query_Db(sql);
		//Create colum for table
		dtm_SAN_PHAM.addColumn("MA_SAN_PHAM");
		dtm_SAN_PHAM.addColumn("TEN_SAN_PHAM");
		dtm_SAN_PHAM.addColumn("LOAI_SAN_PHAM");
		dtm_SAN_PHAM.addColumn("SO_LUONG");
		dtm_SAN_PHAM.addColumn("DON_GIA");
		while (rs.next()) {
			String str_MA_SAN_PHAM=rs.getString(1);
			String str_TEN_SAN_PHAM=rs.getString(2);
			String str_LOAI_SAN_PHAM=rs.getString(3);
			String str_SO_LUONG=rs.getString(4);
			String str_DON_GIA=rs.getString(5);
			Vector row = new Vector();
			row.addElement(str_MA_SAN_PHAM);
			row.addElement(str_TEN_SAN_PHAM);
			row.addElement(str_LOAI_SAN_PHAM);
			row.addElement(str_SO_LUONG);
			row.addElement(str_DON_GIA);
			dtm_SAN_PHAM.addRow(row);
		}tbl_SAN_PHAM.setModel(dtm_SAN_PHAM);
		conn.closeConnection();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

 private void InsertData_SAN_PHAM() {
	String sql = null;
	DBConnect conn = new DBConnect();
	String var_MA_SAN_PHAM=txt_MA_SAN_PHAM.getText();
	String var_TEN_SAN_PHAM=txt_TEN_SAN_PHAM.getText();
	String var_LOAI_SAN_PHAM=txt_LOAI_SAN_PHAM.getText();
	String var_SO_LUONG=txt_SO_LUONG.getText();
	String var_DON_GIA=txt_DON_GIA.getText();
	sql = "INSERT INTO SAN_PHAM(MA_SAN_PHAM,TEN_SAN_PHAM,LOAI_SAN_PHAM,SO_LUONG,DON_GIA) VALUES (N'"+var_MA_SAN_PHAM+"',N'"+var_TEN_SAN_PHAM+"',N'"+var_LOAI_SAN_PHAM+"',"+var_SO_LUONG+","+var_DON_GIA+")";
 
	try {
			conn.ExecuteQuery(sql);
			JOptionPane.showMessageDialog(this, "Them thanh cong!");
			ResetControl();
			conn.closeConnection();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
 private void ResetControl(){
	txt_MA_SAN_PHAM.setText("");
	txt_TEN_SAN_PHAM.setText("");
	txt_LOAI_SAN_PHAM.setText("");
	txt_SO_LUONG.setText("");
	txt_DON_GIA.setText("");
}

 private void UpdateData_SAN_PHAM() {
	String sql = null;
	DBConnect conn = new DBConnect();
	String var_MA_SAN_PHAM=txt_MA_SAN_PHAM.getText();
	String var_TEN_SAN_PHAM=txt_TEN_SAN_PHAM.getText();
	String var_LOAI_SAN_PHAM=txt_LOAI_SAN_PHAM.getText();
	String var_SO_LUONG=txt_SO_LUONG.getText();
	String var_DON_GIA=txt_DON_GIA.getText();
	sql = "UPDATE SAN_PHAM SET MA_SAN_PHAM=N'"+var_MA_SAN_PHAM+"',TEN_SAN_PHAM=N'"+var_TEN_SAN_PHAM+"',LOAI_SAN_PHAM=N'"+var_LOAI_SAN_PHAM+"',SO_LUONG="+var_SO_LUONG+",DON_GIA="+var_DON_GIA+" WHERE MA_SAN_PHAM=N'"+var_MA_SAN_PHAM+"'";
 
	try {
			conn.ExecuteQuery(sql);
			JOptionPane.showMessageDialog(this, "Cap nhat thanh cong!");
			ResetControl();
			conn.closeConnection();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
private void LoadDataFromTable2Control(){
	DefaultTableModel model = (DefaultTableModel) tbl_SAN_PHAM.getModel();
	txt_MA_SAN_PHAM.setText(model.getValueAt(tbl_SAN_PHAM.getSelectedRow(), 0).toString());
	txt_TEN_SAN_PHAM.setText(model.getValueAt(tbl_SAN_PHAM.getSelectedRow(), 1).toString());
	txt_LOAI_SAN_PHAM.setText(model.getValueAt(tbl_SAN_PHAM.getSelectedRow(), 2).toString());
	txt_SO_LUONG.setText(model.getValueAt(tbl_SAN_PHAM.getSelectedRow(), 3).toString());
	txt_DON_GIA.setText(model.getValueAt(tbl_SAN_PHAM.getSelectedRow(), 4).toString());
}

 private void DeleteData_SAN_PHAM() {
	String sql = null;
	DBConnect conn = new DBConnect();
	String var_MA_SAN_PHAM=txt_MA_SAN_PHAM.getText();
	sql = "DELETE FROM  SAN_PHAM WHERE MA_SAN_PHAM=N'"+var_MA_SAN_PHAM+"'";
 
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
        tbl_SAN_PHAM = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblSP = new javax.swing.JLabel();
        txt_MA_SAN_PHAM = new javax.swing.JTextField();
        lblSP1 = new javax.swing.JLabel();
        txt_TEN_SAN_PHAM = new javax.swing.JTextField();
        txt_LOAI_SAN_PHAM = new javax.swing.JTextField();
        lblSP2 = new javax.swing.JLabel();
        lblSP3 = new javax.swing.JLabel();
        txt_SO_LUONG = new javax.swing.JTextField();
        lblSP4 = new javax.swing.JLabel();
        txt_DON_GIA = new javax.swing.JTextField();
        jbExit1 = new javax.swing.JButton();
        jbExit2 = new javax.swing.JButton();
        jbExit3 = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        lblSP5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 240, 241));
        setPreferredSize(new java.awt.Dimension(1800, 1000));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_SAN_PHAM.setBackground(new java.awt.Color(153, 153, 153));
        tbl_SAN_PHAM.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_SAN_PHAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SAN_PHAMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SAN_PHAM);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 1250, 250));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP.setForeground(new java.awt.Color(255, 255, 255));
        lblSP.setText("Mã sản phẩm");
        jPanel1.add(lblSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 40, -1, -1));
        jPanel1.add(txt_MA_SAN_PHAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 36, 212, -1));

        lblSP1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP1.setForeground(new java.awt.Color(255, 255, 255));
        lblSP1.setText("Tên sản phẩm");
        jPanel1.add(lblSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txt_TEN_SAN_PHAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TEN_SAN_PHAMActionPerformed(evt);
            }
        });
        jPanel1.add(txt_TEN_SAN_PHAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 212, -1));
        jPanel1.add(txt_LOAI_SAN_PHAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 212, -1));

        lblSP2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP2.setForeground(new java.awt.Color(255, 255, 255));
        lblSP2.setText("Loại sản phẩm");
        jPanel1.add(lblSP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        lblSP3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP3.setForeground(new java.awt.Color(255, 255, 255));
        lblSP3.setText("Số lượng:");
        jPanel1.add(lblSP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 40, -1, -1));
        jPanel1.add(txt_SO_LUONG, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 36, 128, -1));

        lblSP4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSP4.setForeground(new java.awt.Color(255, 255, 255));
        lblSP4.setText("Đơn giá:");
        jPanel1.add(lblSP4, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 91, -1, -1));
        jPanel1.add(txt_DON_GIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 87, 128, -1));

        jbExit1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExit1.setForeground(new java.awt.Color(0, 153, 153));
        jbExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cash_stack_add.png"))); // NOI18N
        jbExit1.setText("Add");
        jbExit1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExit1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 109, 50));

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
        jPanel1.add(jbExit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, -1, 50));

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
        jPanel1.add(jbExit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 109, 50));

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
        jPanel1.add(jbExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 113, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 1250, 200));

        lblSP5.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        lblSP5.setForeground(new java.awt.Color(51, 51, 51));
        lblSP5.setText("QUẢN LÝ SẢN PHẨM");
        add(lblSP5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 510, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tổng-hợp-hình-nền-full-HD-1920-x-1080-đẹp-nhất-6.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 2360, 1020));
    }// </editor-fold>//GEN-END:initComponents

    private void jbExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExit1ActionPerformed
        // TODO add your handling code here:
        InsertData_SAN_PHAM();
        loadData_SAN_PHAM();
    }//GEN-LAST:event_jbExit1ActionPerformed

    private void jbExit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExit2ActionPerformed
        // TODO add your handling code here:
        UpdateData_SAN_PHAM();
        loadData_SAN_PHAM();
    }//GEN-LAST:event_jbExit2ActionPerformed

    private void jbExit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExit3ActionPerformed
        // TODO add your handling code here:
        DeleteData_SAN_PHAM();
        loadData_SAN_PHAM();
    }//GEN-LAST:event_jbExit3ActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        ResetControl();
    }//GEN-LAST:event_jbExitActionPerformed

    private void tbl_SAN_PHAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SAN_PHAMMouseClicked
        // TODO add your handling code here:
        LoadDataFromTable2Control();
    }//GEN-LAST:event_tbl_SAN_PHAMMouseClicked

    private void txt_TEN_SAN_PHAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TEN_SAN_PHAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TEN_SAN_PHAMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable tbl_SAN_PHAM;
    private javax.swing.JTextField txt_DON_GIA;
    private javax.swing.JTextField txt_LOAI_SAN_PHAM;
    private javax.swing.JTextField txt_MA_SAN_PHAM;
    private javax.swing.JTextField txt_SO_LUONG;
    private javax.swing.JTextField txt_TEN_SAN_PHAM;
    // End of variables declaration//GEN-END:variables
}
