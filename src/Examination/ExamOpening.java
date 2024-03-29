/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examination;

import Questions.JavaQuestions;
import DatabaseManager.mysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author EJ
 */
public class ExamOpening extends javax.swing.JInternalFrame {
    
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form JavaExamOpening
     */
    public ExamOpening() {
        initComponents();
    }
    
    public ExamOpening(String username) {
        initComponents();
        connection = mysqlConnection.dbConnector();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        getData(username);
    }
    
    public void getData(String username){
        
        try{
	String sql = "select * from student where username=?";
	pst = connection.prepareStatement(sql);
	pst.setString(1, username);
	rs = pst.executeQuery();
	
	if(rs.next()){
            lbl_name.setText(rs.getString("last name") + ", " + rs.getString("first name"));
            lbl_program.setText(rs.getString("program"));
            lbl_student_number.setText(Integer.toString(rs.getInt("student #")));       
	}
        pst.close();
        }catch(Exception e){
                e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_student_number = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_program = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(540, 390));
        setMinimumSize(new java.awt.Dimension(540, 390));
        setPreferredSize(new java.awt.Dimension(540, 390));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Forte", 1, 48)); // NOI18N
        jLabel1.setText("EXAMINATION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Forte", 1, 30)); // NOI18N
        jLabel2.setText("in Java, SQL, & Database");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        lbl_student_number.setFont(new java.awt.Font("Forte", 1, 24)); // NOI18N
        lbl_student_number.setText("Student #");
        getContentPane().add(lbl_student_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 224, -1, -1));

        lbl_name.setFont(new java.awt.Font("Forte", 1, 24)); // NOI18N
        lbl_name.setText("Last name + First name");
        getContentPane().add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 264, -1, -1));

        lbl_program.setFont(new java.awt.Font("Forte", 1, 24)); // NOI18N
        lbl_program.setText("Program");
        getContentPane().add(lbl_program, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 304, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Forte", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("Start Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BG_5.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 370));

        setSize(new java.awt.Dimension(540, 390));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JavaQuestions jq = new JavaQuestions(lbl_name.getText(), lbl_student_number.getText());
        jq.setVisible(true);
        this.getDesktopPane().add(jq);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamOpening().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_program;
    private javax.swing.JLabel lbl_student_number;
    // End of variables declaration//GEN-END:variables
}
