package ui;

import com.toedter.calendar.JDateChooser;
import db.database;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import oop_codes.add_product;
import oop_codes.t_cal;
import oop_codes.t_cal2;
import static org.omg.CORBA.AnySeqHelper.insert;

public class add_product_p extends javax.swing.JFrame {

    public add_product_p() {
        initComponents();
        showProducts();

    }

    public String getTxtPriceText() {
        return txtprice.getText();  // Return the text inside the txtprice field
    }

    Connection con;
    PreparedStatement insert;

    public ArrayList<add_product> productList() {
        ArrayList<add_product> productList = new ArrayList<>();
        try {
            Connection con = database.getConnection();
            Statement st = con.createStatement();
            String query = "select customer_id, product_id, product_name,qty,priceperunit,date,totalprice,region from products";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                add_product product = new add_product(
                        rs.getInt("customer_id"),
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("qty"),
                        rs.getFloat("priceperunit"),
                        rs.getDate("date"),
                        rs.getFloat("totalPrice"),
                        rs.getString("region")
                );
                productList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return productList;
    }

    // Method to display products in a JTable
    public void showProducts() {
        ArrayList<add_product> list = productList();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        Object[] row = new Object[8];
        for (add_product product : list) {
            row[0] = product.getCustomerID();
            row[1] = product.getProductID();
            row[2] = product.getProductname();
            row[3] = product.getQty();
            row[4] = product.getUnitprice();
            row[5] = product.getDate();
            row[6] = product.getTotalprice();
            row[7] = product.getRegion();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtcid = new javax.swing.JTextField();
        txtpid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
        txtqty = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpriceunit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        txtregion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Product");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblProducts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "customer_id", "product_id", "product_name", "qty", "price_perunit", "date", "totalprice", "region"
            }
        ));
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducts);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Customer Id");

        txtpid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpidKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Product Name");

        txtqty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Quantity");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("priceperunit");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Region");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Product ID");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Total");

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sampath Foodcity");

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Add Product");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(257, 257, 257))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(16, 16, 16))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Sampath Foodcity");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back_icon.png"))); // NOI18N
        jButton6.setText("  Dashboard");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Best Selling Product");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Product Performance");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Customer Behaviour");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Branch Performance");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("Sales");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel11)
                .addGap(64, 64, 64)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpriceunit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtregion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtpriceunit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel6))
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtregion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //insert btn coding
        // Get inputs from text fields
        String customerid = txtcid.getText();
        String productid = txtpid.getText();
        String productname = txtpname.getText();
        String unitprice = txtpriceunit.getText();
        String region = txtregion.getText();
        String qty = txtqty.getValue().toString();
        java.util.Date utilDate = (java.util.Date) date1.getDate();  // Get selected date from date picker

        // Call the insert_product method
        String result = insert_product(customerid, productid, productname, unitprice, region, qty, utilDate);

        // Handle the result (you can show a success message, clear the fields, etc.)
        JOptionPane.showMessageDialog(null, result);

        if (result.equals("Product Successfully Added")) {
            // Refresh the table and clear the fields
            DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
            model.setRowCount(0);
            showProducts();  // Call the method to show updated products

            // Clear the form fields
            txtcid.setText("");
            txtpid.setText("");
            txtpname.setText("");
            date1.setDate(null);
            txtqty.setValue(0);
            txtregion.setText("");
            txtprice.setText("");
            txtpriceunit.setText("");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // delete
        try {
            // Get the selected row
            int selectedRow = tblProducts.getSelectedRow(); // Replace 'tblProducts' with your JTable variable name
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                return;
            }

            // Get the primary key or unique identifier (e.g., customer_id or product_id)
            String customerID = tblProducts.getValueAt(selectedRow, 0).toString(); // Column 0 as example
            String productID = tblProducts.getValueAt(selectedRow, 1).toString(); // Column 1 as example

            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            // Delete from database
            String query = "DELETE FROM products WHERE customer_id = ? AND product_id = ?"; // Update table and column names
            Connection con = database.getConnection(); // Ensure this method works correctly in your database class
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, customerID);
            pst.setString(2, productID);
            pst.executeUpdate();

            // Remove row from JTable
            DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
            model.removeRow(selectedRow);

            // Success message
            JOptionPane.showMessageDialog(null, "Record deleted successfully!");

            // Clear the form fields
            txtcid.setText("");
            txtpid.setText("");
            txtpname.setText("");
            txtqty.setValue(0);
            txtpriceunit.setText("");
            txtregion.setText("");
            txtprice.setText("");
            date1.setDate(null);

            // Close connections
            pst.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //update code 
        try {
            // Get inputs from text fields
            String customerid = txtcid.getText();
            String productid = txtpid.getText();
            String productname = txtpname.getText();
            String unitprice = txtpriceunit.getText();
            String region = txtregion.getText();
            String qty = txtqty.getValue().toString();

            // Convert qty and unit price to numbers
            int quantity = Integer.parseInt(qty);
            float unitPrice = Float.parseFloat(unitprice);

            // Calculate total price
            t_cal calculator = new t_cal2();  

            // Use polymorphism to calculate total price by calling the overridden method in t_cal2
            double totalPrice = calculator.calculateTotal(quantity, unitPrice);


            txtprice.setText(String.format("%.2f", totalPrice));
            // Validate and convert date
            java.util.Date utilDate = date1.getDate();
            if (utilDate == null) {
                JOptionPane.showMessageDialog(null, "Please select a valid date.");
                return;
            }
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Establish connection to the database
            Connection con = database.getConnection();
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
                return;
            }

            // Prepare SQL query
            String query = "UPDATE products SET product_id=?, product_name=?, qty=?, priceperunit=?, date=?, totalprice=?, region=? WHERE customer_id=?";
            PreparedStatement pst = con.prepareStatement(query);

            // Set values
            pst.setInt(1, Integer.parseInt(productid));
            pst.setString(2, productname);
            pst.setInt(3, quantity);
            pst.setFloat(4, unitPrice);
            pst.setDate(5, sqlDate);
            pst.setFloat(6, (float)totalPrice);
            pst.setString(7, region);
            pst.setInt(8, Integer.parseInt(customerid));

            // Execute update
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Successfully Updated");

            // Refresh the table
            DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
            model.setRowCount(0);
            showProducts();

            // Clear the form fields
            txtcid.setText("");
            txtpid.setText("");
            txtpname.setText("");
            txtqty.setValue(0);
            txtpriceunit.setText("");
            txtregion.setText("");
            txtprice.setText("");
            date1.setDate(null);

            // Close resources
            pst.close();
            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred while updating the product. Please try again.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        // table row clicked
        // Get the table model and selected row
        DefaultTableModel df = (DefaultTableModel) tblProducts.getModel();
        int selectedIndex = tblProducts.getSelectedRow();

        // Check if a valid row is selected
        if (selectedIndex != -1) {
            // Set the values in the text fields from the selected row
            txtcid.setText(df.getValueAt(selectedIndex, 0).toString()); // Customer ID
            txtpid.setText(df.getValueAt(selectedIndex, 1).toString()); // Product ID
            txtpname.setText(df.getValueAt(selectedIndex, 2).toString()); // Product Name
            txtqty.setValue(df.getValueAt(selectedIndex, 3)); // Quantity (assuming it's an integer value)
            txtpriceunit.setText(df.getValueAt(selectedIndex, 4).toString()); // Price per unit

            // Assuming the date is stored in column 6 as a java.sql.Date or similar
            Object dateObj = df.getValueAt(selectedIndex, 5);
            if (dateObj != null && dateObj instanceof java.sql.Date) {
                java.sql.Date date = (java.sql.Date) dateObj;
                date1.setDate(new java.util.Date(date.getTime())); // Set the date on the date picker
            }
            txtprice.setText(df.getValueAt(selectedIndex, 6).toString()); // Total Price
            // Assuming column 7 is for Region
            txtregion.setText(df.getValueAt(selectedIndex, 7).toString()); // Region

            // Assuming column 8 is for Total Price
        }


    }//GEN-LAST:event_tblProductsMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtcid.setText("");
        txtpid.setText("");
        txtpname.setText("");
        date1.setDate(null);
        txtqty.setValue(0);  // Reset to default
        txtregion.setText("");
        txtprice.setText("");  // Clear the total price field
        txtpriceunit.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtpidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpidKeyPressed

        //key pressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                Connection con = database.getConnection();
                String productcode = txtpid.getText();
                insert = con.prepareStatement("select * from products where product_id=?");
                insert.setString(1, productcode);
                ResultSet rs = insert.executeQuery();

                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "Book not found");
                } else {
                    String pname = rs.getString("product_name");
                    txtpname.setText(pname.trim());

                    String price = rs.getString("priceperunit");
                    txtpriceunit.setText(price.trim());

                }
            } catch (SQLException ex) {
                Logger.getLogger(add_product_p.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_txtpidKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // back to dashbaord code
        admin_dashboard ad = new admin_dashboard();
        this.dispose();
        ad.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        best_selling_product bsp = new best_selling_product();
        this.dispose();
        bsp.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        product_performance pp = new product_performance();
        this.dispose();
        pp.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        customer_beharivor cb = new customer_beharivor();
        this.dispose();
        cb.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        brach_performance bp = new brach_performance();
        this.dispose();
        bp.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        sales objsales = new sales();
        this.dispose();
        objsales.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    public String insert_product(String customerid, String productid, String productname, String unitprice, String region, String qty, java.util.Date utilDate) {
        try {
            // Validate for empty fields
            if (customerid.equals("") || productid.equals("") || productname.equals("") || unitprice.equals("") || region.equals("") || qty.equals("")) {
                return "Please fill in all required fields";  // Return error message if any field is empty
            }

            // Convert qty and unit price to numbers
            int quantity = Integer.parseInt(qty);
            float unitPrice = Float.parseFloat(unitprice);

            // Create a reference of the superclass t_cal to hold an object of subclass t_cal2
            t_cal calculator = new t_cal2();  

            // Use polymorphism to calculate total price by calling the overridden method in t_cal2
            double totalPrice = calculator.calculateTotal(quantity, unitPrice);

            // Format total price
            txtprice.setText(String.format("%.2f", totalPrice));

            // Convert date to SQL Date format
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            // Establish connection to the database
            Connection con = database.getConnection();

            // Prepare SQL query for inserting product data
            String query = "INSERT INTO products(customer_id, product_id, product_name, qty, priceperunit, date, totalprice, region) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            // Set values in PreparedStatement
            pst.setInt(1, Integer.parseInt(customerid));
            pst.setInt(2, Integer.parseInt(productid));
            pst.setString(3, productname);
            pst.setInt(4, Integer.parseInt(qty));
            pst.setFloat(5, Float.parseFloat(unitprice));
            pst.setDate(6, sqlDate);
            pst.setFloat(7, (float) totalPrice);
            pst.setString(8, region);

            // Execute update and handle SQL exceptions
            try {
                pst.executeUpdate();
                return "Product Successfully Added";  // Return success message
            } catch (SQLException ex) {
                return "Error: " + ex.getMessage();  // Return SQL error message
            }

        } catch (Exception e) {
            return e.getMessage();  // Return any other exception error message
        }
    }

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
            java.util.logging.Logger.getLogger(add_product_p.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_product_p.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_product_p.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_product_p.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_product_p().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtcid;
    private javax.swing.JTextField txtpid;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtpriceunit;
    private javax.swing.JSpinner txtqty;
    private javax.swing.JTextField txtregion;
    // End of variables declaration//GEN-END:variables
}
