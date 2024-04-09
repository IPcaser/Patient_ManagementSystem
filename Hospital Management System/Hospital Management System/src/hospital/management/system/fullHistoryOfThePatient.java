/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospital.management.system;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



public class fullHistoryOfThePatient extends javax.swing.JFrame {

   
    public fullHistoryOfThePatient() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(280, 150));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/management/system/save-icon--1.png"))); // NOI18N
        jButton2.setText("Download PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/management/system/Close.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 438, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Enter Patient ID:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 28, 130, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 220, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/management/system/search.png"))); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 28, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable1ComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 92, 770, 310));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/management/system/add new patient background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       
       try
        {
            
            Connection con = Database.dbConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from patient inner join patientreport where patient.patientID = patientreport.patientID");
            jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"Connection Error!!");
        } 
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        
        
        String path="";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION)
        {
            path = j.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try {
            String pid = jTable1.getValueAt(0, 0).toString();
            PdfWriter.getInstance(doc, new FileOutputStream(path+"/PatientHistory "+pid+".pdf"));
            doc.open();
            PdfPTable tbl = new PdfPTable(14);
            
            tbl.setWidthPercentage(100f);
            tbl.setSpacingBefore(50f);
            tbl.setSpacingAfter(50f);
            
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.ITALIC ,BaseColor.RED);
            PdfPCell title = new PdfPCell(new Phrase("PATIENT HISTORY", font));
            

                String id = jTable1.getValueAt(0, 0).toString();
                String name = jTable1.getValueAt(0, 1).toString();
                String contact = jTable1.getValueAt(0, 2).toString();
                String age = jTable1.getValueAt(0, 3).toString();
                String gender = jTable1.getValueAt(0, 4).toString();
                String bloodgroup = jTable1.getValueAt(0, 5).toString();
                String address = jTable1.getValueAt(0, 6).toString();
                String anymajordisease = jTable1.getValueAt(0, 7).toString();
                //String patientid = jTable1.getValueAt(0, 8).toString();
                String symptom = jTable1.getValueAt(0, 9).toString();
                String diagnosis = jTable1.getValueAt(0, 10).toString();
                String medicine = jTable1.getValueAt(0, 11).toString();
                String wardreq = jTable1.getValueAt(0, 12).toString();
                String typeward = jTable1.getValueAt(0, 13).toString();
                
                PdfPCell id1 = new PdfPCell(new Phrase("ID: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell id2 = new PdfPCell(new Phrase(id, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell name1 = new PdfPCell(new Phrase("Name: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));               
                PdfPCell name2 = new PdfPCell(new Phrase(name, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell contact1 = new PdfPCell(new Phrase("Contact No: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell contact2 = new PdfPCell(new Phrase(contact, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell age1 = new PdfPCell(new Phrase("Age: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell age2 = new PdfPCell(new Phrase(age, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell gender1 = new PdfPCell(new Phrase("Gender: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell gender2 = new PdfPCell(new Phrase(gender, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell bloodgroup1 = new PdfPCell(new Phrase("Blood Group: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell bloodgroup2 = new PdfPCell(new Phrase(bloodgroup, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell address1 = new PdfPCell(new Phrase("Address: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell address2 = new PdfPCell(new Phrase(address, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell anymajordisease1 = new PdfPCell(new Phrase("Any major disease: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell anymajordisease2 = new PdfPCell(new Phrase(anymajordisease, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                //PdfPCell patientid1= new PdfPCell(new Phrase("PatientId: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                //PdfPCell patientId2= new PdfPCell(new Phrase(patientid, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell symptom1 = new PdfPCell(new Phrase("Symptom: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell symptom2 = new PdfPCell(new Phrase(symptom, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell diagnosis1 = new PdfPCell(new Phrase("Diagnosis: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell diagnosis2 = new PdfPCell(new Phrase(diagnosis, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell medicine1 = new PdfPCell(new Phrase("Medicine: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell medicine2 = new PdfPCell(new Phrase(medicine, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell wardreq1 = new PdfPCell(new Phrase("Ward Requirement: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell wardreq2 = new PdfPCell(new Phrase(wardreq, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                PdfPCell typeward1 = new PdfPCell(new Phrase("Ward Type: ", FontFactory.getFont(FontFactory.HELVETICA, 14)));
                PdfPCell typeward2 = new PdfPCell(new Phrase(typeward, FontFactory.getFont(FontFactory.HELVETICA, 14)));
                
                id1.setColspan(5); id1.setRowspan(8);
                id2.setColspan(10); id2.setRowspan(8);
                name1.setColspan(5); name1.setRowspan(8);
                name2.setColspan(10); name2.setRowspan(8);
                contact1.setColspan(5); contact1.setRowspan(8);
                contact2.setColspan(10); contact2.setRowspan(8);
                age1.setColspan(5); age1.setRowspan(8);
                age2.setColspan(10); age2.setRowspan(8);
                gender1.setColspan(5); gender1.setRowspan(8);
                gender2.setColspan(10); gender2.setRowspan(8);
                bloodgroup1.setColspan(5); bloodgroup1.setRowspan(8);
                bloodgroup2.setColspan(10); bloodgroup2.setRowspan(8);
                address1.setColspan(5); address1.setRowspan(8);
                address2.setColspan(10); address2.setRowspan(8);
                anymajordisease1.setColspan(5); anymajordisease1.setRowspan(8);
                anymajordisease2.setColspan(10); anymajordisease2.setRowspan(8);
                //patientid1.setColspan(5); patientid1.setRowspan(8);
                //patientId2.setColspan(10); patientId2.setRowspan(8);
                symptom1.setColspan(5); symptom1.setRowspan(8);
                symptom2.setColspan(10); symptom2.setRowspan(8);
                diagnosis1.setColspan(5); diagnosis1.setRowspan(8);
                diagnosis2.setColspan(10); diagnosis2.setRowspan(8);
                medicine1.setColspan(5); medicine1.setRowspan(8);
                medicine2.setColspan(10); medicine2.setRowspan(8);
                wardreq1.setColspan(5); wardreq1.setRowspan(8);
                wardreq2.setColspan(10); wardreq2.setRowspan(8);
                typeward1.setColspan(5); typeward1.setRowspan(8);
                typeward2.setColspan(10); typeward2.setRowspan(8);
                
                 title.setColspan(20);
                 
                tbl.addCell(title);
                tbl.addCell(id1);
                tbl.addCell(id2);
                tbl.addCell(name1);
                tbl.addCell(name2);
                tbl.addCell(contact1);
                tbl.addCell(contact2);
                tbl.addCell(age1);
                tbl.addCell(age2);
                tbl.addCell(gender1);
                tbl.addCell(gender2);
                tbl.addCell(bloodgroup1);
                tbl.addCell(bloodgroup2);
                tbl.addCell(address1);
                tbl.addCell(address2);
                tbl.addCell(anymajordisease1);
                tbl.addCell(anymajordisease2);
                //tbl.addCell(patientid1);
                //tbl.addCell(patientId2);
                tbl.addCell(symptom1);
                tbl.addCell(symptom2);
                tbl.addCell(diagnosis1);
                tbl.addCell(diagnosis2);
                tbl.addCell(medicine1);
                tbl.addCell(medicine2);
                tbl.addCell(wardreq1);
                tbl.addCell(wardreq2);
                tbl.addCell(typeward1);
                tbl.addCell(typeward2);

        doc.add(tbl);
        JOptionPane.showMessageDialog(null, "Downloaded Successfully!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(fullHistoryOfThePatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(fullHistoryOfThePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
         String id = jTextField1.getText();
        try
        {
            Connection con = Database.dbConnection();
            Statement st = con.createStatement();
            Statement st1 = con.createStatement();
            
            ResultSet rs1 = st1.executeQuery("select * from patient where patientID = '"+id+"'");
        if(rs1.next())
        {
                   ResultSet rs = st.executeQuery("select * from patient inner join patientreport where patient.patientID = patientreport.patientID AND patient.patientID = '"+id+"'");
                   jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Patient ID does not exist!!");
        }

            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable1ComponentShown
       
    }//GEN-LAST:event_jTable1ComponentShown

    
    public static void main(String args[]) {
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fullHistoryOfThePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
