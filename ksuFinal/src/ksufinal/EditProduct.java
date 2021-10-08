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
public class EditProduct extends javax.swing.JFrame {
    PreparedStatement st = null;
    PreparedStatement del = null;
    static DeactivatedProducts dec = new DeactivatedProducts();
    
    static ArrayList<String[]> adProdArr = new ArrayList<String[]>();
    /**
     * Creates new form adProd
     */
    public EditProduct() {
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
        instructionDialogue = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        proddbTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        SPBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        editDataBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        productNameTF = new javax.swing.JTextField();
        minimumTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        categoryCB = new javax.swing.JComboBox();
        uomCB = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        questionMarkIcon = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        instructionDialogue.setBackground(new java.awt.Color(240, 240, 240));
        instructionDialogue.setMinimumSize(new java.awt.Dimension(292, 198));
        instructionDialogue.setResizable(false);
        instructionDialogue.setType(java.awt.Window.Type.POPUP);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("INSTRUCTIONS");

        javax.swing.GroupLayout instructionDialogueLayout = new javax.swing.GroupLayout(instructionDialogue.getContentPane());
        instructionDialogue.getContentPane().setLayout(instructionDialogueLayout);
        instructionDialogueLayout.setHorizontalGroup(
            instructionDialogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructionDialogueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        instructionDialogueLayout.setVerticalGroup(
            instructionDialogueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(instructionDialogueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
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
                "Product ID", "Product Name", "Category", "Unit of Measure", "Quantity", "Minimum Quantity", "Standard Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, false, true, true
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Product Standard Price", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        SPBtn.setText("Calculate Standard Price");
        SPBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("To");

        jLabel1.setText("From");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SPBtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(toDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(SPBtn)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Product Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        editDataBtn.setText("Save");
        editDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDataBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Product Name");

        jLabel4.setText("Unit of Measure");

        jLabel5.setText("Minimum Quantity");

        minimumTF.setMaximumSize(new java.awt.Dimension(6, 20));

        jLabel8.setText("Category");

        uomCB.setMaximumSize(new java.awt.Dimension(28, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(productNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(uomCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryCB, 0, 110, Short.MAX_VALUE)
                            .addComponent(minimumTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(editDataBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(productNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(uomCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(minimumTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(editDataBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Deactivated Product", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(54, 54, 54))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(20, 20, 20))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("EDIT PRODUCT MENU");

        questionMarkIcon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        questionMarkIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ksufinal/QuestionMark.png"))); // NOI18N
        questionMarkIcon.setMaximumSize(new java.awt.Dimension(880, 800));
        questionMarkIcon.setMinimumSize(new java.awt.Dimension(880, 800));
        questionMarkIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                questionMarkIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                questionMarkIconMouseExited(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(questionMarkIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(questionMarkIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDataBtnActionPerformed

        if(proddbTable.getSelectedRowCount() > 0){ 
            try{
            
                int i = proddbTable.getSelectedRow();
                String nm = productNameTF.getText();
                String id = proddbTable.getValueAt(i, 0).toString();
                
                ResultSet rs = KsuFinal.con.createStatement().executeQuery("SELECT * from producttable WHERE productName = '" + nm + "'");
                
                if (productNameTF.getText().length() > 0 && minimumTF.getText().length() > 0 && uomCB.getSelectedItem().toString().length() > 0 && categoryCB.getSelectedItem().toString().length() > 0){
                    if(rs.next() && (!productNameTF.getText().equals(proddbTable.getValueAt(i, 1)))){ 
                        JOptionPane.showMessageDialog(this,"Product Name already exists", "Error", JOptionPane.ERROR_MESSAGE);

                    }else{
                        String query = "UPDATE producttable SET productName = ?, Unit = ?, prodMinq = ?, Sub = ? WHERE (productID = " + id + ")";
                        st = KsuFinal.con.prepareStatement(query);
                        st.setString(1, nm);
                        st.setString(2, uomCB.getSelectedItem().toString());
                        st.setString(3, minimumTF.getText());
                        st.setString(4, categoryCB.getSelectedItem().toString());
                        st.executeUpdate();
                        editActiveTable();

                        productNameTF.setText("");
                        minimumTF.setText("");
                        uomCB.setSelectedItem("");
                        categoryCB.setSelectedItem("");
                        JOptionPane.showMessageDialog(this,"Successfully edited the Product");
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"There are missing inputs", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editDataBtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        instructionDialogue.setLocationRelativeTo(this);
    }//GEN-LAST:event_formWindowOpened
    public static void editActiveTable(){
        adProdArr.clear();
        try{
            Statement prodstate = KsuFinal.con.createStatement();
            ResultSet prodRs = prodstate.executeQuery("SELECT * FROM producttable WHERE Active = 'TRUE'");
            DefaultTableModel t = (DefaultTableModel)proddbTable.getModel();
            t.setRowCount(0);
            while(prodRs.next()){
                String id = prodRs.getString("productID");
                String name = prodRs.getString("productName");
                String quan = String.valueOf(prodRs.getInt("productQuantity"));
                String unit = prodRs.getString("Unit");
                String cat = prodRs.getString("Sub");
                String min = prodRs.getString("prodMinq");
                String stndrd = prodRs.getString("standardPrice");
                String fromD = prodRs.getString("dateFrom");
                String toD = prodRs.getString("dateTo");
                String[] item = {id, name, cat, unit, quan, min, stndrd};
                String[] item2 = {id, name, quan, unit, stndrd, fromD, toD};
                t.addRow(item);
                adProdArr.add(item2);
            }
       }
       catch(Exception e){
           System.out.println(e);
       }   
        
        
        
    }
    private void proddbTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proddbTableMouseClicked
        int i = proddbTable.getSelectedRow();
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        productNameTF.setText(proddbTable.getValueAt(i, 1).toString());
        categoryCB.setSelectedItem(proddbTable.getValueAt(i, 2));
        uomCB.setSelectedItem(proddbTable.getValueAt(i, 3));
        minimumTF.setText(proddbTable.getValueAt(i, 5).toString());
        
        try{
            if (adProdArr.get(i)[5].equals("0")){
                fromDateChooser.setDate(null);
                toDateChooser.setDate(null);
            }else{
                fromDateChooser.setDate(dFormat.parse(adProdArr.get(i)[5]));
                toDateChooser.setDate(dFormat.parse(adProdArr.get(i)[6]));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
       
       
       
    }//GEN-LAST:event_proddbTableMouseClicked
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int yesNO = 0;
        if (proddbTable.getSelectedRowCount() > 0){
            yesNO = JOptionPane.showConfirmDialog (null, "Do you really want to deactivate these products?","Warning",JOptionPane.YES_NO_OPTION);
            if (yesNO == JOptionPane.YES_OPTION){

                int[] allSelected = proddbTable.getSelectedRows();
                for (int i : allSelected){
                    
                    int id = Integer.parseInt(proddbTable.getValueAt(i, 0).toString());


                    try{
                        st = KsuFinal.con.prepareStatement("UPDATE producttable SET Active = 'FALSE' WHERE productID = " + id);

                        st.executeUpdate();

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                }
                editActiveTable();
                DeactivatedProducts.editDeactiveTable();
            }
        }else{
            JOptionPane.showMessageDialog(this,"Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
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
        int checkTransaction = 0;
        if (proddbTable.getSelectedRowCount() > 0){
            if (fromDateChooser.getDate() != null && toDateChooser.getDate() != null){
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

    //                            tModel.setValueAt(sp, idx, 3);

                                adProdArr.get(idx)[4] = String.valueOf(sp);
                                adProdArr.get(idx)[5] = fdate;
                                adProdArr.get(idx)[6] = tdate;    
                                editActiveTable();
                            }

                            catch(Exception e){
                                System.out.println(e);
                            }
                        }
                        else{
    //                        JOptionPane.showMessageDialog(this,String.format("%s has 0 quantity so the standard price would be retained", proddbTable.getValueAt(idx, 1).toString()));
                        }
                        checkTransaction += totQuant;              

                    }catch(Exception ex){
                        System.out.println(ex);
                    }
                }

                if (checkTransaction == 0){
                    JOptionPane.showMessageDialog(this,"No Transaction for the specified period");
                }
            }else{
                JOptionPane.showMessageDialog(this,"Please fill in the missing inputs", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(this,"Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SPBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Login.MenuClass.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
 
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated

    private void questionMarkIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionMarkIconMouseEntered
        instructionDialogue.setVisible(true);
    }//GEN-LAST:event_questionMarkIconMouseEntered

    private void questionMarkIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionMarkIconMouseExited
        // TODO add your handling code here:
        instructionDialogue.setVisible(false);
    }//GEN-LAST:event_questionMarkIconMouseExited
    public void openWindowAction(){
        DefaultTableModel t = (DefaultTableModel)proddbTable.getModel();
        t.setRowCount(0);
        
        adProdArr.clear();
        uomCB.removeAllItems();
        categoryCB.removeAllItems();
        uomCB.addItem("");
        categoryCB.addItem("");
        
        try{
//            Statement state = KsuFinal.con.createStatement();
            ResultSet prodRs = KsuFinal.con.createStatement().executeQuery("SELECT * FROM expenses.producttable WHERE Active = 'TRUE'");
            ResultSet unitRs = KsuFinal.con.createStatement().executeQuery("SELECT Unit FROM unittable");
            ResultSet catRs = KsuFinal.con.createStatement().executeQuery("SELECT categoryName FROM categorytable");


            while(prodRs.next()){
                String id = prodRs.getString("productID");
                String name = prodRs.getString("productName");
                String quan = String.valueOf(prodRs.getInt("productQuantity"));
                String unit = prodRs.getString("Unit");
                String cat = prodRs.getString("Sub");
                String min = prodRs.getString("prodMinq");
                String stndrd = String.format("%.2f", prodRs.getFloat("standardPrice"));
                String fromD = prodRs.getString("dateFrom");
                String toD = prodRs.getString("dateTo");
                String[] item = {id, name, cat, unit, quan, min, stndrd};
                String[] item2 = {id, name, quan, unit, stndrd, fromD, toD};
                t.addRow(item);
                adProdArr.add(item2);
            }
            
            while (unitRs.next()){
                String ut = unitRs.getString("Unit");
                uomCB.addItem(ut);
            }
            
            while (catRs.next()){
                String ct = catRs.getString("categoryName");
                categoryCB.addItem(ct);
            }
            
            
            uomCB.setSelectedItem("");
            categoryCB.setSelectedItem("");
            
        }
        catch(Exception e){
            System.out.println(e);
        } 
    }
    
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
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SPBtn;
    private javax.swing.JComboBox categoryCB;
    private javax.swing.JButton editDataBtn;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JDialog instructionDialogue;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField minimumTF;
    public static javax.swing.JTable proddbTable;
    private javax.swing.JTextField productNameTF;
    private javax.swing.JLabel questionMarkIcon;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JComboBox uomCB;
    // End of variables declaration//GEN-END:variables
}
