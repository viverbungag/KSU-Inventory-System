/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksufinal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;  
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Ricky
 */
public class adProd extends javax.swing.JFrame {
   //adProd aprd = new adProd();
    static AddProduct adPrdct = new AddProduct();
    static editProduct edprd = new editProduct();
    PreparedStatement st = null;
    PreparedStatement del = null;
    static deactivated dec = new deactivated();
    
    static ArrayList<String[]> adProdArr = new ArrayList<String[]>();
    /**
     * Creates new form adProd
     */
    public adProd() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        proddbTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SPBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        proddbTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Qty", "UOM", "SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        proddbTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proddbTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(proddbTable);

        jButton1.setText("Edit Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Deactivate Product");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("View Deactivated Products");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("From");

        jLabel2.setText("To");

        SPBtn.setText("Calculate Standard Price");
        SPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPBtnActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fromDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(toDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(SPBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2)
                        .addGap(35, 35, 35)
                        .addComponent(jButton3)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(58, 58, 58)
                        .addComponent(SPBtn)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(proddbTable.getSelectedRow() >= 0){ 
            edprd.setVisible(true);
            edprd.setDefaultCloseOperation(edprd.HIDE_ON_CLOSE);
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select a row");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
//        DefaultTableModel t = (DefaultTableModel)proddbTable.getModel();
//        t.setRowCount(0);
//        
//        try{
//        Statement prodstate = KsuFinal.con.createStatement();
//        ResultSet prodres = prodstate.executeQuery("SELECT * FROM expenses.producttable WHERE Active = 'TRUE'");
//        
//        while(prodres.next()){
//            System.out.println("a");
//            String id = prodres.getString("productID");
//            String name = prodres.getString("productName");
//            String quan = String.valueOf(prodres.getInt("productQuantity"));
//            String unit = prodres.getString("Unit");
//            String stndrd = prodres.getString("standardPrice");
//            String fromD = prodres.getString("dateFrom");
//            String toD = prodres.getString("dateTo");
//            
//            
//            
//            String[] item = {name, quan, unit, stndrd};
//            String[] item2 = {id, name, quan, unit, stndrd, fromD, toD};
//            
//            
//            t.addRow(item);
//            
//            adProdArr.add(item2);
//            
//            
//         
//        }
//       }
//       catch(Exception e){
//           System.out.println(e);
//       }
    }//GEN-LAST:event_formWindowOpened
    public static void editActiveTable(){
        try{
            Statement prodstate = KsuFinal.con.createStatement();
            ResultSet prodres = prodstate.executeQuery("SELECT * FROM producttable WHERE Active = 'TRUE'");
            DefaultTableModel t = (DefaultTableModel)proddbTable.getModel();
            t.setRowCount(0);
            while(prodres.next()){


                String name = prodres.getString("productName");
                String quan = String.valueOf(prodres.getInt("productQuantity"));
                String unit = prodres.getString("Unit");
                String stndrd = prodres.getString("standardPrice");
                String[] item = {name, quan, unit, stndrd};
                t.addRow(item);





            }
       }
       catch(Exception e){
           System.out.println(e);
       }   
        
        
        
    }
    private void proddbTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proddbTableMouseClicked
        int i = proddbTable.getSelectedRow();
        try{
            Statement prodstate = KsuFinal.con.createStatement();
            ResultSet prodres = prodstate.executeQuery("SELECT * FROM producttable");
        
        while(prodres.next()){
            String minquan = String.valueOf(prodres.getInt("prodMinq"));
            editProduct.productName.setText(proddbTable.getValueAt(i, 0).toString());
            editProduct.productUnit.setText(proddbTable.getValueAt(i, 2).toString());
            editProduct.minQ.setText(minquan);
       }
       }
       catch(Exception e){
           System.out.println(e);
       }
       SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            fromDateChooser.setDate(dFormat.parse(adProdArr.get(i)[5]));
            toDateChooser.setDate(dFormat.parse(adProdArr.get(i)[6]));
        }
        catch(Exception e){
            System.out.println(e);
        }
       
       
       
    }//GEN-LAST:event_proddbTableMouseClicked
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int yesNO = 0;
        if (proddbTable.getSelectedRow() >= 0){
            yesNO = JOptionPane.showConfirmDialog (null, "Do you really want to deactivate these products?","Warning",JOptionPane.YES_NO_OPTION);
            if (yesNO == JOptionPane.YES_OPTION){

                int[] allSelected = proddbTable.getSelectedRows();
                for (int x = allSelected.length-1; x > -1; x--){
                    int i = allSelected[x];
                    int id = Integer.parseInt(adProdArr.get(i)[0]);


                    try{
                        st = KsuFinal.con.prepareStatement("UPDATE producttable SET Active = 'FALSE' WHERE productID = " + id);

                        st.executeUpdate();

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                    deactivated.deacArr.add(adProdArr.get(i));
                    adProdArr.remove(i);
                    editActiveTable();
                    deactivated.editDeactiveTable();
                }
            }
        }else{
            JOptionPane.showMessageDialog(this,"Please select a row");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    public static void printThis(){
        for (String[]x : adProdArr){
            System.out.println(Arrays.deepToString(x));
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dec.setVisible(true);
        dec.setDefaultCloseOperation(dec.HIDE_ON_CLOSE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SPBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPBtnActionPerformed
        
        DefaultTableModel tModel = (DefaultTableModel)proddbTable.getModel();
        int[] selectedRows = proddbTable.getSelectedRows();
        for (int x = 0; x < selectedRows.length; x++){
            try{
                SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fdate = dFormat.format(fromDateChooser.getDate()); 
                String tdate = dFormat.format(toDateChooser.getDate());
                int totQuant = 0;
                float totPrice = 0;
                int idx = selectedRows[x];
                String prodId = adProdArr.get(idx)[0];
                

                    

                String statement = "SELECT * FROM expenses.producttrans WHERE prodID = " + prodId + " AND Action = 'deposit'";

                ResultSet prodres = KsuFinal.con.createStatement().executeQuery(statement);

                while (prodres.next()){

                    String currD = prodres.getString("Date");

                    try{
                        Date currdate = dFormat.parse(currD);
                        Date fromDate = dFormat.parse(fdate);
                        Date toDate = dFormat.parse(tdate);

                        if (((currdate.after(fromDate) && currdate.before(toDate)) || currdate.equals(fromDate) || currdate.equals(toDate)) && (fromDate.before(toDate) || fromDate.equals(toDate))){
    //                        System.out.println("In between");
                            int prodQuan = prodres.getInt("Quantity");
                            float prodPrice = prodres.getFloat("Price");

                            totQuant += prodQuan;
                            totPrice += (prodPrice * prodQuan);
                        }
                    }catch(Exception ex){

                    }        
                }
                if (totQuant > 0){
                    double sp = Math.round((totPrice / totQuant) * 100.0) / 100.0;

                    try{

                        st = KsuFinal.con.prepareStatement("UPDATE expenses.producttable SET standardPrice = " + sp + " WHERE productID = " + prodId);
                        st.executeUpdate();
                        st = KsuFinal.con.prepareStatement("UPDATE expenses.producttable SET dateFrom = '" + fdate + "' WHERE productID = " + prodId);
                        st.executeUpdate();
                        st = KsuFinal.con.prepareStatement("UPDATE expenses.producttable SET dateTo = '" + tdate + "' WHERE productID = " + prodId);
                        st.executeUpdate();
                        
                        tModel.setValueAt(sp, idx, 3);

                        adProdArr.get(idx)[4] = String.valueOf(sp);
                        adProdArr.get(idx)[5] = fdate;
                        adProdArr.get(idx)[6] = tdate;
                    
                    
                    
                    
                    }
                
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"A product has 0 quantity so the standard price would be retained");
                }






            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        
        
    }//GEN-LAST:event_SPBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        login.MenuClass.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
 
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       DefaultTableModel t = (DefaultTableModel)proddbTable.getModel();
        t.setRowCount(0);
        
        try{
        Statement prodstate = KsuFinal.con.createStatement();
        ResultSet prodres = prodstate.executeQuery("SELECT * FROM expenses.producttable WHERE Active = 'TRUE'");
        
        while(prodres.next()){
            System.out.println("a");
            String id = prodres.getString("productID");
            String name = prodres.getString("productName");
            String quan = String.valueOf(prodres.getInt("productQuantity"));
            String unit = prodres.getString("Unit");
            String stndrd = prodres.getString("standardPrice");
            String fromD = prodres.getString("dateFrom");
            String toD = prodres.getString("dateTo");
            
            
            
            String[] item = {name, quan, unit, stndrd};
            String[] item2 = {id, name, quan, unit, stndrd, fromD, toD};
            
            
            t.addRow(item);
            
            adProdArr.add(item2);
            
            
         
        }
       }
       catch(Exception e){
           System.out.println(e);
       }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(adProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adProd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SPBtn;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable proddbTable;
    private com.toedter.calendar.JDateChooser toDateChooser;
    // End of variables declaration//GEN-END:variables
}
