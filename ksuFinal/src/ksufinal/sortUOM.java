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
public class sortUOM extends javax.swing.JFrame {
    
    ResultSet rs;
    static ArrayList<String> selectedUOM = new ArrayList<String>();
    static String UOMSortStatement = "";
    
    private String location;
    
    
    
    /**
     * Creates new form sortUOM
     */
    public sortUOM(String location) {
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
        sortUOMTable = new javax.swing.JTable();
        saveUOMSortBtn = new javax.swing.JButton();
        selectAllCBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        sortUOMTable.setAutoCreateRowSorter(true);
        sortUOMTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        sortUOMTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Unit of Measure", "Select Here"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        sortUOMTable.setRowHeight(25);
        jScrollPane1.setViewportView(sortUOMTable);

        saveUOMSortBtn.setText("Save");
        saveUOMSortBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUOMSortBtnActionPerformed(evt);
            }
        });

        selectAllCBox.setText("Select All");
        selectAllCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllCBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectAllCBox)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveUOMSortBtn))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(selectAllCBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(saveUOMSortBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveUOMSortBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUOMSortBtnActionPerformed
        
        
        
        selectedUOM.clear();
        UOMSortStatement = "";

        if (selectAllCBox.isSelected()){
            if (location.equals("Transreport")){
                TransReport.UOMSortTF.setText("All");
            }
            else if (location.equals("report")){
                report.UOMSortTF.setText("All");
            }
            System.out.println("past here");
        }
        else{
            int l = sortUOMTable.getRowCount();
            for (int x = 0; x < l; x++){
                if(sortUOMTable.getValueAt(x, 1).toString().equals("true")){
                    selectedUOM.add(sortUOMTable.getValueAt(x, 0).toString());
                }
            }
            String jointArray = String.join(", ", selectedUOM);
            
            if (location.equals("TransReport")){
                TransReport.UOMSortTF.setText(jointArray);
            }
            else if (location.equals("report")){
                report.UOMSortTF.setText(jointArray);
            }
            
            ArrayList<String> strArr = new ArrayList<String>();
            
            for (String x: selectedUOM){
                strArr.add("Unit = '" + x + "'");
            }
            
            UOMSortStatement = " (" + String.join(" or ", strArr) + ") ";
            
        }

        this.setVisible(false);
        
        //        System.out.println(jointArray);
        
//        System.out.println(UOMSortStatement);
        
        if (location.equals("report")){
            report.sortFunction();
        }
        else if (location.equals("TransReport")){
            TransReport.filterFunction();
        }
        

    }//GEN-LAST:event_saveUOMSortBtnActionPerformed

    private void selectAllCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllCBoxActionPerformed
        //        DefaultTableModel t = (DefaultTableModel)sortProdTable.getModel();
        if (selectAllCBox.isSelected()){
            sortUOMTable.setRowSelectionAllowed(false);
            sortUOMTable.setEnabled(false);
            sortUOMTable.setForeground(Color.LIGHT_GRAY);
            sortUOMTable.setBackground(new Color(236, 236, 236));
        }
        else{
            sortUOMTable.setRowSelectionAllowed(true);
            sortUOMTable.setEnabled(true);
            sortUOMTable.setForeground(Color.black);
            sortUOMTable.setBackground(Color.white);
        }
    }//GEN-LAST:event_selectAllCBoxActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultTableModel t = (DefaultTableModel)sortUOMTable.getModel();
        
        
        try{
            rs = KsuFinal.con.createStatement().executeQuery("SELECT * FROM expenses.unittable;");
            while(rs.next()){
                String nm = rs.getString("Unit");
                Object [] nmArr = {nm, false};
                
                t.addRow(nmArr);
                
            }  
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(sortUOM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sortUOM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sortUOM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sortUOM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sortUOM("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveUOMSortBtn;
    private javax.swing.JCheckBox selectAllCBox;
    private javax.swing.JTable sortUOMTable;
    // End of variables declaration//GEN-END:variables
}