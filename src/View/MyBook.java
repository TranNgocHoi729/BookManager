/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.List;  
import javax.swing.table.DefaultTableModel;
import model.Search;
import Controller.Control;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;
/**
 *
 * @author dell
 */
public class MyBook extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    private User thisUser;
    public  MyBook() {
        initComponents();
        setSize(1150, 650);
        resultTable.setModel(tableModel = new DefaultTableModel());
        String[] header = {"Book ID", "Book title", "Publisher", "Author", "Note"};
        tableModel.setColumnIdentifiers(header);
        
    }
    public  MyBook(User currentUser) {
        initComponents();
        setSize(1150, 650);
        resultTable.setModel(tableModel = new DefaultTableModel());
        String[] header = {"Book ID", "Book title", "Publisher", "Author", "Note"};
        tableModel.setColumnIdentifiers(header);
        if(currentUser != null){
            welcome.setText("Hello "+ currentUser.getDisplayName());
        }
        thisUser = currentUser;
    }
    
 
    

    void dataView(ArrayList<Search> search ) throws Exception {
        tableModel.setRowCount(0);
        for (Search s  : search) {
            tableModel.addRow(s.toDataRow());
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbOfSearch = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        keyWordForSearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        welcome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        resultTable.setBackground(new java.awt.Color(0, 0, 0));
        resultTable.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        resultTable.setForeground(new java.awt.Color(0, 204, 0));
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
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
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resultTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 166, 1128, 318);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("  Search Book");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 170, 42);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 51));
        jLabel2.setText("Search By");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 60, 102, 48);

        cbOfSearch.setFont(new java.awt.Font("Supria Sans Cond Regular Obliq", 0, 18)); // NOI18N
        cbOfSearch.setForeground(new java.awt.Color(51, 51, 255));
        cbOfSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book ID", "Book Title", "Publisher", "Author", "Note" }));
        getContentPane().add(cbOfSearch);
        cbOfSearch.setBounds(126, 60, 238, 48);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 0));
        jLabel3.setText("Enter key word");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(483, 60, 139, 47);
        getContentPane().add(keyWordForSearch);
        keyWordForSearch.setBounds(640, 62, 335, 46);

        search.setFont(new java.awt.Font("Supria Sans Cond Heavy Oblique", 0, 18)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(993, 63, 111, 44);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add new");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(31, 512, 189, 54);

        welcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        welcome.setForeground(new java.awt.Color(51, 255, 51));
        welcome.setText("welcome");
        getContentPane().add(welcome);
        welcome.setBounds(785, 512, 331, 54);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell\\Desktop\\My_main_document\\backGround\\cool-spiderman-logo-wallpaper-1.jpg")); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1130, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        
        Control C = new Control();
        String key = keyWordForSearch.getText();
        int type = cbOfSearch.getSelectedIndex();
        try {
            dataView(C.displayResult(key, type));
        } catch (Exception ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddBook add;
        try {
            add = new AddBook(thisUser);
            add.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void resultTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultTableMouseClicked
        int pos = resultTable.getSelectedRow();
        String BookID = (String) tableModel.getValueAt(pos, 0);
        System.out.println(BookID);
        String BookTitle = (String) tableModel.getValueAt(pos, 1);
        String publisher = (String) tableModel.getValueAt(pos, 2);
        String author = (String)tableModel.getValueAt(pos, 3);
        String note = (String) tableModel.getValueAt(pos, 4);
        try {
            update x = new update(this, true, BookID, BookTitle, publisher, author, note);
            x.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(MyBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_resultTableMouseClicked

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
            java.util.logging.Logger.getLogger(MyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbOfSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keyWordForSearch;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton search;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
