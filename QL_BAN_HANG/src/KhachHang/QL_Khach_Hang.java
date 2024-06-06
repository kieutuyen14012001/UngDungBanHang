/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KhachHang;
import ConnectDatabase.DBConnect;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kieut
 */
public class QL_Khach_Hang  extends javax.swing.JPanel implements java.beans.Customizer {
 private Object bean;
    /**
     * Creates new form QL_Khach_Hang
     */
    public QL_Khach_Hang() {
        initComponents();
        loadData_KHACH_HANG();
    }
 public void setObject(Object bean) {
        this.bean = bean;
    }
    private DefaultTableModel dtm_KHACH_HANG = new DefaultTableModel();
    private void loadData_KHACH_HANG() {
        dtm_KHACH_HANG = new DefaultTableModel();
        try {
            String sql = "select * from KHACH_HANG";
            DBConnect conn = new DBConnect();
            ResultSet Viet = conn.Query_Db(sql);
            //Create colum for table
            dtm_KHACH_HANG.addColumn("MA_KHACH_HANG");
            dtm_KHACH_HANG.addColumn("TEN_KHACH_HANG");
            dtm_KHACH_HANG.addColumn("SO_DIEN_THOAI");
            dtm_KHACH_HANG.addColumn("EMAIL");
            

            while (Viet.next()) {
                String str_MA_KHACH_HANG = Viet.getString(1);
                String str_TEN_KHACH_HANG = Viet.getString(2);
                String str_SO_DIEN_THOAI = Viet.getString(3);
                String str_EMAIL = Viet.getString(4);
                

                Vector row = new Vector();
                row.addElement(str_MA_KHACH_HANG);
                row.addElement(str_TEN_KHACH_HANG);
                row.addElement(str_SO_DIEN_THOAI);
                row.addElement(str_EMAIL);
               
                dtm_KHACH_HANG.addRow(row);
            }
            tbl_kh.setModel(dtm_KHACH_HANG);
            conn.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void InsertData_KHACH_HANG() {
        String sql = null;
        DBConnect conn = new DBConnect();
        String var_MA_KHACH_HANG = txt_makh3.getText();
        String var_TEN_KHACH_HANG = txt_tenkh.getText();
        String var_SO_DIEN_THOAI = txt_sdt.getText();
        String var_EMAIL = txt_email.getText();
      

        sql = "INSERT INTO KHACH_HANG(MA_KHACH_HANG,TEN_KHACH_HANG,SO_DIEN_THOAI,EMAIL) VALUES (N'" + var_MA_KHACH_HANG + "',N'" + var_TEN_KHACH_HANG + "',N'" + var_SO_DIEN_THOAI + "',N'" + var_EMAIL +  "')";

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
        txt_makh3.setText("");
        txt_tenkh.setText("");
        txt_sdt.setText("");
        txt_email.setText("");
      
    }

    private void UpdateData_KHACH_HANG() {
        String sql = null;
        DBConnect conn = new DBConnect();
        String var_MA_KHACH_HANG = txt_makh3.getText();
        String var_TEN_KHACH_HANG = txt_tenkh.getText();
        String var_SO_DIEN_THOAI = txt_sdt.getText();
        String var_EMAIL= txt_email.getText();
        

        sql = "UPDATE KHACH_HANG SET MA_KHACH_HANG=N'" + var_MA_KHACH_HANG + "',TEN_KHACH_HANG=N'" + var_TEN_KHACH_HANG + "',SO_DIEN_THOAI=N'" + var_SO_DIEN_THOAI + "',EMAIL=N'" + var_EMAIL +  "' WHERE MA_KHACH_HANG=N'" + var_MA_KHACH_HANG + "'";

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
        DefaultTableModel model = (DefaultTableModel) tbl_kh.getModel();
        txt_makh3.setText(model.getValueAt(tbl_kh.getSelectedRow(), 0).toString());
        txt_tenkh.setText(model.getValueAt(tbl_kh.getSelectedRow(), 1).toString());
        txt_sdt.setText(model.getValueAt(tbl_kh.getSelectedRow(), 2).toString());
        txt_email.setText(model.getValueAt(tbl_kh.getSelectedRow(), 3).toString());
       

    }

    private void DeleteData_KHACH_HANG() {
        String sql = null;
        DBConnect conn = new DBConnect();
        String var_MA_KHACH_HANG = txt_makh3.getText();
        sql = "DELETE FROM  KHACH_HANG WHERE MA_KHACH_HANG=N'" + var_MA_KHACH_HANG + "'";

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
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_tenkh = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_makh3 = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        bnt_xoa = new javax.swing.JButton();
        bnt_reset = new javax.swing.JButton();
        bnt_sua1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kh = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1800, 1000));
        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên KHách Hàng");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 180, 120, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SĐT");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(400, 170, 90, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(400, 80, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mã KHách Hàng");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 80, 110, 30);

        txt_tenkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenkhActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tenkh);
        txt_tenkh.setBounds(200, 180, 150, 30);

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_email);
        txt_email.setBounds(500, 80, 150, 30);

        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });
        jPanel1.add(txt_sdt);
        txt_sdt.setBounds(500, 170, 150, 30);

        txt_makh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_makh3ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_makh3);
        txt_makh3.setBounds(200, 80, 150, 30);

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add);
        btn_add.setBounds(800, 50, 100, 50);

        bnt_xoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bnt_xoa.setText("DELETE");
        bnt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(bnt_xoa);
        bnt_xoa.setBounds(980, 160, 101, 50);

        bnt_reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bnt_reset.setText("Reset");
        bnt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_resetActionPerformed(evt);
            }
        });
        jPanel1.add(bnt_reset);
        bnt_reset.setBounds(800, 160, 100, 50);

        bnt_sua1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bnt_sua1.setText("Sửa");
        bnt_sua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_sua1ActionPerformed(evt);
            }
        });
        jPanel1.add(bnt_sua1);
        bnt_sua1.setBounds(980, 50, 100, 50);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tổng-hợp-hình-nền-full-HD-1920-x-1080-đẹp-nhất-6.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 1190, 290);

        add(jPanel1);
        jPanel1.setBounds(330, 240, 1190, 290);

        tbl_kh.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_kh);

        add(jScrollPane1);
        jScrollPane1.setBounds(370, 620, 1160, 270);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản Lý Khách Hàng");
        add(jLabel1);
        jLabel1.setBounds(680, 90, 520, 50);

        jLabel8.setText("jLabel8");
        add(jLabel8);
        jLabel8.setBounds(461, 486, 110, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tổng-hợp-hình-nền-full-HD-1920-x-1080-đẹp-nhất-6.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        add(jLabel9);
        jLabel9.setBounds(1, 0, 1710, 940);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenkhActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private void txt_makh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_makh3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_makh3ActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        InsertData_KHACH_HANG();
        LoadDataFromTable2Control();
    }//GEN-LAST:event_btn_addActionPerformed

    private void bnt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_xoaActionPerformed
       DeleteData_KHACH_HANG();
       LoadDataFromTable2Control();
    }//GEN-LAST:event_bnt_xoaActionPerformed

    private void bnt_sua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_sua1ActionPerformed
        UpdateData_KHACH_HANG();
        LoadDataFromTable2Control();
    }//GEN-LAST:event_bnt_sua1ActionPerformed

    private void bnt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_resetActionPerformed
        ResetControl();
    }//GEN-LAST:event_bnt_resetActionPerformed

    private void tbl_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khMouseClicked
       LoadDataFromTable2Control();
    }//GEN-LAST:event_tbl_khMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_reset;
    private javax.swing.JButton bnt_sua1;
    private javax.swing.JButton bnt_xoa;
    private javax.swing.JButton btn_add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_kh;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_makh3;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenkh;
    // End of variables declaration//GEN-END:variables
}
