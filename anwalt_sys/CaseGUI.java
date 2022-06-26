/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.anwalt_sys;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Dell
 */
public class CaseGUI extends javax.swing.JFrame {
    DefaultTableModel model;
    DefaultTableModel modelclient;
    DbHelper helper = new DbHelper();
    Connection connection= null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    int column, i, id, DeleteItem;
    public void date1(){
       
    String txtdate;
    txtdate = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH).format(new Date());
    TxtDatum.setText(txtdate);
    }

    /**
     * Creates new form CaseGUI
     */
    public CaseGUI() {
        initComponents();
        date1();
       
    }
    int userId;
    CaseGUI(int userId){
        initComponents();
        this.userId= userId;
        
        try {
            updateDB();
        } catch (SQLException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            updateDbClient();
        } catch (SQLException ex) {
            Logger.getLogger(CaseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void reset(){
            TxtDescription.setText("");
            TxtCategory.setText("");
            TxtDatum.setText("");
            TxtNameDefendant.setText("");
            TxtLastNameDefendant.setText("");
            TxtNamePlaintiff.setText("");
            TxtLastNamePlaintiff.setText("");
            Txtclientstatus.setText("");
            TxtHistoricalData.setText("");
            TxtNameLawyer.setText("");
            TxtLastNameLawyer.setText("");
            TxtUserId.setText("");
            TxtClientId.setText("");
    }
    public void updateDB() throws SQLException{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anwalt_sys", "root", "12345");
            pst = connection.prepareStatement("select* from cases");
            rs = pst.executeQuery();
            ResultSetMetaData rsmd= rs.getMetaData();
            column= rsmd.getColumnCount();
            model = (DefaultTableModel) TblCase.getModel();
            model.setRowCount(0);
            while(rs.next()){
            Vector columnData= new Vector();
                for(i=1; i<=column;i++){
                    columnData.add(rs.getInt("caseId"));
                    columnData.add(rs.getString("description"));
                    columnData.add(rs.getString("category"));
                    columnData.add(rs.getString("datum"));
                    columnData.add(rs.getString("nameDefendant"));
                    columnData.add(rs.getString("lastnameDefendant"));
                    columnData.add(rs.getString("namePlaintiff"));
                    columnData.add(rs.getString("lastnamePlaintiff"));
                    columnData.add(rs.getString("clientstatus"));
                    columnData.add(rs.getString("historicalData"));
                    columnData.add(rs.getString("nameLawyer"));
                    columnData.add(rs.getString("lastnameLawyer"));
                    columnData.add(rs.getInt("userId"));
                    columnData.add(rs.getInt("clientId"));

                }
                model.addRow(columnData);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
           
             try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anwalt_sys", "root", "12345");
            String query = "select name, lastName from user where userId = " + userId;
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()){
            String name = rs.getString("name");
            String lastName = rs.getString("lastName");
            TxtNameLawyer.setText(name);
            TxtLastNameLawyer.setText(lastName);
            String s = String.valueOf(userId);
            TxtUserId.setText(s);
            }
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame,ex);
            Logger.getLogger(CaseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
           

        
}
        public void updateDbClient() throws SQLException{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/anwalt_sys", "root", "12345");
            pst = connection.prepareStatement("select clientId, name, lastName from client");
            rs = pst.executeQuery();
            ResultSetMetaData rsmd= rs.getMetaData();
            column= rsmd.getColumnCount();
            modelclient = (DefaultTableModel) TblClient.getModel();
            modelclient.setRowCount(0);
            while(rs.next()){
            Vector columnData= new Vector();
                for(i=1; i<=column;i++){
                    columnData.add(rs.getInt("clientId"));
                    columnData.add(rs.getString("name"));
                    columnData.add(rs.getString("lastName"));
                    

                }
                modelclient.addRow(columnData);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TblCase = new javax.swing.JTable();
        TxtDatum = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtSearch = new javax.swing.JTextField();
        BtnAdd = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnUpdate = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        BtnExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtDescription = new javax.swing.JTextField();
        TxtNameDefendant = new javax.swing.JTextField();
        TxtNamePlaintiff = new javax.swing.JTextField();
        TxtCategory = new javax.swing.JTextField();
        TxtNameLawyer = new javax.swing.JTextField();
        TxtUserId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtHistoricalData = new javax.swing.JTextArea();
        TxtClientId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtLastNameLawyer = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtLastNameDefendant = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtLastNamePlaintiff = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        Txtclientstatus = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblClient = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TblCase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Beschreibung", "Kategorie", "Datum", "Vornamen des Angeklagten", "Nachnamen des Angeklagten", "Vorname des Klägers", "Nachname des Klägers", "Klientstatus", "Historische Daten", "Vorname des Anwalts", "Nachname des Anwalts", "userId", "klientId"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblCase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblCaseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblCase);

        TxtDatum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        TxtDatum.setText("YYYY-MM-DD");

        jLabel1.setText("Suchbegriff :");

        TxtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtSearchKeyReleased(evt);
            }
        });

        BtnAdd.setText("Hinzufügen");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnDelete.setText("Löschen");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnUpdate.setText("Aktualisieren");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        BtnReset.setText("Zurücksetzen");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        BtnExit.setText("Exit");
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        jLabel3.setText("Vornamen des Angeklagten:");

        jLabel4.setText("Vorname des Klägers:");

        jLabel5.setText("Kategorie:");

        jLabel6.setText("Historische Daten:");

        jLabel7.setText(" Vorname des Anwalts:");

        jLabel8.setText("Datum:");

        jLabel9.setText("Benutzer Id:");

        TxtUserId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUserIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Beschreibung:");

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kriminalfall", "Zivilverfahren" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        TxtHistoricalData.setColumns(20);
        TxtHistoricalData.setRows(5);
        jScrollPane2.setViewportView(TxtHistoricalData);

        TxtClientId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtClientIdActionPerformed(evt);
            }
        });

        jLabel11.setText("Klient Id:");

        jLabel12.setText(" Nachname des Anwalts:");

        jLabel13.setText("Nachnamen des Angeklagten:");

        jLabel14.setText("Nachname des Klägers:");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 204, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Fall-Verwaltungsfenster");

        jComboBox2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Angeklagten", "Klager" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Klientstatus:");

        TblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Klient Id", "Klient Name", "Klient Nachname"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblClientMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TblClient);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNameDefendant))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtDescription)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtCategory)
                                    .addComponent(TxtDatum))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNamePlaintiff))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtLastNameDefendant))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtLastNamePlaintiff))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtClientId))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtUserId))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtLastNameLawyer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNameLawyer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Txtclientstatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtSearch))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(BtnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnExit))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(566, 566, 566)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(597, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtNameDefendant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(TxtLastNameDefendant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtNamePlaintiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(TxtLastNamePlaintiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(Txtclientstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtNameLawyer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(TxtLastNameLawyer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TxtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(TxtClientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAdd)
                    .addComponent(BtnDelete)
                    .addComponent(BtnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnReset)
                    .addComponent(BtnExit))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSearchKeyReleased
        String searchKey = TxtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        TblCase.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_TxtSearchKeyReleased

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
      
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
      

        try {
            connection = helper.getConnection();
            String sql = "insert into cases(description,category,datum,nameDefendant,lastnameDefendant,namePlaintiff,lastnamePlaintiff,clientstatus,historicalData,nameLawyer,lastnameLawyer,userId,clientId) values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, TxtDescription.getText());
            statement.setString(2, TxtCategory.getText());
            statement.setString(3, TxtDatum.getText());
            statement.setString(4, TxtNameDefendant.getText());
            statement.setString(5, TxtLastNameDefendant.getText());
            statement.setString(6, TxtNamePlaintiff.getText());
            statement.setString(7, TxtLastNamePlaintiff.getText());
            statement.setString(8, Txtclientstatus.getText());
            statement.setString(9, TxtHistoricalData.getText());
            statement.setString(10, TxtNameLawyer.getText());
            statement.setString(11, TxtLastNameLawyer.getText());
            statement.setString(12, TxtUserId.getText());
            statement.setString(13, TxtClientId.getText());
            int result= statement.executeUpdate();
            updateDB();
            JOptionPane.showMessageDialog(this, "Erfolgreich hinzugefügt.");
            reset();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        try {
            int row = TblCase.getSelectedRow();
            connection = helper.getConnection();
            String sql = "delete from cases where caseId= "+model.getValueAt(row, 0);
            statement = connection.prepareStatement(sql);

            int result = statement.executeUpdate();
            updateDB();
            JOptionPane.showMessageDialog(this, "Erfolgreich gelöscht.");
            reset();

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed

        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        try {
            int row = TblCase.getSelectedRow();
            connection = helper.getConnection();
            String sql = "update cases set description=? ,category=? ,datum=? ,nameDefendant=? ,lastnameDefendant=? ,namePlaintiff=? ,lastnamePlaintiff=? ,clientstatus=? ,historicalData=? ,nameLawyer=? ,lastnameLawyer=? ,userId=? ,clientId=? where caseId= "+model.getValueAt(row, 0);
            statement = connection.prepareStatement(sql);
           statement.setString(1, TxtDescription.getText());
            statement.setString(2, TxtCategory.getText());
            statement.setString(3, TxtDatum.getText());
            statement.setString(4, TxtNameDefendant.getText());
            statement.setString(5, TxtLastNameDefendant.getText());
            statement.setString(6, TxtNamePlaintiff.getText());
            statement.setString(7, TxtLastNamePlaintiff.getText());
            statement.setString(8, Txtclientstatus.getText());
            statement.setString(9, TxtHistoricalData.getText());
            statement.setString(10, TxtNameLawyer.getText());
            statement.setString(11, TxtLastNameLawyer.getText());
            statement.setString(12, TxtUserId.getText());
            statement.setString(13, TxtClientId.getText());
            int result = statement.executeUpdate();
            updateDB();
            JOptionPane.showMessageDialog(this, "Erfolgreich aktualisiert.");
            reset();

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        reset();
    }//GEN-LAST:event_BtnResetActionPerformed
private JFrame frame;
    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        frame= new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame,"Bestätigen Sie, wenn Sie das Fall-Verwaltungsfenster verlassen möchten","Fall-Verwaltungsfenster",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION )
    {
        System.exit(0);

        }

    }//GEN-LAST:event_BtnExitActionPerformed

    private void TxtUserIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUserIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUserIdActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedValue = (String) jComboBox1.getSelectedItem();
        TxtCategory.setText(selectedValue);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void TxtClientIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtClientIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtClientIdActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String selectedValue = (String) jComboBox2.getSelectedItem();
        Txtclientstatus.setText(selectedValue);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void TblCaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblCaseMouseClicked
     try{  
        int row = TblCase.getSelectedRow();
        String Table_click = (model.getValueAt(row,0).toString());
        String sql = "select* from cases where caseId='"+Table_click+"'";
        String description = (String) model.getValueAt(TblCase.getSelectedRow(), 1);
        String category = (String) model.getValueAt(TblCase.getSelectedRow(), 2);
        String datum = (String) model.getValueAt(TblCase.getSelectedRow(), 3);
        String nameDefendant = (String) model.getValueAt(TblCase.getSelectedRow(), 4);
        String lastnameDefendant = (String) model.getValueAt(TblCase.getSelectedRow(), 5);
        String namePlaintiff = (String) model.getValueAt(TblCase.getSelectedRow(), 6);
        String lastnamePlaintiff = (String) model.getValueAt(TblCase.getSelectedRow(), 7);
        String clientstatus = (String) model.getValueAt(TblCase.getSelectedRow(), 8);
        String historicalData = (String) model.getValueAt(TblCase.getSelectedRow(), 9);
        String nameLawyer = (String) model.getValueAt(TblCase.getSelectedRow(), 10);
        String lastnameLawyer = (String) model.getValueAt(TblCase.getSelectedRow(), 11);
        int userId = (int) model.getValueAt(TblCase.getSelectedRow(), 12);
        int clientId = (int) model.getValueAt(TblCase.getSelectedRow(), 13);
       
        
        
        
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                TxtDescription.setText(description);
                TxtCategory.setText(category);
                TxtDatum.setText(datum);
                TxtNameDefendant.setText(nameDefendant);
                TxtLastNameDefendant.setText(lastnameDefendant);
                TxtNamePlaintiff.setText(namePlaintiff);
                TxtLastNamePlaintiff.setText(lastnamePlaintiff);
                Txtclientstatus.setText(clientstatus);
                TxtHistoricalData.setText(historicalData);
                TxtNameLawyer.setText(nameLawyer);
                TxtLastNameLawyer.setText(lastnameLawyer);
                TxtUserId.setText(Integer.toString(userId));
                TxtClientId.setText(Integer.toString(clientId));
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, ex);
        }
     }
     catch(Exception ex){
     JOptionPane.showMessageDialog(frame, ex);
     }



    }//GEN-LAST:event_TblCaseMouseClicked

    private void TblClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblClientMouseClicked
        try{
        int row = TblClient.getSelectedRow();
        String Table_click = (modelclient.getValueAt(row, 0).toString());
        String sql = "select* from client where clientId='"+Table_click+"'";
        int clientId = (int) modelclient.getValueAt(TblClient.getSelectedRow(), 0);
        String name = (String) modelclient.getValueAt(TblClient.getSelectedRow(), 1);
        String lastname = (String) modelclient.getValueAt(TblClient.getSelectedRow(), 2);
      
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;
        
        try {
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                if ("Angeklagten".equals(Txtclientstatus.getText())){
                TxtNameDefendant.setText(name);
                TxtLastNameDefendant.setText(lastname);
                TxtClientId.setText(Integer.toString(clientId));
                
                }
                if ("Klager".equals(Txtclientstatus.getText())){
                TxtNamePlaintiff.setText(name);
                TxtLastNamePlaintiff.setText(lastname);
                TxtClientId.setText(Integer.toString(clientId));
                
                }
            }
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(frame, ex);
        }

    }//GEN-LAST:event_TblClientMouseClicked

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
            java.util.logging.Logger.getLogger(CaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaseGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JTable TblCase;
    private javax.swing.JTable TblClient;
    private javax.swing.JTextField TxtCategory;
    private javax.swing.JTextField TxtClientId;
    private javax.swing.JFormattedTextField TxtDatum;
    private javax.swing.JTextField TxtDescription;
    private javax.swing.JTextArea TxtHistoricalData;
    private javax.swing.JTextField TxtLastNameDefendant;
    private javax.swing.JTextField TxtLastNameLawyer;
    private javax.swing.JTextField TxtLastNamePlaintiff;
    private javax.swing.JTextField TxtNameDefendant;
    private javax.swing.JTextField TxtNameLawyer;
    private javax.swing.JTextField TxtNamePlaintiff;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JTextField TxtUserId;
    private javax.swing.JTextField Txtclientstatus;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
