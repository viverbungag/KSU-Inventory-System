/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksufinal;

import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Viver
 */
public class sortBS extends javax.swing.JFrame {
    
    
    ResultSet rs;
    static ArrayList<String> selectedSupplier = new ArrayList<String>();
    static ArrayList<String> selectedBranch = new ArrayList<String>();
    static String  BSSortStatement = "";
    private String location;
    static String currentUser = "";
    
    
    /**
     * Creates new form sortBS
     */
    public sortBS(String location) {
        initComponents();
        this.location = location;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sortSupplierTable = new javax.swing.JTable();
        saveBSSortBtn = new javax.swing.JButton();
        selectAllSupplierCBox = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        sortBranchTable = new javax.swing.JTable();
        selectAllBranchCBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        sortSupplierTable.setAutoCreateRowSorter(true);
        sortSupplierTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        sortSupplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier", "Select Here"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sortSupplierTable.setRowHeight(25);
        jScrollPane1.setViewportView(sortSupplierTable);

        saveBSSortBtn.setText("Ok");
        saveBSSortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBSSortBtnActionPerformed(evt);
            }
        });

        selectAllSupplierCBox.setText("Select All Supplier");
        selectAllSupplierCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllSupplierCBoxActionPerformed(evt);
            }
        });

        sortBranchTable.setAutoCreateRowSorter(true);
        sortBranchTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        sortBranchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Branch", "Select Here"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sortBranchTable.setRowHeight(25);
        jScrollPane2.setViewportView(sortBranchTable);

        selectAllBranchCBox.setText("Select All Branch");
        selectAllBranchCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllBranchCBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectAllSupplierCBox)
                    .addComponent(saveBSSortBtn)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectAllBranchCBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(selectAllSupplierCBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(selectAllBranchCBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveBSSortBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBSSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBSSortBtnActionPerformed
        DefaultTableModel t2 = (DefaultTableModel)sortBranchTable.getModel();
        
        selectedSupplier.clear();
        selectedBranch.clear();
        
        BSSortStatement = "";
        int l = sortSupplierTable.getRowCount();
        int l2 = sortBranchTable.getRowCount();

        if (selectAllSupplierCBox.isSelected() && selectAllBranchCBox.isSelected()){
            
            if (location.equals("TransReport")){
                ViewTransactions.BSSortTF.setText("All");
            }
            else if (location.equals("report")){
                Report.BSSortTF.setText("All");
            }
        }
        else{

            for (int x = 0; x < l; x++){
                if (sortSupplierTable.getValueAt(x, 1).toString().equals("true")){
                    selectedSupplier.add(sortSupplierTable.getValueAt(x, 0).toString());
                }
            }
            
            for (int x = 0; x < l2; x++){
                if (sortBranchTable.getValueAt(x, 1).toString().equals("true")){
                    selectedBranch.add(sortBranchTable.getValueAt(x, 0).toString());
                }
            }
            
            selectedSupplier.addAll(selectedBranch);
            
            String jointArray = String.join(", ", selectedSupplier);
            
            
            if (location.equals("TransReport")){
                ViewTransactions.BSSortTF.setText(jointArray);
            }
            else if (location.equals("report")){
                Report.BSSortTF.setText(jointArray);
            }
            
            ArrayList<String> strArr = new ArrayList<String>();
            
            for (String x: selectedSupplier){
                strArr.add("SuppBranch = '" + x + "'");
            }
            
            BSSortStatement = " (" + String.join(" or ", strArr) + ") "; 
        }
//        System.out.println(BSSortStatement);

        if (location.equals("report")){
            Report.sortFunction();
        }
        else if (location.equals("TransReport")){
            ViewTransactions.filterFunction();
        }

        this.setVisible(false);

        //        System.out.println(jointArray);
    }//GEN-LAST:event_saveBSSortBtnActionPerformed

    private void selectAllSupplierCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllSupplierCBoxActionPerformed
        //        DefaultTableModel t = (DefaultTableModel)sortProdTable.getModel();
        int l = sortSupplierTable.getRowCount();
        DefaultTableModel t = (DefaultTableModel)sortSupplierTable.getModel();
        
        if (selectAllSupplierCBox.isSelected()){

            sortSupplierTable.setRowSelectionAllowed(false);
            sortSupplierTable.setEnabled(false);
            sortSupplierTable.setForeground(Color.LIGHT_GRAY);
            sortSupplierTable.setBackground(new Color(236, 236, 236));
        }
        else{
            for (int x = 0; x < l; x++){
                t.setValueAt(false , x, 1);
            }
            sortSupplierTable.setRowSelectionAllowed(true);
            sortSupplierTable.setEnabled(true);
            sortSupplierTable.setForeground(Color.black);
            sortSupplierTable.setBackground(Color.white);
        }
    }//GEN-LAST:event_selectAllSupplierCBoxActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened
    
    public void openWindowAction(){
        if (!currentUser.equals(Login.fullName)){
            
            DefaultTableModel sortSupplierTableModel = (DefaultTableModel)sortSupplierTable.getModel();
            DefaultTableModel sortBranchTableModel = (DefaultTableModel)sortBranchTable.getModel();
            sortSupplierTableModel.setRowCount(0);
            sortBranchTableModel.setRowCount(0);
            
            selectAllSupplierCBox.setSelected(true);
            sortSupplierTable.setRowSelectionAllowed(false);
            sortSupplierTable.setEnabled(false);
            sortSupplierTable.setForeground(Color.LIGHT_GRAY);
            sortSupplierTable.setBackground(new Color(236, 236, 236));
            
            selectAllBranchCBox.setSelected(true);
            sortBranchTable.setRowSelectionAllowed(false);
            sortBranchTable.setEnabled(false);
            sortBranchTable.setForeground(Color.LIGHT_GRAY);
            sortBranchTable.setBackground(new Color(236, 236, 236));
            
            try{
                rs = KsuFinal.con.createStatement().executeQuery("SELECT * FROM expenses.suppliertable;");
                ResultSet rs2 = KsuFinal.con.createStatement().executeQuery("SELECT * FROM expenses.branchtable;");
                while(rs.next()){
                    String nm = rs.getString("supplierName");
                    Object [] nmArr = {nm,true};
                    sortSupplierTableModel.addRow(nmArr);
                }

                while (rs2.next()){
                    String nm = rs2.getString("branchName");
                    Object [] nmArr = {nm,true};
                    sortBranchTableModel.addRow(nmArr);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            currentUser = Login.fullName;
        }
    }
    private void selectAllBranchCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllBranchCBoxActionPerformed
        int l = sortBranchTable.getRowCount();
        DefaultTableModel t = (DefaultTableModel)sortBranchTable.getModel();
        
        if (selectAllBranchCBox.isSelected()){
        if (selectAllBranchCBox.isSelected()){
            for (int x = 0; x < l; x++){
                t.setValueAt(true , x, 1);
            }
        }
            sortBranchTable.setRowSelectionAllowed(false);
            sortBranchTable.setEnabled(false);
            sortBranchTable.setForeground(Color.LIGHT_GRAY);
            sortBranchTable.setBackground(new Color(236, 236, 236));
        }
        else{
            sortBranchTable.setRowSelectionAllowed(true);
            sortBranchTable.setEnabled(true);
            sortBranchTable.setForeground(Color.black);
            sortBranchTable.setBackground(Color.white);
        }
    }//GEN-LAST:event_selectAllBranchCBoxActionPerformed

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
            java.util.logging.Logger.getLogger(sortBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sortBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sortBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sortBS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sortBS("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveBSSortBtn;
    private javax.swing.JCheckBox selectAllBranchCBox;
    private javax.swing.JCheckBox selectAllSupplierCBox;
    private javax.swing.JTable sortBranchTable;
    private javax.swing.JTable sortSupplierTable;
    // End of variables declaration//GEN-END:variables
}
