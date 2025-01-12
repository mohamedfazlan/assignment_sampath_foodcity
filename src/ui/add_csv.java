
package ui;

import db.database;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

/**
 *
 * @author FAZLAN
 */
public class add_csv extends javax.swing.JFrame {

    
    public add_csv() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Add ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
      try {
    JFileChooser jfilech = new JFileChooser();
    jfilech.setDialogTitle("Select a CSV file");
    int userSelected = jfilech.showOpenDialog(null);

    if (userSelected == JFileChooser.APPROVE_OPTION) {
        File filepath = jfilech.getSelectedFile();
        String file = filepath.getAbsolutePath();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Print the line read from the CSV file
                System.out.println("Line read: " + line);

                try {
                    Connection con = database.getConnection();
                    String query = "INSERT INTO products(customer_id, product_id, product_name, qty, priceperunit, date, totalprice,region) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    String[] val = line.split(",");

                    // Print the split values
                    System.out.println("Parsed values: " + Arrays.toString(val));

                    if (val.length == 9) { // Adjusted for 9 columns but skipping the first (TransactionID)
                        pst.setString(1, val[1].trim()); // CustomerID
                        pst.setString(2, val[2].trim()); // ProductID
                        pst.setString(3, val[3].trim()); // ProductName
                        pst.setInt(4, Integer.parseInt(val[4].trim())); // Quantity
                        pst.setFloat(5, Float.parseFloat(val[5].trim())); // PriceperUnit

                        // Parse the date
                        String dateString = val[6].trim(); 
                        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
                        java.util.Date parsedDate = sdf.parse(dateString);
                        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
                        pst.setDate(6, sqlDate);

                        pst.setFloat(7, Float.parseFloat(val[7].trim())); // TotalPrice
                        pst.setString(8, val[8].trim()); // Region

                        // Print the prepared statement values before execution
                        System.out.println("Prepared statement values set successfully.");

                        pst.executeUpdate();
                        System.out.println("Data inserted into database successfully.");
                    } else {
                        System.out.println("Invalid data format. Expected 9 fields, but got: " + val.length);
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // Print the stack trace for debugging
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
            JOptionPane.showMessageDialog(null, "Success!");
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "No file selected");
    }
} catch (Exception e) {
    e.printStackTrace(); // Print the stack trace for debugging
    JOptionPane.showMessageDialog(null, e.getMessage());
}


        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(add_csv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_csv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_csv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_csv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_csv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
